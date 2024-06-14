package com.ekotomitl.models;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;



@Entity
@Table(name="orders")
public class Orders {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idorder", nullable=false)
	private int idorder;
	
	
	@Column(name="order_date", nullable=false)
	private LocalDate order_date;
	
	@Column(name="total", nullable=false)
	private BigDecimal total;
	
	@Column(name="status", nullable=false, length=40)
	private String status;
	
	@OneToOne
	@JoinColumn(name="payment_idpayment")
	private Payment payment;
	
	@ManyToOne
	@JoinColumn(name="buyer_idbuyer", nullable=false)
	private Buyer buyer;
	
	//Constructor default
	public Orders() {
		super();
		
	}

	public Orders(int idorder, LocalDate order_date, BigDecimal total, String status, Payment payment, Buyer buyer) {
		super();
		this.idorder = idorder;
		this.order_date = order_date;
		this.total = total;
		this.status = status;
		this.payment = payment;
		this.buyer = buyer;
	}

	public int getIdorder() {
		return idorder;
	}

	public void setIdorder(int idorder) {
		this.idorder = idorder;
	}

	public LocalDate getOrder_date() {
		return order_date;
	}

	public void setOrder_date(LocalDate order_date) {
		this.order_date = order_date;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	public Buyer getBuyer() {
		return buyer;
	}

	public void setBuyer(Buyer buyer) {
		this.buyer = buyer;
	}

	@Override
	public String toString() {
		return "Orders [idorder=" + idorder + ", order_date=" + order_date + ", total=" + total + ", status=" + status
				+ ", payment=" + payment + ", buyer=" + buyer + "]";
	}

	

}
