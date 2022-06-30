package pe.edu.upc.Codega.model.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "sellers", indexes = {@Index(columnList = "id", name = "sellers_index_id")})
public class Seller {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	
	@Column(name = "last_name", length = 40, nullable = false)
	private String lastName;
	
	@Column(name = "first_name", length = 40, nullable = false)	
	private String firstName;
	
	@Column(name = "email", length = 40, nullable = false)	
	private String email;
	
	@Column(name = "cellphone", nullable = false, length = 20)
	private String cellphone;
	
	@Column(name = "city", nullable = false, length = 100)
	private String city;
	

	@OneToMany(mappedBy = "seller", cascade = CascadeType.ALL)
	private List<ListClothing> list_clothing;
	

	
	
	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}

	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public Seller() {

		list_clothing = new ArrayList<>();
		
	}

	public List<ListClothing> getList_clothing() {
		return list_clothing;
	}

	public void setList_clothing(List<ListClothing> list_clothing) {
		this.list_clothing = list_clothing;
	}


	public String getCellphone() {
		return cellphone;
	}


	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}
	
	
	

	

}
