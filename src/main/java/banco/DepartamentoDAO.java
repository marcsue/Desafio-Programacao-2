package banco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import objetos.Departamento;

public class DepartamentoDAO 
{
	private Connection connection;
	
	public DepartamentoDAO() throws ClassNotFoundException
	{
		this.connection = new ConnectionFactory().getConnection();
	}
	
	public boolean insereDepartamento (Departamento departamento)
	{
		try
		{
			if(departamento.getId()==0)
				return false;
			
			String sql = "insert into Departamento(id,nome) values(?,?);";
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setInt(1, departamento.getId());
			stmt.setString(2,departamento.getNome());
			
			stmt.execute();
			stmt.close();
			
			return true;
		}
		catch (SQLException e)
		{
			return false;
		}
	}
	
	public boolean editarDepartamento(Departamento departamento) throws ClassNotFoundException
	{
		try
		{
			DepartamentoDAO dao = new DepartamentoDAO();
			Departamento dpto = dao.buscaDptoId(departamento.getId());
			
			if(departamento.getId()==0 || dpto.getId()==0)
				return false;
			
			
			
			String sql = "UPDATE Departamento SET nome=? WHERE id=?;";
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setString(1, departamento.getNome());
			stmt.setInt(2, departamento.getId());
			
			stmt.execute();
		
			stmt.close();
			
		
				return true;
		}
		catch (SQLException e)
		{
			return false;
		}
	}
	
	public boolean deleteDepartamento(int idDepartamento)
	{
		try
		{
			//QUANDO NAO TEM DPTO POR ALGUM MOTIVO O BANCO RETORNA ID == 0
			if(buscaDptoId(idDepartamento).getId()!=0)
			{
				String sql = "DELETE FROM Departamento WHERE id=?;";
				PreparedStatement stmt = connection.prepareStatement(sql);
				
				stmt.setInt(1, idDepartamento);
				
				stmt.execute();
				stmt.close();
				return true;
			}
			else
				return false;
		}
		catch (SQLException e)
		{
			return false;
		}
			
	}
	
	public List<Departamento> buscaTodosDpto() throws SQLException
	{
		
		try
		{
			
			String sql = "SELECT * FROM Departamento;" ;
			
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			ResultSet resultado = stmt.executeQuery();
			
			List<Departamento> departamentos = new ArrayList<Departamento>();
			
			while(resultado.next())
			{
				Departamento dpto = new Departamento();
				
				dpto.setId(resultado.getInt("id"));
				dpto.setNome(resultado.getString("nome"));
				
				departamentos.add(dpto);
			}
			
			resultado.close();
			stmt.close();
			
			return departamentos;
		
		}
		catch (SQLException e)
		{
			return null;
		}	
		
	}
	
	public Departamento buscaDptoId (int idDepartamento) throws SQLException
	{
		try
		{
			String sql = "SELECT * FROM Departamento WHERE id=?;" ;
			
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setInt(1, idDepartamento);
			
			ResultSet resultado = stmt.executeQuery();
			
			Departamento dpto = new Departamento();
			
			while(resultado.next())
			{
				dpto.setId(resultado.getInt("id"));
				dpto.setNome(resultado.getString("nome"));			
			}
			
			return dpto;
		}
		catch (SQLException e)
		{
			return null;
		}
	}
}