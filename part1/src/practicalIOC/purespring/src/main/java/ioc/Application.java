package part1.src.practicalIOC.purespring.src.main.java.ioc;

import org.springframework.context.ApplicationContext;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import part1.src.practicalIOC.purespring.src.main.java.ioc.config.ApplicationConfig;
import part1.src.practicalIOC.purespring.src.main.java.ioc.model.Message;
import part1.src.practicalIOC.purespring.src.main.java.ioc.service.impl.MessageService;

public class Application {
    public static void main( String[] args ) {
        ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        MessageService ms = ac.getBean("servicebean", MessageService.class);

        System.out.println(
            ms.get(2).get().getText()
        );
        System.out.println(
            ms.get(6).get().getText()
        );
        System.out.println(
            ms.get(8).get().getText()
        );
    }
}
