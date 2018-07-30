angular.module('todoApp', [])
	.controller('TodoListController', function($scope, $http) {
	var todoList = this;
	
	$http.get("/api/todo/list").then(response => todoList.todos = response.data);

	todoList.addTodo = function() {
		$http.post('/api/todo/create', {
			id : null,
			done : false,
			text : todoList.todoText
		}).then(
				response => todoList.todos.push(response.data), 
				response => console.log(response)
		);
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
  });