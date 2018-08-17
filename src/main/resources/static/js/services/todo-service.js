Application.Services.factory('todoService', ['$q', '$rootScope', '$http', 'todoUrl', function($q, $rootScope, $http, todoUrl) {
	return {
		find : function(id) {
			return $http.get(todoUrl + '/' + id);
		},
		findAll : function() {
			return $http.get(todoUrl + '/list');
		},
		createOrUpdate : function(entity) {
			return $http.post(todoUrl + '/create', entity);
		},
		delete : function(entity) {
			return $http.delete(todoUrl + '/delete', {params: {id : entity.id}});
		}
	};
}]);