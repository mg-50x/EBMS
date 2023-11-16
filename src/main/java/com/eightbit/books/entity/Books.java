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
@Table(name = "books")
public class Books {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	@Column(name = "manage_number")
	private String manage_number;
	@OneToOne
	@JoinColumn(name = "book_master_id")
	private Book_master bookMaster;
	@OneToOne
	@JoinColumn(name = "status")
	private Status status;
	@Column(name = "reg_date")
	private Date reg_date;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getManage_number() {
		return manage_number;
	}
	public void setManage_number(String manage_number) {
		this.manage_number = manage_number;
	}
	public Book_master getBookMaster() {
		return bookMaster;
	}
	public void setBookMaster(Book_master book_master) {
		this.bookMaster = book_master;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public Date getReg_date() {
		return reg_date;
	}
	public void setReg_date(Date reg_date) {
		this.reg_date = reg_date;
	}
}
