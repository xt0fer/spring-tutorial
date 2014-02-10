package teach.beanfactory;

import org.springframework.beans.factory.support.BeanDefinitionReader;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.PropertiesBeanDefinitionReader;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

public class Main {
    public static void main(String... args) {
        /* Deprecated, use XmlBeanDefinitionReader instead */
        XmlBeanFactory xmlBeanFactory = new XmlBeanFactory(new ClassPathResource("beans.xml"));

        /* Using XmlBeanDefinitionReader */
        DefaultListableBeanFactory listableBeanFactory = new DefaultListableBeanFactory();
        BeanDefinitionReader reader = new XmlBeanDefinitionReader(listableBeanFactory);
        reader.loadBeanDefinitions(new ClassPathResource("beans.xml"));

        Message message1 = (Message) xmlBeanFactory.getBean("helloWorld");
        Message message2 = (Message) listableBeanFactory.getBean("helloWorld");

        System.out.println(message1);
        System.out.println(message2);
        System.out.println(message1 == message2);
    }
}
