package pe.edu.upc.Codega.business.crud;


import java.util.List;

import pe.edu.upc.Codega.model.entity.Clothing;

public interface ClothingService extends CrudService<Clothing, Integer>{

	List<Clothing> findByIdListClothing(Integer id);

}
