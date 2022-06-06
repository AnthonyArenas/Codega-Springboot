package pe.edu.upc.Codega.model.repository;

import java.util.List;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.Codega.model.entity.Vendor;

@Repository
public interface VendorRepository extends JpaRepository<Vendor, Integer> {

}
