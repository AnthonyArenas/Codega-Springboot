package pe.edu.upc.Codega.business.crud.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import pe.edu.upc.Codega.business.crud.SaleService;
import pe.edu.upc.Codega.model.entity.ListClothing;
import pe.edu.upc.Codega.model.entity.Sale;
import pe.edu.upc.Codega.model.entity.Seller;
import pe.edu.upc.Codega.model.repository.SaleRepository;
import pe.edu.upc.Codega.model.repository.SellerRepository;

@Service
public class SaleServiceImpl implements SaleService {

	@Autowired
	private SaleRepository saleRepository;
	
	@Autowired
	private  SellerRepository sellerRepository;
	
	@Override
	public JpaRepository<Sale, Integer> getJpaRepository() {
		return this.saleRepository;
	}

	/*@Override
	public List<Sale> findBySeller(Integer id) throws Exception {
		if(sellerRepository.existsById(id)) {
			Optional<Seller> optional = sellerRepository.findById(id);
			return saleRepository.findBySeller(optional.get());
		}else {
		
			return new ArrayList<Sale>();
		}
	}*/

}