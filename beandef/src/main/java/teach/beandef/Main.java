package teach.beandef;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String... args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        MailBox mailbox = (MailBox) context.getBean("mailbox");
        System.out.println(mailbox);
    }
}
