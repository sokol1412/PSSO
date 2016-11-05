maze_app.factory('Field', function() {
	this.x = null;
	this.y = null;
	this.path = [];

	function Field(x,y,s)
    {
        this.x = x;
        this.y = y;
        this.path = [];
        for (var i = 0; i < s.length; i++)
            this.path.push(s[i]);
    }
	return Field;
});