package mg.rova.demo.service;

import mg.rova.demo.domain.Todo;
import mg.rova.demo.repository.TodoRepository;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoServiceImpl extends AbsServiceImpl<Todo, Long, TodoRepository> implements TodoService {

	@Autowired
	private ElasticsearchTemplate template;

	@Autowired
	public TodoServiceImpl(TodoRepository repository) {
		super(repository);
	}

	@Override
	public List<Todo> findByText(String text) {
		SearchQuery searchQuery = new NativeSearchQueryBuilder()
				.withQuery(QueryBuilders.matchQuery("text", text))
				.build();
		return template.queryForList(searchQuery, Todo.class);
	}
}
