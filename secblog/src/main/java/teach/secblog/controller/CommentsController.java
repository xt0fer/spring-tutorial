package teach.secblog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import teach.secblog.model.Comment;
import teach.secblog.service.NewsService;

import javax.validation.Valid;

@Controller
@RequestMapping("/comments")
public class CommentsController {

    @Autowired
    private NewsService newsService;

    @RequestMapping(value = "/delete/{newsindex}/{commentindex}", method = RequestMethod.GET)
    public String deleteComment(ModelMap model, @PathVariable("newsindex") Integer newsindex, @PathVariable("commentindex") Integer commentindex) {
        newsService.deleteComment(newsindex, commentindex);
        return "redirect:/news/" + newsindex + ".do";
    }

    @RequestMapping(value = "/add/{newsindex}", method = RequestMethod.GET)
    public String addComment(ModelMap model, @PathVariable("newsindex") Integer newsindex) {
        model.addAttribute("comment", new Comment());
        model.addAttribute("newsindex", newsindex);
        return "addComment";
    }

    @RequestMapping(value = "/add/{newsindex}", method = RequestMethod.POST)
    public String saveComment(@Valid @ModelAttribute("comment") Comment comment, BindingResult bindingResult, @PathVariable("newsindex") Integer newsindex, ModelMap model) {
        if (bindingResult.hasErrors()) {
            return "addComment";
        }

        newsService.addComment(newsindex, comment);

        return "redirect:/news/" + newsindex + ".do";
    }
}
