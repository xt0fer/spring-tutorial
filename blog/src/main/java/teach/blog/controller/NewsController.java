package teach.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import teach.blog.model.News;
import teach.blog.service.NewsService;

import javax.validation.Valid;

@Controller
@RequestMapping("/news")
public class NewsController {

    @Autowired
    private NewsService newsService;

    @RequestMapping(value = "/{index}", method = RequestMethod.GET)
    public String addNews(ModelMap model, @PathVariable("index") Integer index) {
        model.addAttribute("news", newsService.getNewsByIndex(index));
        model.addAttribute("newsindex", index);
        return "news";
    }

    @RequestMapping(value = "/delete/{index}", method = RequestMethod.GET)
    public String deleteNews(ModelMap model, @PathVariable("index") Integer index) {
        newsService.deleteNews(index);
        return "redirect:/index.do";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addNews(ModelMap model) {
        model.addAttribute("news", new News());
        return "addNews";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String saveNews(@Valid @ModelAttribute("news") News news, BindingResult bindingResult, ModelMap model) {
        if (bindingResult.hasErrors()) {
            return "addNews";
        }

        newsService.addNews(news);

        return "redirect:/index.do";
    }
}
