package mg.rova.demo.repository.elastic;

import mg.rova.demo.domain.Todo;
import org.springframework.data.elasticsearch.repository.ElasticsearchCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoSearchRepository extends ElasticsearchCrudRepository<Todo, Long> {

    List<Todo> findByText(String text);

}
