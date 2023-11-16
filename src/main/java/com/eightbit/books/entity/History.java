package com.eightbit.books.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "history")
public class History {

	@Id
	@Column(name = "id")
	private int id;
	@OneToOne
	@JoinColumn(name = "book_id")
	private Books book;
	@OneToOne
	@JoinColumn(name = "user_id")
	private User user;
	@Column(name = "checkout_date")
	private Date checkoutDate;
	@Column(name = "due_date")
	private Date dueDate;
	@Column(name = "return_date")
	private Date returnDate;
	@Column(name = "returned")
	private String returned;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Books getBook() {
		return book;
	}
	public void setBook(Books book) {
		this.book = book;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Date getCheckoutDate() {
		return checkoutDate;
	}
	public void setCheckoutDate(Date checkoutDate) {
		this.checkoutDate = checkoutDate;
	}
	public Date getDueDate() {
		return dueDate;
	}
	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}
	public Date getReturnDate() {
		return returnDate;
	}
	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}
	public String getReturned() {
		return returned;
	}
	public void setReturned(String returned) {
		this.returned = returned;
	}
	

}
