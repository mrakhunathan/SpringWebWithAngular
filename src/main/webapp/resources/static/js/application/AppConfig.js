rootApp.config([ '$routeProvider', function($routeProvider) {
	$routeProvider.when('/index', {
		templateUrl : 'resources/static/html/index.html',
		controller : 'rootController'
	}).when('/results', {
		templateUrl : 'resources/static/html/Results.html',
		controller : 'rootController'
	}).otherwise({
		redirectTo : '/index'
	})
} ]);
