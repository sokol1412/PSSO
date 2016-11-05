var maze_app = angular.module('maze_app',[]);

maze_app.controller("BaseController", function($scope, Maze) {
	document.getElementById("generate_solve").addEventListener("click", function(event) 
	{
	var maze = new Maze();	
	maze.solveMaze();
	}, false);
});