package io.testoftiramisu.spring.aop;

import io.testoftiramisu.java.model.Type;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

public class CachingModule implements MethodInterceptor {
    private static final Logger log = LoggerFactory.getLogger(ThrowsLoggingModule.class);
    private static final Map<String, Object> cache = new HashMap<>();

    public Object invoke(MethodInvocation invocation) throws Throwable {
        Object result;
        Type documentType;

        if (log.isDebugEnabled()) {
            log.debug("@@@(CACHING) review is this call is cachable....");

            if ("findByType".equals(invocation.getMethod().getName()) &&
                    invocation.getArguments().length == 1 &&
                    invocation.getArguments()[0] instanceof Type) {
                documentType = (Type) invocation.getArguments()[0];
                log.debug("@@@(CACHING) Is cachable!");

                if (cache.containsKey(documentType.getName())) {
                    log.debug("@@@(CACHING) Found in cache!");
                    return cache.get(documentType.getName());
                }

                log.debug("@@@(CACHING) Not found in cache, but is cachable!");
                result = invocation.proceed();
                cache.put(documentType.getName(), result);
                return result;
            }
        }
        return invocation.proceed();
    }
}
