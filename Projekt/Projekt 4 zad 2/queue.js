maze_app.factory('Queue', function() {
	function Queue() {
		this.container = [];
	}

	Queue.prototype.pop = function() {
		if (this.container.length > 0) {
			var e = this.container[0];
			this.container.shift();
			return e;
		} else
			alert("Maze impossible to be solved");
	};

	Queue.prototype.pushBack = function(element) {
		this.container.push(element);
	};

	Queue.prototype.empty = function() {
		if (this.container.length === 0)
			return true;
		return false;
	};

	return Queue;
});