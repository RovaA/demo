Application.Filters.filter('isDone', function() {
	return function (items, isDone) {
		var filtered = [];
		if (!isDone)
			return items;
		return items.filter(x => x.done === isDone);
	};
});