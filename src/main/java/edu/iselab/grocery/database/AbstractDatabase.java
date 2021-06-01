package edu.iselab.grocery.database;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import static edu.iselab.grocery.database.AbstractModel.ID_COUNTER;

public abstract class AbstractDatabase<T extends AbstractModel> {

    private Map<Long, T> data;

    public AbstractDatabase() {
        this.data = new ConcurrentHashMap<>();
    }

    public T findById(Long id) {
        return data.get(id);
    }

    public T save(T item) {

        if (item.getId() == null) {
            item.setId(ID_COUNTER++);
            item.setCreatedAt(LocalDateTime.now());
        }

        item.lastModifiedDate = LocalDateTime.now();

        this.data.put(item.getId(), item);

        return item;
    }

    public List<T> findAll(){
        return new ArrayList<>(this.data.values());
    }
}
