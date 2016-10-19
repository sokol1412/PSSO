var myApp = angular.module('myApp',[]);

myApp.controller("BaseController", function($scope, Labirynt) {
	var l = new Labirynt();
	document.getElementById("create").addEventListener("click", function(event) {
    l.rozwiazLabirynt();
}, false);
	
	
	
});