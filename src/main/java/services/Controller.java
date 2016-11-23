package services;

import java.sql.SQLException;
import java.util.List;

import objetos.Departamento;
import objetos.Funcionario;

import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import banco.DepartamentoDAO;
import banco.FuncionarioDAO;

@RestController
public class Controller 
{	
	//crud dpto

	@RequestMapping(value="/addDpto", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE )
	public boolean addDpto(@RequestBody Departamento departamento) throws ClassNotFoundException 
	{	
		return new DepartamentoDAO().insereDepartamento(departamento);
	}

	
	//deçete com erro
	@RequestMapping(value="/deleteDpto", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE) 
					
	public boolean delete(@RequestBody Departamento departamento) throws ClassNotFoundException
	{
		
		return new DepartamentoDAO().deleteDepartamento(departamento.getId());
	}
	
	@RequestMapping(value="/buscaDpto", method = RequestMethod.GET)
	public List<Departamento> busca() throws ClassNotFoundException, SQLException
	{
		return new DepartamentoDAO().buscaTodos();
	}
	
	
}
