package cafe_odb;

import java.util.*;

import javax.persistence.*;

@Entity
public class customer {
	@Id
	@GeneratedValue
	private int id;
	private String name;
	private String email;
	private String phone;
	private String address;
	
	
	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<order> orders;
	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<feedback> feedbacks;
	
	public customer() {
		
	}
	public customer(String name,String email,String phone,String address) {
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.address = address;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public List<order> getOrders() {
		return orders;
	}
	public void setOrders(List<order> orders) {
		this.orders = orders;
	}
	public List<feedback> getFeedbacks() {
		return feedbacks;
	}
	public void setFeedbacks(List<feedback> feedbacks) {
		this.feedbacks = feedbacks;
	}
	
}

