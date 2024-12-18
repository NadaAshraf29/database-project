package cafe_odb;

import java.util.*;

import javax.persistence.*;

@Entity
public class feedback {
	@Id
	@GeneratedValue
	private int id;
	private String comment;
	private int rating;
	private Date createdate;
	
	@ManyToOne
	@JoinColumn (name = "customerid", nullable = false)
	private customer customer;
	@ManyToOne
	@JoinColumn(name = "orderid", nullable = false)
	private order order;
	
	public feedback() {
		
	}
	public feedback(customer customer, order order, String comment,int rating,Date createdate) {
		this.customer = customer;
		this.order = order;
		this.comment = comment;
		this.rating = rating;
		this.createdate = createdate;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public Date getCreatedate() {
		return createdate;
	}
	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}
	public customer getCustomer() {
		return customer;
	}
	public void setCustomer(customer customer) {
		this.customer = customer;
	}
	public order getOrder() {
		return order;
	}
	public void setOrder(order order) {
		this.order = order;
	}
	
}