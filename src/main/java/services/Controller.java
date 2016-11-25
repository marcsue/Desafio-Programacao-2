package services;

import java.sql.SQLException;
import java.util.List;

import objetos.Departamento;
import objetos.Funcionario;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import banco.DepartamentoDAO;
import banco.FuncionarioDAO;

@RestController
public class Controller 
{	
	//CRUD DPTO

	@RequestMapping(value="/addDpto", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE )
	public boolean addDpto(@RequestBody Departamento departamento) throws ClassNotFoundException 
	{	
		return new DepartamentoDAO().insereDepartamento(departamento);
	}

	@RequestMapping(value="/deleteDpto", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE) 
					
	public boolean deleteDpto(@RequestBody Departamento departamento) throws ClassNotFoundException
	{
		return new DepartamentoDAO().deleteDepartamento(departamento.getId());
	}
	
	@RequestMapping(value="/buscaDpto", method = RequestMethod.GET)
	public List<Departamento> buscaDpto() throws ClassNotFoundException, SQLException
	{
		return new DepartamentoDAO().buscaTodosDpto();
	}
	
	@RequestMapping(value="/buscaDptoId", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Departamento buscaDptoId (@RequestBody Departamento departamento) throws ClassNotFoundException, SQLException
	{
		return new DepartamentoDAO().buscaDptoId(departamento.getId());
	}
	
	@RequestMapping(value="/editarDpto", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public boolean  editarDpto (@RequestBody Departamento departamento) throws ClassNotFoundException, SQLException
	{
		return new DepartamentoDAO().editarDepartamento(departamento);
	}

	
	//CRUD FUNCIONARIO

	@RequestMapping(value="/addFun", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE )
	public boolean addFun(@RequestBody Funcionario funcionario) throws ClassNotFoundException 
	{	
		return new FuncionarioDAO().insereFuncionario(funcionario);
	}

	@RequestMapping(value="/deleteFun", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE) 
					
	public boolean deleteFun(@RequestBody Funcionario funcionario) throws ClassNotFoundException
	{
		return new FuncionarioDAO().deleteFuncionario(funcionario.getId());
	}
	
	@RequestMapping(value="/buscaFun", method = RequestMethod.GET)
	public List<Funcionario> buscaFuncionarios() throws ClassNotFoundException, SQLException
	{
		return new FuncionarioDAO().buscaTodosFuncionario();
	}
	
	@RequestMapping(value="/buscaFuncId", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Funcionario buscaFuncId (@RequestBody Funcionario funcionario) throws ClassNotFoundException, SQLException
	{
		return new FuncionarioDAO().buscaFuncId(funcionario.getId());
	}

	@RequestMapping(value="/buscaFuncPorDpto", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public List<Funcionario> buscaFuncPorDpto (@RequestBody Departamento departamento) throws ClassNotFoundException, SQLException
	{
		return new FuncionarioDAO().buscaFuncPorDep(departamento.getId());
	}
	
}
