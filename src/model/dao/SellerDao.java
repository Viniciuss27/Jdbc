
package model.dao;

import java.util.List;

import model.entities.Seller;

public interface SellerDao {


	void insert (Seller obj);// inseri
	void upDate (Seller obj);// atualiza 
	void deleteById(Integer id);// deleta
	Seller findById(Integer id);// consulta departamento
	List<Seller> findAll(); // retorna todos departamentos
	
}
