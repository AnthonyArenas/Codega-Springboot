package pe.edu.upc.Codega.business.crud.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import pe.edu.upc.Codega.business.crud.ListClothingService;

import pe.edu.upc.Codega.model.entity.ListClothing;
import pe.edu.upc.Codega.model.repository.ListClothingRepository;

@Service
public class ListClothingServiceImpl implements ListClothingService {

	@Autowired
	private  ListClothingRepository listClothingRepository;
	
	@Override
	public JpaRepository<ListClothing, Integer> getJpaRepository() {
		
		return this.listClothingRepository;
	}
	
	@Transactional
	@Override
	public ListClothing update(ListClothing entity) throws Exception {
		return listClothingRepository.save(entity);
	}

}
