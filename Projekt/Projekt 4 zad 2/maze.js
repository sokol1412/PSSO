maze_app.factory('Maze', function(Queue, Field) {

    function Maze() {
		var Table = document.getElementById("Maze");
		Table.innerHTML = "";
        this.map = [];
        for (var i = 0; i < 10; i++) {
            var row = [];
            var tr = document.createElement("tr");
            for (var j = 0; j < 10; j++) {
                var td = document.createElement("td");
                td.setAttribute("id", i + "_" + j);

                if (Math.floor(Math.random() * 100) + 1 > 80) {
                    if (!(j === 0 && i === 0) && !(j == 9 && i == 9)) {
                        td.appendChild(document.createTextNode("#"));
                        td.style.color = "black";
                        row.push("#");
                    } 
                } else {
                    row.push(" ");
                    td.appendChild(document.createTextNode("~"));
                    td.style.color = "white";
                }
                tr.appendChild(td);
            }
            this.map.push(row);
            var Maze = document.getElementById("Maze").appendChild(tr);
        }
    }

    Maze.prototype.solveMaze = function() {
        notChecked = new Queue();
        notChecked.pushBack(new Field(0, 0, []));
		//var stepsCounter = 0;
        while (true) {
            var field = notChecked.pop();
            if (field.x == 9 && field.y == 9) {
                alert("Maze solved");
                for (var i = 0; i < field.path.length; i++) {
                    var k = field.path[i];
                    document.getElementById(k.x + "_" + k.y).style.color = "black";
                }
                break;
            }
            s = field.path;
            s.push(field);

            this.map[field.x][field.y] = ".";

            var newField = null;
            if (field.x < 9) //down
            {
                if (this.map[(field.x + 1)][field.y] == " ") {
                    newField = new Field(field.x + 1, field.y, s);
                    notChecked.pushBack(newField);                       
                }
            }
            if (field.y < 9) //right
            {
                if (this.map[field.x][(field.y + 1)] == " ") {
                    newField = new Field(field.x, field.y + 1, s);
                    notChecked.pushBack(newField);
                }
            }
            if (field.x > 1) //up
            {
                if (this.map[(field.x - 1)][field.y] == " ") {
                    newField = new Field(field.x - 1, field.y, s);
                    notChecked.pushBack(newField);                    
                }
            }
            if (field.y > 1) //left
            {
                if (this.map[field.x][(field.y - 1)] == " ") {
                    newField = new Field(field.x, field.y - 1, s);
                    notChecked.pushBack(newField);
                }
            }
			//stepsCounter += 1;
        }
		//alert(counter);
    };

    return Maze;
});