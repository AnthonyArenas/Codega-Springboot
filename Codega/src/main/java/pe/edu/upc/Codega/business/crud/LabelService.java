package pe.edu.upc.Codega.business.crud;

import java.util.List;

import pe.edu.upc.Codega.model.entity.Label;

public interface LabelService extends CrudService<Label, Integer> {
	List<Label> findByClientId(int id);
}
