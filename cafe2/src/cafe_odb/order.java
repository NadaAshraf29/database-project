package cafe_odb;

import java.util.*;

import javax.persistence.*;

@Entity
public class order {
	@Id
	@GeneratedValue
	private int id;
    private int quantity;
    private String status;
    private double totalAmount;
    private double price;
    
    //Relations
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<product> products;
    @ManyToOne
    @JoinColumn(name = "deliverymanid", nullable = false)
    private deliveryman deliveryman;
    @ManyToOne
    @JoinColumn(name = "customerid", nullable = false)
    private customer customer;
    @OneToOne
    @JoinColumn(name = "paymentid", nullable = false)
    private payment payment;
    
    
    // Constructor to initialize the order object
    public order(int quantity, String status, double totalAmount, double price) {
        this.quantity = quantity;
        this.status = status;
        this.totalAmount = totalAmount;
        this.price = price;
    }

    // Getters and setters (optional, depending on your requirements)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
