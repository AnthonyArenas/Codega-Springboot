package pe.edu.upc.Codega.business.crud.impl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import pe.edu.upc.Codega.business.crud.ProductService;
import pe.edu.upc.Codega.model.entity.Product;
import pe.edu.upc.Codega.model.repository.ProductRepository;

@Service

public class ProductServiceImpl implements ProductService{
    
	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public JpaRepository<Product, Integer> getJpaRepository() {
		return this.productRepository;
	}

	@Override
	public List<Product> findByName(String name) throws Exception {
		return this.productRepository.findByName(name);
	}

}
