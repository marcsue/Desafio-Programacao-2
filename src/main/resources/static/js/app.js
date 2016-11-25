var appDepartamento =  angular.module("appDepartamento",[]);

//controllers
//$scope é um objeto do angular identificado pelo $
appDepartamento.controller("indexController", function ($scope, $http){
	
	$scope.departamentos =[];
	$scope.departamento={};
	
	//1 par = function sucess / 2 par function insucess
	
	$scope.buscaDpto= function()
	{
		$http({method:'GET',url:'http://localhost:8080/buscaDpto'})
		.then(function (response){
			
			$scope.departamentos=response.data;
			console.log(response.status);
			
		},function (response){
			console.log(response.data);
			console.log(response.status);
			
		});
	};
	
	$scope.addDpto=function()
	{
		$http({method:'POST',url:'http://localhost:8080/addDpto',data:$scope.departamento})
		.then(function (response){
			
			
			if ($scope.departamentos=response.data)
			{
				alert(" inserido com sucess");
				$scope.buscaDpto();
			
			}
				
			else 
			{
				alert(" esse dpto ja existe");
				$scope.buscaDpto();
			}
			
			console.log(response.status);
		},function (response){
			
			
			console.log(response.status);
			alert("erro ");
			
		});
		
		
	}
	
	$scope.deleteDpto=function()
	{
		$http({method:'POST',url:'http://localhost:8080/deleteDpto',data:$scope.departamento})
		
		.then(function (response){
			
			
		if ($scope.departamentos.id=response.data)
		{
			alert(" removido com sucesso");
			$scope.buscaDpto();
			
		}
				
			else 
			{
				alert(" esse dpto nao existe ou n pode ser removido");
				$scope.buscaDpto();
			}
			
			console.log(response.status);
		},function (response){
			
			
			console.log(response.status);
			alert("erro ");
			
		});
		
		
	}
	
	$scope.editarDpto=function(dpar)
	{
		$scope.departamento = dpar;
		
	}
	
	$scope.buscaDpto();
	
	
	   
});




