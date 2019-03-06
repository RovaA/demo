Application.Services.factory('todoService', ['$q', '$rootScope', '$http', 'todoUrl', function($q, $rootScope, $http, todoUrl) {
	return {
		findByText : function (text) {
			return $http.get(todoUrl + '/find/' + text);
		}
	};
}]);

Application.Services.factory('Todo', ['$resource', function($resource) {
	return $resource('/api/todo', {});
}]);