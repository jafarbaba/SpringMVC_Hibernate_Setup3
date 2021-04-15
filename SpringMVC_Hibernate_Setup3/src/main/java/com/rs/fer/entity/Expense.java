package com.rs.fer.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="expense_annotation")
public class Expense {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int expenseId;
	@Column
	private String type;
	@Column
	private String date;
	@Column
	private float price;
	@Column
	private int numberOfItems;
	@Column
	private float total;
	@Column
	private String byWhom;
	@Column
	private int userId;
	
	 private String created;
	    
	    private String updated;
	    
	

	public String getCreated() {
			return created;
		}
		public void setCreated(String created) {
			this.created = created;
		}
		public String getUpdated() {
			return updated;
		}
		public void setUpdated(String updated) {
			this.updated = updated;
		}
	public int getExpenseId() {
		return expenseId;
	}
	public void setExpenseId(int expenseId) {
		this.expenseId = expenseId;
	}
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public int getNumberOfItems() {
		return numberOfItems;
	}
	public void setNumberOfItems(int numberOfItems) {
		this.numberOfItems = numberOfItems;
	}
	public float getTotal() {
		return total;
	}
	public void setTotal(float total) {
		this.total = total;
	}
	public String getByWhom() {
		return byWhom;
	}
	public void setByWhom(String byWhom) {
		this.byWhom = byWhom;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}

	
}
