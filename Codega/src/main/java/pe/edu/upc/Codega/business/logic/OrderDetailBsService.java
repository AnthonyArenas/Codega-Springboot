package pe.edu.upc.Codega.business.logic;

import java.util.List;

import pe.edu.upc.Codega.model.entity.Client;
import pe.edu.upc.Codega.model.entity.OrderDetail;

public interface OrderDetailBsService {
	List<OrderDetail> findByOrder (Integer id) throws Exception;
	//List<Client> findByClient (Integer id) throws Exception;
}

