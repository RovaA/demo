Application.Controllers.controller('TodoDetailController', function($scope, $routeParams, todoService) {
	var todoDetail = this;
	
	let todoId = $routeParams.id; 

	todoService.find(todoId)
		.then(
			response => todoDetail.entity = response.data, 
			response => console.log("error on finding Entity"));
  });