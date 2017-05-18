package com.greenfox.repository;

import com.greenfox.models.Todo;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Connor on 2017.05.09..
 */
public interface TodoRepository extends CrudRepository<Todo, Long> {

  List<Todo> findByIsDoneEquals (boolean isDone);
}
