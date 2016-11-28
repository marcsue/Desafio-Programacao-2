var app =  angular.module("app",["ngRoute"]);

app.config(function($routeProvider, $locationProvider){

	$routeProvider
	.when("/departamento",{
		templateUrl:'views/departamento.html',
		controller:'departamentoController'
			
		
		}).when("/funcionario",{
			templateUrl:'views/funcionario.html',
			controller:'funcionarioController'
			})
		.otherwise({rediretTo:''});
	
	$locationProvider.html5Mode(true);

});