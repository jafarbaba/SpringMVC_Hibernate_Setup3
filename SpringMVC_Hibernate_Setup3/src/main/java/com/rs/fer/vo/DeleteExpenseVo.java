package com.rs.fer.vo;


public class DeleteExpenseVo {

	private int expenseId;
	private String type;
	private String date;
	private float price;
	private int numberOfItems;
	private float total;
	private String byWhom;
	private int userId;
	
	
	public void setExpenseId(int expenseId) {
		this.expenseId = expenseId;
	}
	
	public int getExpenseId() {
		return expenseId;
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
