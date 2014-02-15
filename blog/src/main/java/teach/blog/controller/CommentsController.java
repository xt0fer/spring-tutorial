package teach.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import teach.blog.model.Comment;
import teach.blog.service.BlogService;

import javax.validation.Valid;
import java.util.Date;

@Controller
@RequestMapping("/entry/{entryid}/comment")
public class CommentsController {
    @Autowired
    private BlogService blogService;


    @RequestMapping(value = "/{commentid}/delete", method = RequestMethod.GET)
    public String deleteComment(ModelMap model, @PathVariable("entryid") Long entryId, @PathVariable("commentid") Long commentId) {
        blogService.deleteComment(commentId, entryId);
        return "redirect:/blog/entry/" + entryId;
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addComment(ModelMap model, @PathVariable("entryid") Long entryId) {
        if (blogService.getEntryById(entryId) == null) {
            return "redirect:/blog/";
        }

        model.addAttribute("comment", new Comment());
        return "comment-add";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String saveComment(@Valid @ModelAttribute("comment") Comment comment, BindingResult bindingResult, @PathVariable("entryid") Long entryId) {
        if (blogService.getEntryById(entryId) == null) {
            return "redirect:/blog/";
        }

        if (bindingResult.hasErrors()) {
            return "comment-add";
        }

        blogService.saveComment(comment, entryId);

        return "redirect:/blog/entry/" + entryId;
    }
}
