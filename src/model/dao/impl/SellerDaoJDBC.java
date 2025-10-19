package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import db.DB;
import db.DbException;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class SellerDaoJDBC implements SellerDao{
	
	private Connection conn;
	
	public SellerDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void insert(Seller obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void upDate(Seller obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Seller findById(Integer id) {
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			st = conn.prepareStatement(// faz a pesquisa no banco de dados
					"SELECT  Seller.*, department.Name as DepName " +
					"From Seller Inner Join department " +
					"on Seller.departmentId = department.Id " +
					"where seller.Id = ?");
			
			st.setInt(1, id);
			rs = st.executeQuery();
		
			if(rs.next()) {// testa se veio algum resultado
				
				Department dep = new Department();// entra no department
				
				dep.setId(rs.getInt("DepartmentId"));// pega o id do DepartmentId
				dep.setName(rs.getString("DepName"));// pega o nome 
				
				Seller slr = new Seller();// entra no Seller
				
				slr.setId(rs.getInt("Id"));
				slr.setName(rs.getString("Name"));
				slr.setEmail(rs.getString("Email"));
				slr.setBirthDate(rs.getDate("BirthDate"));
				slr.setBaseSalary(rs.getDouble("BaseSalary"));
				slr.setDepartment(dep);// seller associa com department
				
				return slr;
				
			}
			return null;
		}
		catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
	}

	@Override
	public List<Seller> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
