myApp.factory('Matrix', function() {
	//private variables
	this.data1 = [];
	this.data2 = [];

	//constructor
	function Matrix(data1) {
		this.data1 = data1;
		this.data2 = [];
		generateTheoryPoints(this);
	}

	//public func
	Matrix.prototype.addItem = function(point) {
		this.data1.push([parseInt(point.x), parseInt(point.y)]);
		generateTheoryPoints(this);
	};

	//private func
	function generateTheoryPoints(instance) {
		instance.data2.length = 0;
		for (var i in instance.data1) {
			instance.data2.push([instance.data1[i][0]+1, instance.data1[i][1]+1]);
		}
	}
	return Matrix;
});