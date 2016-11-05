var myApp = angular.module('myApp',[]);

window.myApp = myApp;

myApp.controller("BaseController", function($scope, Matrix) {
	$scope.point = {
		x: null,
		y: null
	};

	$scope.matrix = new Matrix([[8, 14]]);


	google.load('visualization', '1', {
		'packages': ['corechart']
	});

	google.setOnLoadCallback(drawChart);

	function drawChart(){
		var data1 = google.visualization.arrayToDataTable([
			['1', 'Data1'], [8, 14]
		]);
		var data2 = google.visualization.arrayToDataTable([
			['2', 'Data2'], [9, 15]
		]);

		data1.addRows($scope.matrix.data1);
		data2.addRows($scope.matrix.data2);

		var options = {
			'title': 'Google Chart',
			'legend': 'bottom',
			'is3D': true,
			hAxis: {
				title: 'X',
				minValue: 0,
				maxValue: 0
			},
			vAxis: {
				title: 'Y',
				minValue: 0,
				maxValue: 0
			},
		};

		// Instantiate and draw our chart, passing in some options.
		var chart = new google.visualization.ScatterChart(document.getElementById('chart_div'));

		var joinedData = google.visualization.data.join(data1, data2, 'full', [[0, 0]], [1], [1]);
		chart.draw(joinedData, options);
	}
	$scope.drawChart = drawChart;
});