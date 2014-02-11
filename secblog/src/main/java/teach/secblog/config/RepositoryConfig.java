package teach.secblog.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import teach.secblog.repository.JazzRepository;
import teach.secblog.repository.Repository;

@Configuration
public class RepositoryConfig {

    @Bean
    public Repository repository() {
        return new JazzRepository();
    }
}
