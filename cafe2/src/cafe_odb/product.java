package cafe_odb;

import java.util.*;
import javax.persistence.*;

@Entity
public class product {
	@Id
	@GeneratedValue
	private int id;
	
	    private String name;
	    private String description;
	    private double price;
	    private int quantity;
	    private String category;
	    
	    //Relations
	    @ManyToOne
	    @JoinColumn(name = "orderid", nullable = false)
	    private order order;
	    
	    // Constructor to initialize the product object
	    public product(String name, String description, double price, int quantity, String category) {
	        this.name = name;
	        this.description = description;
	        this.price = price;
	        this.quantity = quantity;
	        this.category = category;
	    }

	    // Getters and setters (optional, depending on your requirements)
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

	    public String getDescription() {
	        return description;
	    }

	    public void setDescription(String description) {
	        this.description = description;
	    }

	    public double getPrice() {
	        return price;
	    }

	    public void setPrice(double price) {
	        this.price = price;
	    }

	    public int getQuantity() {
	        return quantity;
	    }

	    public void setQuantity(int quantity) {
	        this.quantity = quantity;
	    }

	    public String getCategory() {
	        return category;
	    }

	    public void setCategory(String category) {
	        this.category = category;
	    }
	}
