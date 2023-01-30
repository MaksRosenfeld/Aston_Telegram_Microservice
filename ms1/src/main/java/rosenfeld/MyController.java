package rosenfeld;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/api")
public class MyController {

    @RequestMapping ("/check")
    @ResponseBody
    public String getAnswer() {
        return " I am from Tomcat";
    }
}
