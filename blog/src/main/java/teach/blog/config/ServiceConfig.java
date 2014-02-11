package teach.blog.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import teach.blog.repository.Repository;

@Configuration
@ComponentScan("teach.blog.service")
public class ServiceConfig {
}
