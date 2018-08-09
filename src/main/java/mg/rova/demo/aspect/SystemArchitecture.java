package mg.rova.demo.aspect;

import java.util.List;
import java.util.logging.Logger;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import mg.rova.demo.domain.Todo;

@Aspect
@Component
public class SystemArchitecture {

	@Pointcut("execution(* mg.rova.demo.controller.TodoController.create(..))")
	private void createTodo() {
	}

	@Pointcut("execution(* mg.rova.demo.controller.TodoController.list(..))")
	private void todoList() {
	}
	
	@AfterReturning(pointcut="mg.rova.demo.aspect.SystemArchitecture.createTodo()", returning="todo")
	public void createTodo(Todo todo) {
		Logger.getLogger(this.getClass().getName()).info(todo.toString());
	}
	
	@AfterReturning(pointcut="mg.rova.demo.aspect.SystemArchitecture.todoList()", returning="entities")
	public void todoList(List<Todo> entities) {
		Logger.getLogger(this.getClass().getName()).info(entities.toString());
	}
}
