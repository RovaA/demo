package mg.rova.demo.controller;

import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import mg.rova.demo.domain.Todo;
import mg.rova.demo.service.TodoService;

@RunWith(SpringJUnit4ClassRunner.class)
public class WebApplicationContextTodoControllerTest {

	private MockMvc mockMvc;

	@InjectMocks
	private TodoController todoController;
	
	@MockBean
	private TodoService service;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(todoController).build();
	}

	@Test
	public void create() {

		final Todo todo = new Todo();

		final TodoController todoController = new TodoController(mock(TodoService.class));
		doReturn(todo).when(todoController.service).save(todo);

		assertSame(todo, todoController.create(todo));
		verify(todoController.service).save(todo);
	}

	@Test
	public void list() {

		final List<Todo> list = new ArrayList<>();

		final TodoController todoController = new TodoController(mock(TodoService.class));
		when(todoController.service.findAll()).thenReturn(list);

		assertSame(list, todoController.list());
		verify(todoController.service).findAll();
	}

	@Test
	public void findAll() throws Exception {

		mockMvc.perform(get("/api/todo/list")).andExpect(status().isOk());

		verify(todoController.service).findAll();
	}
}
