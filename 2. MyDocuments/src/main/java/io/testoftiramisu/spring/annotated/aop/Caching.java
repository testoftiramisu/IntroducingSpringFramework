package io.testoftiramisu.spring.annotated.aop;

import io.testoftiramisu.java.model.Type;
import io.testoftiramisu.spring.aop.ThrowsLoggingModule;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@Aspect
public class Caching {
    private static final Logger log = LoggerFactory.getLogger(ThrowsLoggingModule.class);
    private static final Map<String, Object> cache = new HashMap<>();

    @Around("execution(* io.testoftiramisu.java.service.SearchEngine.*(..))")
    public Object caching(ProceedingJoinPoint pjp) throws Throwable {
        Object result;
        Type documentType;

        if (log.isDebugEnabled()) {
            log.debug("@@@(CACHING) review is this call is cachable....");

            if ("findByType".equals(pjp.getSignature().getName()) && pjp.getArgs().length == 1 && pjp.getArgs()[0] instanceof Type) {
                documentType = (Type) pjp.getArgs()[0];
                log.debug("@@@(CACHING) Is cachable!");

                if (cache.containsKey(documentType.getName())) {
                    log.debug("@@@(CACHING) Found in cache!");
                    return cache.get(documentType.getName());
                }

                log.debug("@@@(CACHING) Not found in cache, but is cachable!");
                result = pjp.proceed();
                cache.put(documentType.getName(), result);
                return result;
            }
        }
        return pjp.proceed();
    }
}
