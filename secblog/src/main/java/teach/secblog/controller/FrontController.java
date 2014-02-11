package teach.secblog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import teach.secblog.service.NewsService;

@Controller
public class FrontController {

    @Autowired
    private NewsService newsService;

    @RequestMapping("/index")
    public String hello(ModelMap model) {
        model.addAttribute("news", newsService.getAllNews());
        return "front";
    }
}
