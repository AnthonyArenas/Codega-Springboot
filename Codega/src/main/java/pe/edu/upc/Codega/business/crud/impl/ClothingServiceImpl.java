package pe.edu.upc.Codega.business.crud.impl;

import java.io.Serializable;


import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import pe.edu.upc.Codega.business.crud.ClothingService;
import pe.edu.upc.Codega.model.entity.Clothing;
import pe.edu.upc.Codega.model.repository.ClothingRepository;


@Service
public class ClothingServiceImpl implements ClothingService, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	private  ClothingRepository clothingRepository;
	
	@Override
	public JpaRepository<Clothing, Integer> getJpaRepository() {
		
		return this.clothingRepository;
	}

	@Transactional
	@Override
	public Clothing update(Clothing entity) throws Exception {
		return clothingRepository.save(entity);
	}


}
