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
	
	@Column(name = "username", length = 40, nullable = false)
	private String username;
	
	@Column(name = "password", length = 40, nullable = false)
	private String password;
	
	@Column(name = "last_name", length = 40, nullable = false)
	private String lastName;
	
	@Column(name = "first_name", length = 40, nullable = false)	
	private String firstName;
	
	@Column(name = "email", length = 40, nullable = false)	
	private String email;
	
	/*@OneToMany(mappedBy = "sellers", cascade = CascadeType.ALL)
	private List<Publications> publications;*/
	
	@OneToMany(mappedBy = "seller", cascade = CascadeType.ALL)
	private List<ListClothing> list_clothing;
	
	/*@OneToMany(mappedBy = "users", cascade = CascadeType.ALL)
	private List<ListClothing> users;*/
	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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
		//publications = new ArrayList<>();
        //users = new ArrayList<>();
		list_clothing = new ArrayList<>();
	}

	public List<ListClothing> getList_clothing() {
		return list_clothing;
	}

	public void setList_clothing(List<ListClothing> list_clothing) {
		this.list_clothing = list_clothing;
	}
	

	/*public List<Publications> getPublications() {
		return publications;
	}

	public void setPublications(List<Publications> publications) {
		this.publications = publications;
	}*/

	
	

	
	

}
