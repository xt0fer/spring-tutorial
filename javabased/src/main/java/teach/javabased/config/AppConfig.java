package teach.javabased.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import teach.javabased.BusinessService;

@Configuration
@Import(DatabaseConfig.class)
public class AppConfig {
    @Bean
    public BusinessService getBusinessService() {
        return new BusinessService();
    }
}
