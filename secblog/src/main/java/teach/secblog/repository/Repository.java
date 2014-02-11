package teach.secblog.repository;


import teach.secblog.model.Comment;
import teach.secblog.model.News;

import java.util.List;

public interface Repository {
    List<News> getNews();

    News getNewsByIndex(int index);

    void insertNews(News news);

    void deleteNews(News news);

    void insertComment(News news, Comment comment);

    void deleteComment(News news, Comment comment);
}
