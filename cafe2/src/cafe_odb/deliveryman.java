package cafe_odb;

import java.util.*;

import javax.persistence.*;

@Entity
public class deliveryman {
	@Id
	@GeneratedValue
	private int id;
	private String name;
	private String phone;
	private String status;
	
	@OneToMany(mappedBy = "deliveryman", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<order> orders;
	
	public deliveryman() {
		
	}
	public deliveryman(String name,String phone,String status) {
		this.name = name;
		this.phone = phone;
		this.status = status;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public List<order> getOrders() {
		return orders;
	}
	public void setOrders(List<order> orders) {
		this.orders = orders;
	}
	
}