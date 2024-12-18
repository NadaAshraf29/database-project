package cafe_odb;

import java.util.*;

import javax.persistence.*;

public class operations {
	
	//Add
	
	public static void addCustomer(customer c) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("$objectdb/db/cafe.odb");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		em.persist(c);
		em.getTransaction().commit();
		
		em.close();
		emf.close();
	}
	public static void addDeliveryman(deliveryman d) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("$objectdb/db/cafe.odb");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		em.persist(d);
		em.getTransaction().commit();
		
		em.close();
		emf.close();
	}
	public static void addFeedback(feedback f) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("$objectdb/db/cafe.odb");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		em.persist(f);
		em.getTransaction().commit();
		
		em.close();
		emf.close();
	}
	public static void addOrder(order o) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("$objectdb/db/cafe.odb");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		em.persist(o);
		em.getTransaction().commit();
		
		em.close();
		emf.close();
	}
	public static void addPayment(payment pa) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("$objectdb/db/cafe.odb");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		em.persist(pa);
		em.getTransaction().commit();
		
		em.close();
		emf.close();
	}
	public static void addProduct(product pr) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("$objectdb/db/cafe.odb");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		em.persist(pr);
		em.getTransaction().commit();
		
		em.close();
		emf.close();
	}
	
	//Retrieve object
	
	public static customer getCustomerById(int id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("$objectdb/db/cafe.odb");
		EntityManager em = emf.createEntityManager();
		
		customer c = em.find(customer.class, id);
		
		em.close();
		emf.close();
		return c;
	}
	public static feedback getFeedbackById(int id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("$objectdb/db/cafe.odb");
		EntityManager em = emf.createEntityManager();
		
		feedback f = em.find(feedback.class, id);
		
		em.close();
		emf.close();
		return f;
	}
	public static deliveryman getDeliverymanById(int id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("$objectdb/db/cafe.odb");
		EntityManager em = emf.createEntityManager();
		
		deliveryman d = em.find(deliveryman.class, id);
		
		em.close();
		emf.close();
		return d;
	}
	public static order getOrderById(int id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("$objectdb/db/cafe.odb");
		EntityManager em = emf.createEntityManager();
		
		order o = em.find(order.class, id);
		
		em.close();
		emf.close();
		return o;
	}
	public static payment getPaymentById(int id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("$objectdb/db/cafe.odb");
		EntityManager em = emf.createEntityManager();
		
		payment pa = em.find(payment.class, id);
		
		em.close();
		emf.close();
		return pa;
	}
	public static product ProductById(int id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("$objectdb/db/cafe.odb");
		EntityManager em = emf.createEntityManager();
		
		product pr = em.find(product.class, id);
		
		em.close();
		emf.close();
		return pr;
	}
	
	//Update
	
	public static void updateCustomer(int id, String newName,String newEmail,String newPhone,String newAddress) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("$objectdb/db/cafe.odb");
		EntityManager em = emf.createEntityManager();
		
		customer c = em.find(customer.class, id);
		
		try {
			if (c != null) {
				if (newName != null) {
					em.getTransaction().begin();
					c.setName(newName);
					em.getTransaction().commit();
				}
				if (newEmail != null) {
					em.getTransaction().begin();
					c.setEmail(newEmail);
					em.getTransaction().commit();
				}
				if (newPhone != null) {
					em.getTransaction().begin();
					c.setPhone(newPhone);
					em.getTransaction().commit();
				}
				if (newAddress != null) {
					em.getTransaction().begin();
					c.setAddress(newAddress);
					em.getTransaction().commit();
				}
			}
		} catch (Exception e) {
			if (em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
			e.printStackTrace();
		} finally {
			em.close();
			emf.close();
		}
		
	}
	public static void updateDeliveryman(int id,String newName,String newPhone,String newStatus) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("$objectdb/db/cafe.odb");
		EntityManager em = emf.createEntityManager();
		
		deliveryman d = em.find(deliveryman.class, id);
		
		try {
			if (d != null) {
				if (newName != null) {
					em.getTransaction().begin();
					d.setName(newName);
					em.getTransaction().commit();
				}
				if (newPhone != null) {
					em.getTransaction().begin();
					d.setPhone(newPhone);
					em.getTransaction().commit();
				}
				if (newStatus != null) {
					em.getTransaction().begin();
					d.setStatus(newStatus);
					em.getTransaction().commit();
				}
			}
		} catch (Exception e) {
			if (em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
			e.printStackTrace();
		} finally {
			em.close();
			emf.close();
		}
		
	}
	public static void updateFeedback(int id, customer newCustomer, order newOrder, String newComment, int newRating, Date newCreateDate) {
	    EntityManagerFactory emf = Persistence.createEntityManagerFactory("$objectdb/db/cafe.odb");
	    EntityManager em = emf.createEntityManager();

	    feedback f = em.find(feedback.class, id);

	    try {
	        if (f != null) {
	            if (newComment != null) {
	                em.getTransaction().begin();
	                f.setComment(newComment);
	                em.getTransaction().commit();
	            }
	            if (newRating > 0) { 
	                em.getTransaction().begin();
	                f.setRating(newRating);
	                em.getTransaction().commit();
	            }
	        } 
	    } catch (Exception e) {
	        if (em.getTransaction().isActive()) {
	            em.getTransaction().rollback();
	        }
	        e.printStackTrace();
	    } finally {
	        em.close();
	        emf.close();
	    }
	}
	public static void updateOrder(int id, Integer newQuantity, String newStatus, Double newTotalAmount, Double newPrice) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("$objectdb/db/cafe.odb");
		EntityManager em = emf.createEntityManager();
		
		order o = em.find(order.class, id);
		
		try {
			if (o != null) {			
				if (newQuantity != null && newQuantity > 0) {
					em.getTransaction().begin();
					o.setQuantity(newQuantity);
	                em.getTransaction().commit();
				}
				List<String> validStatuses = Arrays.asList("pending", "shipped", "delivered", "canceled");
				if (newStatus != null && validStatuses.contains(newStatus)) {
					em.getTransaction().begin();
					o.setStatus(newStatus);
	                em.getTransaction().commit();
				}				
				if (newTotalAmount != null && newTotalAmount > 0) {
					em.getTransaction().begin();
					o.setTotalAmount(newTotalAmount);
	                em.getTransaction().commit();
				}				
				if (newPrice != null && newPrice > 0) {
					em.getTransaction().begin();
					o.setPrice(newPrice);
	                em.getTransaction().commit();
				}		
			}
		} catch (Exception e) {		
				if (em.getTransaction().isActive()) {
					em.getTransaction().rollback();
					}
				e.printStackTrace();
				} finally {
					em.close();
					emf.close();
			}
		}
	public static void updatePayment(int id,String newPaymenttype, Double newAmountpaid, String newTransactionid, Double newCashreceived, Double newChangegiven) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("$objectdb/db/cafe.odb");
		EntityManager em = emf.createEntityManager();
		
		payment pa = em.find(payment.class, id);
		
		try {
			if (pa != null) {			
				if (newPaymenttype != null && !newPaymenttype.isEmpty()) {
					em.getTransaction().begin();
					pa.setPaymenttype(newPaymenttype);
	                em.getTransaction().commit();
				}
	            if (newAmountpaid != null && newAmountpaid > 0) {
					em.getTransaction().begin();
					pa.setAmountpaid(newAmountpaid);
	                em.getTransaction().commit();
				}				
				}				
			   if (newTransactionid != null && !newTransactionid.isEmpty()) {
					em.getTransaction().begin();
					pa.setTransactionid(newTransactionid);
	                em.getTransaction().commit();
				}
			   if (newCashreceived != null && newCashreceived >= 0) {
					em.getTransaction().begin();
					pa.setCashreceived(newCashreceived);
	                em.getTransaction().commit();
				}
			   if (newChangegiven != null && newChangegiven >= 0) {
					em.getTransaction().begin();
	                pa.setChangegiven(newChangegiven);
	                em.getTransaction().commit();
			   }
			   
		} catch (Exception e) {		
				if (em.getTransaction().isActive()) {
					em.getTransaction().rollback();
					}
				e.printStackTrace();
				} finally {
					em.close();
					emf.close();
			}
		}
	public static void updateProduct(int id, String newName,String newDescription, Double newPrice,Integer newQuantity,String newCategory) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("$objectdb/db/cafe.odb");
		EntityManager em = emf.createEntityManager();
		
		product pr = em.find(product.class, id);
		
		try {
			if (pr != null) {			
				if (newName != null) {
					em.getTransaction().begin();
					pr.setName(newName);
					em.getTransaction().commit();
				}
	            if (newDescription != null) {
					em.getTransaction().begin();
					pr.setDescription(newDescription);
	                em.getTransaction().commit();
				}				
				}				
			   if (newPrice != null) {
					em.getTransaction().begin();
					pr.setPrice(newPrice);
	                em.getTransaction().commit();
				}
			   if (newQuantity != null ) {
					em.getTransaction().begin();
					pr.setQuantity(newQuantity);
	                em.getTransaction().commit();
				}
			   if (newQuantity != null) {
					em.getTransaction().begin();
	                pr.setCategory(newCategory);
	                em.getTransaction().commit();
			   }
			   
		} catch (Exception e) {		
				if (em.getTransaction().isActive()) {
					em.getTransaction().rollback();
					}
				e.printStackTrace();
				} finally {
					em.close();
					emf.close();
			}
		}

//Delete
	
	public static void deleteCustomer(int id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("$objectdb/db/cafe.odb");
		EntityManager em = emf.createEntityManager();
		
		customer c = em.find(customer.class, id);
		
		if (c!= null) {
			em.getTransaction().begin();
			em.remove(c);
			System.out.printf("Success: customer with id : \"%d\" deleted successfuly.", id);
			em.getTransaction().commit();
		} else {
			System.out.printf("Error: There is no customer with id : \"%d\" in the database.", id);
		}
		em.close();
		emf.close();
	}
	public static void deleteDeliveryman(int id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("$objectdb/db/cafe.odb");
		EntityManager em = emf.createEntityManager();
		
		deliveryman d = em.find(deliveryman.class, id);
		
		if (d != null) {
			em.getTransaction().begin();
			em.remove(d);
			System.out.printf("Success: deliveryman with id : \"%d\" deleted successfuly.", id);
			em.getTransaction().commit();
		} else {
			System.out.printf("Error: There is no deliveryman with id : \"%d\" in the database.", id);
		}
		em.close();
		emf.close();
	}
	public static void deleteFeedback(int id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("$objectdb/db/cafe.odb");
		EntityManager em = emf.createEntityManager();
		
		feedback f = em.find(feedback.class, id);
		
		if (f != null) {
			em.getTransaction().begin();
			em.remove(f);
			System.out.printf("Success: Feedback with id : \"%d\" deleted successfuly.", id);
			em.getTransaction().commit();
		} else {
			System.out.printf("Error: There is no feedback with id : \"%d\" in the database.", id);
		}
		em.close();
		emf.close();
	}
	public static void deleteOrder(int id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("$objectdb/db/cafe.odb");
		EntityManager em = emf.createEntityManager();
		
		order o = em.find(order.class, id);
		
		if (o != null) {
			em.getTransaction().begin();
			em.remove(o);
			System.out.printf("Success: order with id : \"%d\" deleted successfuly.", id);
			em.getTransaction().commit();
		} else {
			System.out.printf("Error: There is no order with id : \"%d\" in the database.", id);
		}
		em.close();
		emf.close();
	}
	public static void deletePayment(int id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("$objectdb/db/cafe.odb");
		EntityManager em = emf.createEntityManager();
		
		payment pa = em.find(payment.class, id);
		
		if (pa != null) {
			em.getTransaction().begin();
			em.remove(pa);
			System.out.printf("Success: payment with id : \"%d\" deleted successfuly.", id);
			em.getTransaction().commit();
		} else {
			System.out.printf("Error: There is no payment with id : \"%d\" in the database.", id);
		}
		em.close();
		emf.close();
	}
	public static void deleteProduct(int id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("$objectdb/db/cafe.odb");
		EntityManager em = emf.createEntityManager();
		
		product pr = em.find(product.class, id);
		
		if (pr != null) {
			em.getTransaction().begin();
			em.remove(pr);
			System.out.printf("Success: product with id : \"%d\" deleted successfuly.", id);
			em.getTransaction().commit();
		} else {
			System.out.printf("Error: There is no product with id : \"%d\" in the database.", id);
		}
		em.close();
		emf.close();
	}
	public static List<customer> getAllCustomers() {
	    EntityManagerFactory emf = Persistence.createEntityManagerFactory("$objectdb/db/cafe.odb");
	    EntityManager em = emf.createEntityManager();

	    List<customer> customers = em.createQuery("SELECT c FROM customer c", customer.class).getResultList();
	    
	    em.close();
	    emf.close();
	    return customers;
	}
	public static List<product> getAllProduct() {
	    EntityManagerFactory emf = Persistence.createEntityManagerFactory("$objectdb/db/cafe.odb");
	    EntityManager em = emf.createEntityManager();

	    List<product> products = em.createQuery("SELECT p FROM product p", product.class).getResultList();
	    
	    em.close();
	    emf.close();
	    return products;
	}
	public static List<order> getAllOrder() {
	    EntityManagerFactory emf = Persistence.createEntityManagerFactory("$objectdb/db/cafe.odb");
	    EntityManager em = emf.createEntityManager();

	    List<order> orders = em.createQuery("SELECT o FROM order o", order.class).getResultList();
	    
	    em.close();
	    emf.close();
	    return orders;
	}
	public static long countCustomers() {
	    EntityManagerFactory emf = Persistence.createEntityManagerFactory("$objectdb/db/cafe.odb");
	    EntityManager em = emf.createEntityManager();

	    long count = em.createQuery("SELECT COUNT(c) FROM customer c", Long.class).getSingleResult();
	    
	    em.close();
	    emf.close();
	    return count;
	}
	public static long countOrders() {
	    EntityManagerFactory emf = Persistence.createEntityManagerFactory("$objectdb/db/cafe.odb");
	    EntityManager em = emf.createEntityManager();

	    long count = em.createQuery("SELECT COUNT(o) FROM order o", Long.class).getSingleResult();
	    
	    em.close();
	    emf.close();
	    return count;
	}

	public static long countProducts() {
	    EntityManagerFactory emf = Persistence.createEntityManagerFactory("$objectdb/db/cafe.odb");
	    EntityManager em = emf.createEntityManager();

	    long count = em.createQuery("SELECT COUNT(p) FROM product p", Long.class).getSingleResult();
	    
	    em.close();
	    emf.close();
	    return count;
	}
	public static List<product> getProductsByPriceRange(double minPrice, double maxPrice) {
	    EntityManagerFactory emf = Persistence.createEntityManagerFactory("$objectdb/db/cafe.odb");
	    EntityManager em = emf.createEntityManager();

	    List<product> products = em.createQuery("SELECT p FROM product p WHERE p.price BETWEEN :minPrice AND :maxPrice", product.class)
	                               .setParameter("minPrice", minPrice)
	                               .setParameter("maxPrice", maxPrice)
	                               .getResultList();

	    em.close();
	    emf.close();
	    return products;
	}
	public static List<order> getOrdersByStatus(String status) {
	    EntityManagerFactory emf = Persistence.createEntityManagerFactory("$objectdb/db/cafe.odb");
	    EntityManager em = emf.createEntityManager();

	    List<order> orders = em.createQuery("SELECT o FROM order o WHERE o.status = :status", order.class)
	                           .setParameter("status", status)
	                           .getResultList();

	    em.close();
	    emf.close();
	    return orders;
	}
	public static List<customer> getCustomersWithOrdersGreaterThan(double amount) {
	    EntityManagerFactory emf = Persistence.createEntityManagerFactory("$objectdb/db/cafe.odb");
	    EntityManager em = emf.createEntityManager();

	    List<customer> customers = em.createQuery(
	            "SELECT DISTINCT o.customer FROM order o WHERE o.totalamount > :amount", customer.class)
	            .setParameter("amount", amount)
	            .getResultList();

	    em.close();
	    emf.close();
	    return customers;
	}public static List<product> getTopNExpensiveProducts(int n) {
	    EntityManagerFactory emf = Persistence.createEntityManagerFactory("$objectdb/db/cafe.odb");
	    EntityManager em = emf.createEntityManager();

	    List<product> products = em.createQuery("SELECT p FROM product p ORDER BY p.price DESC", product.class)
	                               .setMaxResults(n)
	                               .getResultList();

	    em.close();
	    emf.close();
	    return products;
	}
	public static List<order> getOrdersByDeliverymanId(int deliverymanId) {
	    EntityManagerFactory emf = Persistence.createEntityManagerFactory("$objectdb/db/cafe.odb");
	    EntityManager em = emf.createEntityManager();

	    List<order> orders = em.createQuery("SELECT o FROM order o WHERE o.deliveryman.id = :id", order.class)
	                           .setParameter("id", deliverymanId)
	                           .getResultList();

	    em.close();
	    emf.close();
	    return orders;
	}


}