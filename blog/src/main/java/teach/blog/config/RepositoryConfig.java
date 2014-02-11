package teach.blog.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import teach.blog.repository.JazzRepository;
import teach.blog.repository.Repository;

@Configuration
public class RepositoryConfig {

    @Bean
    public Repository repository() {
        return new JazzRepository();
    }
}
