package part1.src.practicalIOC.purespring.src.main.java.ioc.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import part1.src.practicalIOC.purespring.src.main.java.ioc.model.Message;

public class MessageRepository {
    List<Message> list;

    public MessageRepository() {
        this.list = new ArrayList<>();
    }

    public List<Message> getList() {
        return this.list;
    }

    public Optional<Message> get(int id) {
        return Optional.ofNullable(this.list.get(id));
    }

    public void update(Message object, int id4) {
        this.list.add(object);
    }

    public void delete(int id) {
        this.list.remove(id);
    }

    public List<Message> load() {
        List<Message> ms = new ArrayList<>();
        for (int i=0; i<10; ++i) {
            ms.add(new Message( "Trung Dep Trai " + String.valueOf(i) ));
        }
        return ms;
    }
}
