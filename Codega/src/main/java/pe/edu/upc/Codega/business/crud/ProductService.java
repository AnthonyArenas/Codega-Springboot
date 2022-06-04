package pe.edu.upc.Codega.business.crud;

import java.util.List;

import pe.edu.upc.Codega.model.entity.Product;

public interface ProductService extends CrudService<Product, Integer> {
	List<Product> findByName(String name) throws Exception;
}
