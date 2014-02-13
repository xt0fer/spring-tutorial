package teach.javabased;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import teach.javabased.config.AppConfig;

public class Main {

    public static void main(String... args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

//        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
//        context.register(DatabaseConfig.class, AppConfig.class);
//        context.refresh();

//        BusinessService businessService = (BusinessService) context.getBean("getBusinessService");
        BusinessService businessService = context.getBean(BusinessService.class);
        businessService.doSomeLogic();
    }
}
