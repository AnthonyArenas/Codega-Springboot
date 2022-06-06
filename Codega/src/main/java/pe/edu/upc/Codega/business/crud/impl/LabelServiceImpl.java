package pe.edu.upc.Codega.business.crud.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import pe.edu.upc.Codega.business.crud.LabelService;
import pe.edu.upc.Codega.model.entity.Label;
import pe.edu.upc.Codega.model.repository.LabelRepository;

@Service
public class LabelServiceImpl implements LabelService {

	@Autowired
	private LabelRepository labelRepository;
	
	@Override
	public JpaRepository<Label, Integer> getJpaRepository() {
		return this.labelRepository;
	}

	@Override
	public List<Label> findByClientId(int id) {
		return labelRepository.findByClientId(id);
	}
}
