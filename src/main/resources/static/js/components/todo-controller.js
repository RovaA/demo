Application.Controllers.controller('TodoListController', function($scope, $http, todoService) {
	var todoList = this;

	todoService.findAll()
		.then(
			response => todoList.todos = response.data, 
			reponse => console.log("error on findAll"));

	todoList.addTodo = function() {
		var newTodo = {
			creationDate: null,
			updateDate: null,
			id : null,
			done : false,
			text : todoList.todoText
		}
		todoService.createOrUpdate(newTodo)
			.then(
				response => todoList.todos.push(response.data), 
				response => console.log("error on create"));
		todoList.todoText = '';
	};

	todoList.remaining = function() {
		var count = 0;
		angular.forEach(todoList.todos, function(todo) {
			count += todo.done ? 0 : 1;
		});
		return count;
	};

	todoList.archive = function() {
		var oldTodos = todoList.todos;
		todoList.todos = [];
		angular.forEach(oldTodos, function(todo) {
			if (!todo.done) todoList.todos.push(todo);
		});
	};
	
	todoList.update = function(todo) {
		todoService.createOrUpdate(todo).then(response => {
			todoList.todos.map(x => {
				if (x.id === response.id) {
					return response;
				}
				return x;
			});
		});
	};
	
	todoList.delete = function(todo) {
		todoService.delete(todo).then(response => {
			todoList.todos = todoList.todos.filter(e => e.id !== todo.id);
		});
	};
  });