package teach.blog.repository;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import teach.blog.model.Comment;
import teach.blog.model.Entry;

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
}
