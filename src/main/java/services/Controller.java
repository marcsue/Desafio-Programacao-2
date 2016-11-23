package services;

import java.sql.SQLException;
import java.util.List;

import objetos.Departamento;
import objetos.Funcionario;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import banco.FuncionarioDAO;

@RestController
public class Controller 
{

	@RequestMapping("/greeting")
    public String greeting(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "index";
	}
	
	@RequestMapping(value="/departamento", method = RequestMethod.GET)
	public boolean crud() throws ClassNotFoundException, SQLException
	{
		/*DepartamentoDAO dao = new DepartamentoDAO();
		
		Departamento dap = new Departamento(6,"seis");
		
		Departamento dpta = new Departamento(5,"xinco");
		
		dao.insereDepartamento(dpto);
		dao.editarDepartamento(dpto, dpta);
		dao.insereDepartamento(dap);*/
		
		Departamento dpto = new Departamento(5,"cinco");
		
		FuncionarioDAO dao = new FuncionarioDAO();
		
		Funcionario fun = new Funcionario(5, "joao", "lul", 21, 5, dpto);
		Funcionario func = new Funcionario(5, "maria", "lul", 21, 12, dpto);
		
		
		//dao.insereFuncionario(fun);
		
		
	
		return dao.editarFuncionario(fun, func);
	}

	@RequestMapping(value="/delete", method = RequestMethod.GET)
	public boolean delete() throws ClassNotFoundException
	{
		FuncionarioDAO dao = new FuncionarioDAO();
	
	
		return dao.deleteFuncionario(2);
	}
	
	@RequestMapping(value="/busca", method = RequestMethod.GET)
	public List<Funcionario> busca() throws ClassNotFoundException, SQLException
	{
		FuncionarioDAO dao = new FuncionarioDAO();	
		
	
		return dao.buscaFuncPorDep(5);
	}
	
	
}
