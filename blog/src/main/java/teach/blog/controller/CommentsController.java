package teach.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/comments")
public class CommentsController {
//
//    @Autowired
//    private NewsService newsService;
//
//    @RequestMapping(value = "/{newsindex}/delete/{commentindex}", method = RequestMethod.GET)
//    public String deleteComment(ModelMap model, @PathVariable("newsindex") Integer newsindex, @PathVariable("commentindex") Integer commentindex) {
//        newsService.deleteComment(newsindex, commentindex);
//        return "redirect:/news/" + newsindex + ".do";
//    }
//
//    @RequestMapping(value = "/{newsindex}/add", method = RequestMethod.GET)
//    public String addComment(ModelMap model, @PathVariable("newsindex") Integer newsindex) {
//        model.addAttribute("comment", new Comment());
//        model.addAttribute("newsindex", newsindex);
//        return "addComment";
//    }
//
//    @RequestMapping(value = "{newsindex}/add", method = RequestMethod.POST)
//    public String saveComment(@Valid @ModelAttribute("comment") Comment comment, BindingResult bindingResult, @PathVariable("newsindex") Integer newsindex, ModelMap model) {
//        if (bindingResult.hasErrors()) {
//            return "addComment";
//        }
//
//        newsService.addComment(newsindex, comment);
//
//        return "redirect:/news/" + newsindex + ".do";
//    }
}
