package pe.edu.upc.Codega.model.entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "clothing", indexes = {@Index(columnList = "id", name = "clothing_index_id")})
public class Clothing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
	
	@Column(name = "model", length = 100, nullable = false)
	private String model;
	
	@Column(name = "price", length = 100, nullable = false)
	private float price;

	
	@ManyToOne
	@JoinColumn(name = "list_clothing_id", nullable = true)
	private ListClothing list_clothing;	// career_idd
	
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
	
}
