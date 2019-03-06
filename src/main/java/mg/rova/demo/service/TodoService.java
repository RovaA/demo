package mg.rova.demo.service;

import mg.rova.demo.domain.Todo;

import java.util.List;

public interface TodoService extends IsService<Todo, Long> {

    List<Todo> findByText(String text);

}
