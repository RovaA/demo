Application.Services.factory('todoService', function($q, $rootScope, $http) {
	return {
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
});