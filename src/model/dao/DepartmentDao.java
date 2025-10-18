
package model.dao;

import java.util.List;

import model.entities.Department;

public interface DepartmentDao {


	void insert (Department obj);// inseri
	void upDate (Department obj);// atualiza 
	void deleteById(Integer id);// deleta
	Department findById(Integer id);// consulta departamento
	List<Department> findAll(); // retorna todos departamentos
	
}
