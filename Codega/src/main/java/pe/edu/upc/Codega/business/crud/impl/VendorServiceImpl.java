package pe.edu.upc.Codega.business.crud.impl;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import pe.edu.upc.Codega.business.crud.VendorService;
import pe.edu.upc.Codega.model.entity.Vendor;
import pe.edu.upc.Codega.model.repository.VendorRepository;

@Service
public class VendorServiceImpl implements VendorService{

	@Autowired
	private VendorRepository vendorRepository;
	
	@Override
	public JpaRepository<Vendor, Integer> getJpaRepository() {
		return this.vendorRepository;
	}

}
