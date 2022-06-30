package pe.edu.upc.Codega.business.crud;

import java.util.List;


import pe.edu.upc.Codega.model.entity.ListClothing;

public interface ListClothingService extends CrudService<ListClothing, Integer> {
	List<ListClothing> findByCategorie (Integer id) throws Exception;
}

