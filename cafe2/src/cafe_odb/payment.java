package cafe_odb;

import java.util.*;
import javax.persistence.*;

@Entity
public class payment {
	@Id
	@GeneratedValue
	private int id;
	private String paymenttype;
	private double amountpaid;
	private Date paymentdate;
	private String transactionid;

    // Credit payment details
    private String cardnumber;     
    private String cardholdername;  
    private String cardexpirydate;

    // Cash payment details
    private Double cashreceived;
    private Double changegiven;
	
    @OneToOne
    @JoinColumn(name = "orderid", nullable = false)
    private order order;

    
	public payment() {
		
	}
	public payment(order order,String paymenttype, double amountpaid, Date paymentdate, String transactionid, String cardnumber, String cardholdername, String cardexpirydate, Double cashreceived, Double changegiven) {
		this.order = order;
		this.paymenttype = paymenttype;
		this.amountpaid = amountpaid;
		this.paymentdate = paymentdate;
		this.transactionid = transactionid;
		this.cardnumber = cardnumber;
		this.cardholdername = cardholdername;
		this.cardexpirydate = cardexpirydate;
		this.cashreceived = cashreceived;
		this.changegiven = changegiven;
		
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPaymenttype() {
		return paymenttype;
	}
	public void setPaymenttype(String paymenttype) {
		this.paymenttype = paymenttype;
	}
	public double getAmountpaid() {
		return amountpaid;
	}
	public void setAmountpaid(double amountpaid) {
		this.amountpaid = amountpaid;
	}
	public Date getPaymentdate() {
		return paymentdate;
	}
	public void setPaymentdate(Date paymentdate) {
		this.paymentdate = paymentdate;
	}
	public String getTransactionid() {
		return transactionid;
	}
	public void setTransactionid(String transactionid) {
		this.transactionid = transactionid;
	}
	public String getCardnumber() {
		return cardnumber;
	}
	public void setCardnumber(String cardnumber) {
		this.cardnumber = cardnumber;
	}
	public String getCardholdername() {
		return cardholdername;
	}
	public void setCardholdername(String cardholdername) {
		this.cardholdername = cardholdername;
	}
	public String getCardexpirydate() {
		return cardexpirydate;
	}
	public void setCardexpirydate(String cardexpirydate) {
		this.cardexpirydate = cardexpirydate;
	}
	public Double getCashreceived() {
		return cashreceived;
	}
	public void setCashreceived(Double cashreceived) {
		this.cashreceived = cashreceived;
	}
	public Double getChangegiven() {
		return changegiven;
	}
	public void setChangegiven(Double changegiven) {
		this.changegiven = changegiven;
	}
	public order getOrder() {
		return order;
	}
	public void setOrder(order order) {
		this.order = order;
	}
	
	
}