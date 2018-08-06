Application.Controllers.controller('TodoDetailController', ['$scope', '$routeParams', 'todoService', function($scope, $routeParams, todoService) {
	var todoDetail = this;
	
	$scope.editMode = false;
	
	let todoId = $routeParams.id; 

	todoService.find(todoId)
		.then(
			response => todoDetail.entity = response.data, 
			response => console.log("error on finding Entity"));
	
	todoDetail.changeMode = function() {
		$scope.editMode = !$scope.editMode;
	};
	
	todoDetail.updateTodo = function() {
		todoService.createOrUpdate(todoDetail.entity).then(function(response) {
			todoDetail.entity = response.data;
			todoDetail.changeMode();
		});
	};
  }]);