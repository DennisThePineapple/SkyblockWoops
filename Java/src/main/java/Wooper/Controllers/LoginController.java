package Wooper.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
    @GetMapping("/addfilter")
    public String login(@RequestParam(name = "key") String key){

        return "";
    }
}
