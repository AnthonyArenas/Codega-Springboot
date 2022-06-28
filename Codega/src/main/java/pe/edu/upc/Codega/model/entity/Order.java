package pe.edu.upc.Codega.model.entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "orders", indexes = {@Index(columnList = "pick_up_way", name = "orders_index_pick_up_way")})

public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
		
	@Column(name = "pick_up_way", length = 30, nullable = false)
	private String pickUpWay;
		
	@Column(name = "order_date",length = 30, nullable = false)
	private String orderDate;
	
	@Column(name = "quantity", nullable = false)
	private float quantity;
	

	@OneToMany(mappedBy = "order")
	private List<OrderDetail> orderDetails;
	

	
	public Order() {
		orderDetails=new ArrayList<>();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	

	public float getQuantity() {
		return quantity;
	}

	public void setQuantity(float quantity) {
		this.quantity = quantity;
	}

	

	public String getPickUpWay() {
		return pickUpWay;
	}

	public void setPickUpWay(String pickUpWay) {
		this.pickUpWay = pickUpWay;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public List<OrderDetail> getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(List<OrderDetail> orderDetails) {
		this.orderDetails = orderDetails;
	}

	
	
	
	 
}
