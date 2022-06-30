package pe.edu.upc.Codega.business.crud.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import pe.edu.upc.Codega.business.crud.ListClothingService;
import pe.edu.upc.Codega.model.entity.Categories;

import pe.edu.upc.Codega.model.entity.ListClothing;

import pe.edu.upc.Codega.model.entity.Seller;
import pe.edu.upc.Codega.model.repository.CategoriesRepository;
import pe.edu.upc.Codega.model.repository.ListClothingRepository;
import pe.edu.upc.Codega.model.repository.SellerRepository;

@Service
public class ListClothingServiceImpl implements ListClothingService {

	@Autowired
	private  ListClothingRepository listClothingRepository;
	
	@Autowired
	private  CategoriesRepository categoriesRepository;
	
	@Autowired
	private  SellerRepository sellerRepository;
	
	@Override
	public JpaRepository<ListClothing, Integer> getJpaRepository() {
		
		return this.listClothingRepository;
	}
	
	@Transactional
	@Override
	public ListClothing update(ListClothing entity) throws Exception {
		return listClothingRepository.save(entity);
	}

	@Override
	public List<ListClothing> findByCategorie(Integer id) throws Exception {
		if(categoriesRepository.existsById(id)) {
			Optional<Categories> optional = categoriesRepository.findById(id);
           System.out.print("infomracion" + id + optional.get().getName());
			return listClothingRepository.findByCategorie(optional.get().getId());
		}else {
		
			return new ArrayList<ListClothing>();
		}
	}

	@Override
	public List<ListClothing> findBySeller(Integer id) throws Exception {
		if(sellerRepository.existsById(id)) {
			Optional<Seller> optional = sellerRepository.findById(id);
			return listClothingRepository.findBySeller(optional.get().getId());
		}else {
		
			return new ArrayList<ListClothing>();
		}
	}

}
