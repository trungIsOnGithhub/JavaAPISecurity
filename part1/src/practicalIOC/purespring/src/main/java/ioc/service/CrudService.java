package part1.src.practicalIOC.purespring.src.main.java.ioc.service;

import java.util.List;
import java.util.Optional;

public interface CrudService<T> {
    public List<T> getList();

    public Optional<T> get(int id);

    public void update(T object, int id);

    public void delete(int id);
}
