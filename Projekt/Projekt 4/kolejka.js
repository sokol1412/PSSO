myApp.factory('Kolejka', function() {
	function Kolejka() {
		this.kontener = [];
	}

	Kolejka.prototype.pop = function() {
		if (this.kontener.length > 0) {
			var e = this.kontener[0];
			this.kontener.shift();
			return e;
		} else
			alert("Labirynt nie do rozwiazania");
	};

	Kolejka.prototype.pushBack = function(element) {
		this.kontener.push(element);
	};

	Kolejka.prototype.pusta = function() {
		if (this.kontener.length === 0)
			return true;
		return false;
	};

	return Kolejka;
});