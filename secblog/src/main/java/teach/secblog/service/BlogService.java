package teach.secblog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import teach.secblog.model.Comment;
import teach.secblog.model.Entry;
import teach.secblog.repository.CommentsRepository;
import teach.secblog.repository.EntriesRepository;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class BlogService {

    @Autowired
    private EntriesRepository entriesRepository;

    @Autowired
    private CommentsRepository commentsRepository;

    public List<Entry> getEntries() {
        return entriesRepository.getEntries();
    }

    public Entry getEntryById(Long id) {
        return entriesRepository.getEntryById(id);
    }

    public List<Comment> getCommentsForEntry(Entry entry) {
        return commentsRepository.getCommentsForEntry(entry);
    }

    @Secured("ROLE_ADMIN")
    public void removeEntryById(Long id) {
        entriesRepository.deleteEntryById(id);
    }

    @Secured("ROLE_ADMIN")
    public void saveEntry(Entry entry) {
        entriesRepository.save(entry);
    }

    @Secured("ROLE_ADMIN")
    public void deleteComment(Long commentId, Long entryId) {
        Comment comment = commentsRepository.getCommentByEntryIdAndCommentId(entryId, commentId);
        if (comment != null) {
            commentsRepository.deleteComment(comment);
        }
    }

    @Secured({"ROLE_USER", "ROLE_ADMIN"})
    public void saveComment(Comment comment, Long entryId) {
        comment.setEntry(getEntryById(entryId));
        comment.setDate(new Date());
        commentsRepository.saveComment(comment);
    }
}
