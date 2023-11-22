package part1.src.practicalIOC.purespring.src.main.java.ioc.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;

import part1.src.practicalIOC.purespring.src.main.java.ioc.repository.MessageRepository;
import part1.src.practicalIOC.purespring.src.main.java.ioc.service.impl.MessageService;

@Configuration
@ComponentScan("part1.src.praticalIOC.purespring")
public class ApplicationConfig {
    @Bean("servicebean")
    public MessageService getMessageService() {
        return new MessageService(getMessageRepository());
    }
    @Bean("repositorybean")
    public MessageRepository getMessageRepository() {
        return new MessageRepository();
    }
}
