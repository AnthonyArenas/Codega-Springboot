package pe.edu.upc.Codega.model.entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "clothing", indexes = {@Index(columnList = "id", name = "clothing_index_id")})
public class Clothing {

    public ListClothing getList_clothing() {
		return list_clothing;
	}

	public void setList_clothing(ListClothing list_clothing) {
		this.list_clothing = list_clothing;
	}

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
	
	@Column(name = "model", length = 100, nullable = false)
	private String model;
	
	@Column(name = "price", length = 100, nullable = false)
	private float price;

	@Column(name = "urlToImage", length = 500, nullable = true)
	private String urlToImage;
	
	@Column(name = "description", length = 200, nullable = true)
	private String description;
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUrlToImage() {
		return urlToImage;
	}

	public void setUrlToImage(String urlToImage) {
		this.urlToImage = urlToImage;
	}

	@ManyToOne
	@JoinColumn(name = "list_clothing_id", nullable = true)
	private ListClothing list_clothing;	// career_idd
	
	@OneToMany(mappedBy = "clothing")
	private List<OrderDetail> orderDetails;
	
	public Clothing() {
		orderDetails = new ArrayList<>();
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}


	public float getPrice() {
		return price;
	}
	
	public void setPrice(float price) {
		this.price = price;
	}

	public List<OrderDetail> getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(List<OrderDetail> orderDetails) {
		this.orderDetails = orderDetails;
	}
	
	
	
}
