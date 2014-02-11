package teach.webhello.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

@Controller
public class HelloController {

    @RequestMapping("/index")
    public String hello(ModelMap model) {
        model.addAttribute("date", new Date());
        return "hello";
    }
}
