package teach.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import teach.blog.model.Comment;
import teach.blog.model.News;
import teach.blog.repository.Repository;

import java.util.List;

@Service
public class NewsService {
    @Autowired
    private Repository repository;

    public List<News> getAllNews() {
        return repository.getNews();
    }

    public News getNewsByIndex(Integer index) {
        return repository.getNewsByIndex(index);
    }

    public void addNews(News news) {
        repository.insertNews(news);
    }

    public void addComment(Integer newsindex, Comment comment) {
        repository.insertComment(repository.getNewsByIndex(newsindex), comment);
    }

    public void deleteNews(Integer index) {
        repository.deleteNews(repository.getNewsByIndex(index));
    }

    public void deleteComment(Integer newsindex, Integer commentindex) {
        repository.getNewsByIndex(newsindex).getComments().remove(commentindex);
    }
}
