Application.Services.factory('todoService', ['$q', '$rootScope', '$http', function($q, $rootScope, $http) {
	return {
		find : function(id) {
			return $http.get('/api/todo/' + id);
		},
		findAll : function() {
			return $http.get('/api/todo/list');
		},
		createOrUpdate : function(entity) {
			return $http.post('/api/todo/create', entity);
		},
		delete : function(entity) {
			return $http.delete('/api/todo/delete', {params: {id : entity.id}});
		}
	};
}]);