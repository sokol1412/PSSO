myApp.factory('Pole', function() {
	//private variables
	this.x = null;
	this.y = null;
	this.droga = [];

	function Pole(x,y,s)
    {
        this.x = x;
        this.y = y;
        this.droga = [];
        for (var i = 0; i < s.length; i++)
            this.droga.push(s[i]);
    }

	return Pole;
});