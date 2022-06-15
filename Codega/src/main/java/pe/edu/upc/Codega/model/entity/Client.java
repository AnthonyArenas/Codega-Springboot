package pe.edu.upc.Codega.model.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "client")
public class Client {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "last_name", nullable = false, length = 20)
	private String lastname;
	
	@Column(name = "first_name", nullable = false, length = 20)
	private String firstname;
	
	@Column(name = "cellphone", nullable = false, length = 20)
	private String cellphone;
	
	@Column(name = "direction", nullable = false, length = 50)
	private String direction;
	
	@Column(name = "password", nullable = false, length = 30)
	private String password;

	@OneToMany(mappedBy = "client")
	private List<Label> labels;

	
	public Client() {
		super();
		//TODO Auto-generated constructor stub
		labels = new ArrayList<Label>();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getCellphone() {
		return cellphone;
	}

	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Label> getLabels() {
		return labels;
	}

	public void setLabels(List<Label> labels) {
		this.labels = labels;
	}
	
}
