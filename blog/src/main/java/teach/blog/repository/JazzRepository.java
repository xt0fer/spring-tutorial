package teach.blog.repository;

import teach.blog.model.Comment;
import teach.blog.model.News;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* Repository improvisation */
public class JazzRepository implements Repository {
    private List<News> news = new ArrayList<>();

    @PostConstruct
    public void init() {
        News n1 = new News();
        n1.setTitle("Noutate 1");
        n1.setDate(new Date());
        n1.setContent("Continut noutate 1");

        News n2 = new News();
        n2.setTitle("Noutate 2");
        n2.setDate(new Date());
        n2.setContent("Continut noutate 2");

        News n3 = new News();
        n3.setTitle("Noutate 3");
        n3.setDate(new Date());
        n3.setContent("Continut noutate 3");

        news.add(n1);
        news.add(n2);
        news.add(n3);
    }

    @Override
    public List<News> getNews() {
        return news;
    }

    @Override
    public News getNewsByIndex(int index) {
        return news.get(index);
    }

    @Override
    public void insertNews(News news) {
        news.setDate(new Date());
        this.news.add(news);
    }

    @Override
    public void deleteNews(News news) {
        this.news.remove(news);
    }

    @Override
    public void insertComment(News news, Comment comment) {
        if (news.getComments() == null) {
            news.setComments(new ArrayList<Comment>());
        }
        comment.setDate(new Date());
        news.getComments().add(comment);
    }

    @Override
    public void deleteComment(News news, Comment comment) {
        news.getComments().remove(comment);
    }
}
