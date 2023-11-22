package part1.src.practicalIOC.purespring.src.main.java.ioc.service.impl;

import java.util.List;
import java.util.Optional;

 import org.springframework.beans.factory.annotation.Autowired;

import part1.src.practicalIOC.purespring.src.main.java.ioc.model.Message;
import part1.src.practicalIOC.purespring.src.main.java.ioc.repository.MessageRepository;
import part1.src.practicalIOC.purespring.src.main.java.ioc.service.CrudService;

public class MessageService implements CrudService<Message> {
    MessageRepository repository;

    public MessageService(MessageRepository repository) {
        this.repository = repository;

        this.repository.load();
    }

    @Override
    public List<Message> getList() {
        return this.repository.getList();
    }

    @Override
    public Optional<Message> get(int id) {
        return this.repository.get(id);
    }

    @Override
    public void update(Message object, int id) {
        this.repository.update(object, id);
    }

    @Override
    public void delete(int id) {
        this.repository.delete(id);
    }
}
