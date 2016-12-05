app.controller("departamentoController", function ($scope, $http){
	
	$scope.departamentos =[];
	$scope.departamento={};
		
	$scope.buscaDpto = function()
	{
		$http({method:'GET',url:'http://localhost:8080/buscaDpto'})
		.then(function (response)
		{
			
			$scope.departamentos=response.data;
			console.log(response.data);
			console.log(response.status);
			
		},function (response)
		{
			console.log(response.data);
			console.log(response.status);
			
		});
	};
	
	$scope.addDpto=function()
	{
		$http({method:'POST',url:'http://localhost:8080/addDpto',data:$scope.departamento})
		.then(function (response)
		{
			
			if (response.data){
				alert(" inserido com sucess");
				$scope.limparCampos();
			
			}
				
				
			else 
				alert(" esse dpto ja existe");
			
			console.log(response.data);
			console.log(response.status);
			
		},function (response)
		{
			
			alert("erro ");
			
			console.log(response.data);
			console.log(response.status);
						
		});
	};
	
	
	$scope.deleteDpto=function(departamento)
	{
		$http({method:'POST',url:'http://localhost:8080/deleteDpto',data:departamento})
		.then(function (response)
		{			
				if (response.data) 
					alert(" removido com sucesso");
					
				else 
					alert(" esse dpto nao pode ser removido pq temos funcioanrios nele");
			
			
			console.log(response.status);
			console.log(response.data);
			
		},function (response)
		{

			console.log(response.status);
			console.log(response.data);
			alert("erro ");
			
		});	
		
	};
	
	$scope.editarDpto=function(dpar)
	{
		$scope.departamento.nome = dpar.nome;
		$scope.departamento.id = dpar.id;
		
		console.log(response.status);
		console.log(response.data);
		
	};
	
	$scope.limparCampos=function()
	{
		$scope.departamento= {};
		
		console.log(response.status);
		console.log(response.data);	
	};
	
	$scope.update=function()
	{
		$http({method:'POST',url:'http://localhost:8080/editarDpto',data:$scope.departamento})
		.then(function (response)
		{
			
			if (response.data)
			{
				alert(" alterado com sucesso");
				$scope.limparCampos();
			}
				
					
			else 
				alert(" esse dpto nao existe");
			
			
			
			console.log(response.status);
			console.log(response.data);
		
		},function (response)
		{	
			alert("erro ");
			console.log(response.status);
			console.log(response.data);
			
		});
	};
	
	
});


