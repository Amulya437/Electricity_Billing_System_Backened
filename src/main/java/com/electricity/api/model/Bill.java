package com.electricity.api.model;

import java.time.LocalDate;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;

import javax.persistence.GenerationType;

import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class Bill {

    @Id

    @GeneratedValue(strategy = GenerationType.AUTO)

    private int id;

    private int consumerNumber;

    private int consumedUnits;

    private String billMonth;

    private LocalDate billDate;

    private double amount;

    private LocalDate dueDate;
    
    @ManyToOne
    private Customer customer;
    
    @ManyToOne
    private Meter meter;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getConsumerNumber() {
		return consumerNumber;
	}

	public void setConsumerNumber(int consumerNumber) {
		this.consumerNumber = consumerNumber;
	}

	public int getConsumedUnits() {
		return consumedUnits;
	}

	public void setConsumedUnits(int consumedUnits) {
		this.consumedUnits = consumedUnits;
	}

	public String getBillMonth() {
		return billMonth;
	}

	public void setBillMonth(String billMonth) {
		this.billMonth = billMonth;
	}

	public LocalDate getBillDate() {
		return billDate;
	}

	public void setBillDate(LocalDate billDate) {
		this.billDate = billDate;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public LocalDate getDueDate() {
		return dueDate;
	}

	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Meter getMeter() {
		return meter;
	}

	public void setMeter(Meter meter) {
		this.meter = meter;
	}

	@Override
	public String toString() {
		return "Bill [id=" + id + ", consumerNumber=" + consumerNumber + ", consumedUnits=" + consumedUnits
				+ ", billMonth=" + billMonth + ", billDate=" + billDate + ", amount=" + amount + ", dueDate=" + dueDate
				+ ", customer=" + customer + ", meter=" + meter + "]";
	}
    
   
    
    

 

 

}
