package pe.edu.upc.Codega.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.Codega.model.entity.Clothing;

@Repository
public interface ClothingRepository extends JpaRepository<Clothing, Integer> {
}
