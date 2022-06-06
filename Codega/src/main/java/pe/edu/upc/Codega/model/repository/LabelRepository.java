package pe.edu.upc.Codega.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.Codega.model.entity.Label;

@Repository
public interface LabelRepository extends JpaRepository<Label, Integer> {
	List<Label> findByClientId(int id);
}
