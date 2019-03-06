package mg.rova.demo.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import mg.rova.demo.domain.Todo;
import mg.rova.demo.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.IndexQuery;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class BulkIndexer {

    @Autowired
    private ElasticsearchTemplate template;

    @Autowired
    private TodoRepository todoRepository;

    @EventListener(ContextRefreshedEvent.class)
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        List<IndexQuery> indexes = todoRepository.findAll()
                .stream()
                .map(this::newIndex)
                .collect(Collectors.toList());
        if (indexes.size() > 0)
            template.bulkIndex(indexes);

        template.refresh("demo");
    }

    IndexQuery newIndex(Todo todo) {

        final ObjectMapper objectMapper = new ObjectMapper();

        IndexQuery indexQuery = new IndexQuery();
        indexQuery.setId(todo.getId().toString());
        indexQuery.setIndexName("demo");
        indexQuery.setType("todo");
        try {
            indexQuery.setSource(objectMapper.writeValueAsString(todo));
        } catch (JsonProcessingException e) {
        }
        return indexQuery;
    }
}
