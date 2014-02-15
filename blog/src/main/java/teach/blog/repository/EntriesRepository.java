package teach.blog.repository;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import teach.blog.model.Entry;

import java.util.List;

@Repository
public class EntriesRepository {

    @Autowired
    private SessionFactory sessionFactory;

    public List<Entry> getEntries() {
        return sessionFactory
                .getCurrentSession()
                .createCriteria(Entry.class)
                .addOrder(Order.desc("date"))
                .list();
    }

    public Entry getEntryById(Long id) {
        return (Entry) sessionFactory
                .getCurrentSession()
                .get(Entry.class, id);
    }

    public void deleteEntryById(Long id) {
        Entry entry = getEntryById(id);
        if (entry != null) {
            sessionFactory
                    .getCurrentSession()
                    .delete(entry);
        }
    }

    public void save(Entry entry) {
        sessionFactory
                .getCurrentSession()
                .saveOrUpdate(entry);
    }
}
