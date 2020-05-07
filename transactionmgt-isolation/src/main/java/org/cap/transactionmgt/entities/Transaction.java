package org.cap.transactionmgt.entities;

import java.sql.Date;


import javax.persistence.*;
import javax.persistence.Table;

@Entity
@Table(name = "transactions")
public class Transaction {
	@Id
	private String transId;
	public String getTransId() {
		return transId;
	}
	public void setTransId(String transId) {
		this.transId = transId;
	}
	
	public String transAccountId;
	private String transtype;
	private double transAmount;
	public Transaction() {
		super();
	
	}
	public Transaction(String transAccountId, String transId, String transtype, String option, Date transDate,
			String transFrom, String transTo, double transClosingBalance) {
		super();
		this.transAccountId = transAccountId;
		this.transId = transId;
		this.transtype = transtype;
		this.option = option;
		this.transDate = transDate;
		this.transFrom = transFrom;
		this.transTo = transTo;
		this.transClosingBalance = transClosingBalance;
		
		
	}
	
	private String option;
	private Date transDate;
	private String transFrom;
	private String transTo;
	private double transClosingBalance;
	
	
	
	public String getTransAccountId() {
		return transAccountId;
	}
	public void setTransAccountId(String transAccountId) {
		this.transAccountId = transAccountId;
	}
	public String getTranstype() {
		return transtype;
	}
	public void setTranstype(String transtype) {
		this.transtype = transtype;
	}
	public double getTransAmount() {
		return transAmount;
	}
	public void setTransAmount(double transAmount) {
		this.transAmount = transAmount;
	}
	public String getOption() {
		return option;
	}
	public void setOption(String option) {
		this.option = option;
	}
	public Date getTransDate() {
		return transDate;
	}
	public void setTransDate(Date transDate) {
		this.transDate = transDate;
	}
	public String getTransFrom() {
		return transFrom;
	}
	public void setTransFrom(String transFrom) {
		this.transFrom = transFrom;
	}
	public String getTransTo() {
		return transTo;
	}
	public void setTransTo(String transTo) {
		this.transTo = transTo;
	}
	public double getTransClosingBalance() {
		return transClosingBalance;
	}
	public void setTransClosingBalance(double transClosingBalance) {
		this.transClosingBalance = transClosingBalance;
	}

}
