package pe.edu.upc.Codega.business.crud;

import java.util.List;

//import pe.edu.upc.Codega.model.entity.Client;
//import pe.edu.upc.Codega.model.entity.Client;
import pe.edu.upc.Codega.model.entity.OrderDetail;

public interface OrderDetailService extends CrudService<OrderDetail, Integer> {
	//List<OrderDetail> findByOrder(Integer id) throws Exception;
	List<OrderDetail> findByClient(Integer id) throws Exception; 

}
