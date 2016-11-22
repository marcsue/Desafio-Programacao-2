package banco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import objetos.Departamento;
import objetos.Funcionario;;

public class FuncionarioDAO 
{
	private Connection connection;
	
	public FuncionarioDAO() throws ClassNotFoundException
	{
		this.connection = new ConnectionFactory().getConnection();
	}
	
	public boolean insereFuncionario (Funcionario funcionario)
	{
		try
		{
			String sql = "insert into Funcionario(id,nome,cargo,idade,salario,idDepartamento) values(?,?,?,?,?,?);";
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setInt(1, funcionario.getId());
			stmt.setString(2,funcionario.getNome());
			stmt.setString(3,funcionario.getCargo());
			stmt.setInt(4, funcionario.getIdade());
			stmt.setFloat(5, funcionario.getSalario());
			stmt.setInt(6, funcionario.getDepartamento().getId());
			
			
			stmt.execute();
			stmt.close();
			
			return true;
		}
		catch (SQLException e)
		{
			return false;
		}
	}
	
	public boolean editarFuncionario(Funcionario antigo, Funcionario novo)
	{
		try
		{
			String sql = "UPDATE Funcionario SET id=?,nome=?,cargo=?, idade=?,salario=?,idDepartamento=? WHERE id=?;";
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setInt(1,novo.getId());
			stmt.setString(2, novo.getNome());
			stmt.setString(3,novo.getCargo());
			stmt.setInt(4, novo.getIdade());
			stmt.setFloat(5, novo.getSalario());
			stmt.setInt(6, novo.getDepartamento().getId());
			
			
			stmt.setInt(7, antigo.getId());
			
			
			stmt.execute();
			stmt.close();
			
			return true;
		}
		catch (SQLException e)
		{
			return false;
		}
	}
	
	public boolean deleteFuncionario(int idFuncionario)
	{
		try
		{
				String sql = "DELETE FROM Funcionario WHERE id=?;";
				PreparedStatement stmt = connection.prepareStatement(sql);
				
				stmt.setInt(1, idFuncionario);
				
				stmt.execute();
				stmt.close();
				return true;
		}
		catch (SQLException e)
		{
			return false;
		}
			
	}
	
	public List<Funcionario> buscaTodos() throws SQLException, ClassNotFoundException
	{
		
		try
		{
			DepartamentoDAO dpto = new DepartamentoDAO();
			Departamento departamento = new Departamento();
			List<Funcionario> funcionarios = new ArrayList<Funcionario>();
			
			String sql = "SELECT * FROM Funcionario;" ;
			
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			ResultSet resultado = stmt.executeQuery();
			
			while(resultado.next())
			{
				Funcionario func = new Funcionario();
				
				func.setId(resultado.getInt("id"));
				func.setNome(resultado.getString("nome"));
				func.setCargo(resultado.getString("cargo"));
				func.setIdade(resultado.getInt("idade"));
				func.setSalario(resultado.getFloat("salario"));
			
				departamento = dpto.buscaDpto(resultado.getInt("idDepartamento"));
				
				func.setDepartamento(departamento);
				
				funcionarios.add(func);
				
				
			}
			
			resultado.close();
			stmt.close();
			
			return funcionarios;
		
		}
		catch (SQLException e)
		{
			return null;
		}
	}
	
	
	public List <Funcionario> buscaFuncPorDep (int idDepartamento) throws ClassNotFoundException
	{
		try
		{
			DepartamentoDAO dpto = new DepartamentoDAO();
			Departamento departamento = new Departamento();
			List<Funcionario> funcionarios = new ArrayList<Funcionario>();
			
			String sql ="SELECT * FROM Funcionario WHERE idDepartamento=?;";
			
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setInt(1,idDepartamento);
			
			ResultSet resultado = stmt.executeQuery();

			while(resultado.next())
			{
				Funcionario func = new Funcionario();
				
				func.setId(resultado.getInt("id"));
				func.setNome(resultado.getString("nome"));
				func.setCargo(resultado.getString("cargo"));
				func.setIdade(resultado.getInt("idade"));
				func.setSalario(resultado.getFloat("salario"));
			
				departamento = dpto.buscaDpto(resultado.getInt("idDepartamento"));
				
				func.setDepartamento(departamento);
				
				funcionarios.add(func);
				
			}
			
			resultado.close();
			stmt.close();
			
			return funcionarios;
		}
		catch (SQLException e)
		{
			return null;
		}
	}
	
	public Funcionario buscaFuncionario (int idFuncionario) throws ClassNotFoundException
	{
		try
		{
			DepartamentoDAO dpto = new DepartamentoDAO();
			
			Departamento departamento = new Departamento();
			Funcionario func = new Funcionario();
			
			String sql = "SELECT * FROM Funcionario WHERE id = ?;";
			
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setInt(1, idFuncionario);
			
			
			ResultSet resultado = stmt.executeQuery();
			
			while (resultado.next())
			{
				func.setId(resultado.getInt("id"));
				func.setNome(resultado.getString("nome"));
				func.setCargo(resultado.getString("cargo"));
				func.setIdade(resultado.getInt("idade"));
				func.setSalario(resultado.getFloat("salario"));
			
				departamento = dpto.buscaDpto(resultado.getInt("idDepartamento"));
				
				func.setDepartamento(departamento);
			}
			
			return func;
		}
		catch (SQLException e)
		{
			return null;
		}
	}
	
}























