package teach.secblog.repository;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import teach.secblog.model.Comment;
import teach.secblog.model.Entry;

import java.util.List;

@Repository
public class CommentsRepository {

    @Autowired
    private SessionFactory sessionFactory;

    public List<Comment> getCommentsForEntry(Entry entry) {
        return sessionFactory
                .getCurrentSession()
                .createCriteria(Comment.class)
                .add(Restrictions.eq("entry", entry))
                .addOrder(Order.asc("date"))
                .list();
    }

    public Comment getCommentById(Long id) {
        return (Comment) sessionFactory
                .getCurrentSession()
                .get(Comment.class, id);
    }

    public void deleteComment(Comment comment) {
        sessionFactory
                .getCurrentSession()
                .delete(comment);
    }

    public Comment getCommentByEntryIdAndCommentId(Long entryId, Long commentId) {
        return (Comment) sessionFactory
                .getCurrentSession()
                .createCriteria(Comment.class)
                .add(
                        Restrictions.and(
                                Restrictions.eq("entry.id", entryId),
                                Restrictions.eq("id", commentId)
                        )
                )
                .uniqueResult();
    }

    public void saveComment(Comment comment) {
        sessionFactory
                .getCurrentSession()
                .saveOrUpdate(comment);
    }
}
