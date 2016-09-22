import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody

@Controller
class MyApp {

    @RequestMapping("/")
    @ResponseBody
    String message() {
        return "<h3>Hello world!</h3>"
    }

}
