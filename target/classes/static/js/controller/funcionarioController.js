app.controller("funcionarioController", function ($scope, $http){
	
	$scope.funcionarios = [];
	$scope.funcionario= {};
	
	$scope.funcsDpto = [];
		
	$scope.buscaFun= function()
	{
		$http({method:'GET',url:'http://localhost:8080/buscaFun'})
		.then(function (response)
		{
			
			$scope.funcionarios=response.data;
			console.log(response.data);
			console.log(response.status);
			
		},function (response)
		{
			console.log(response.data);
			console.log(response.status);
			
		});
	};
	
	$scope.addFun=function()
	{
		$http({method:'POST',url:'http://localhost:8080/addFun',data:$scope.funcionario})
		.then(function (response)
		{
			
			if (response.data)
			{
				alert(" inserido com sucess");
				$scope.limparCampos();
			}
				
				
			else 
				alert(" esse fun ja existe ou id = 0");
			
			
			
			console.log(response.data);
			console.log(response.status);
			
		},function (response)
		{
			
			alert("erro ");
			
			console.log(response.data);
			console.log(response.status);
						
		});
	};
	
	$scope.deleteFun=function(funcionario)
	{
		$http({method:'POST',url:'http://localhost:8080/deleteFun',data:funcionario})
		.then(function (response)
		{	
			if (response.data)
				alert(" removido com sucesso");
				
			else 
				alert(" esse func nao pode ser removido");
				
			
			
			console.log(response.status);
			console.log(response.data);
			
		},function (response)
		{

			console.log(response.status);
			console.log(response.data);
			alert("erro ");
			
		});
		
		
	};
	
	$scope.editarFun=function(fun)
	{
		$scope.funcionario.nome = fun.nome;
		$scope.funcionario.id = fun.id;
		$scope.funcionario.cargo = fun.cargo;
		$scope.funcionario.idade = fun.idade;
		$scope.funcionario.salario = fun.salario;
		$scope.funcionario.departamento = fun.departamento;
		$scope.funcionario.departamento = fun.departamento;
		console.log(response.status);
		console.log(response.data);
		
	};
	
	$scope.updateFun=function()
	{
		$http({method:'POST',url:'http://localhost:8080/editarFun',data:$scope.funcionario})
		.then(function (response)
		{
			
			if (response.data)
			{
				alert(" alterado com sucesso");
				$scope.limparCampos();
			}		
			else 
				alert(" esse func nao existe ou id = 0 ou dpto nao existe");
			
				
			
			
			console.log(response.status);
			console.log(response.data);
		
		},function (response)
		{	
			alert("erro ");
			console.log(response.status);
			console.log(response.data);
			
		});
	};
	
	$scope.limparCampos=function()
	{
		$scope.funcionario= {};
		
		console.log(response.status);
		console.log(response.data);	
	};
	
	$scope.buscaFunDpto=function()
	{
		$http({method:'POST',url:'http://localhost:8080/buscaFunPorDpto',data:$scope.funcionario.departamento})
		.then(function (response)
		{
			
			
				
				$scope.funcsDpto=response.data;
				console.log(response.data);
				console.log(response.status);
				
			},function (response)
			{
				console.log(response.data);
				console.log(response.status);
				
			});
	};
	
	
	
	
	
	
});


