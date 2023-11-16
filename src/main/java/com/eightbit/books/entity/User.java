package com.eightbit.books.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "user_master")
public class User {

	@Id
	@Column(name = "id")
	private int userId;
	@Column(name = "last_name")
	private String lastName;
	@Column(name = "first_name")
	private String firstName;
	@Column(name = "birth")
	private Date birth;
	@Column(name = "sex")
	private String sex;
	@Column(name = "tel")
	private String tel;
	@Column(name = "mail")
	private String mail;
	@Column(name = "address")
	private String address;
	@OneToOne
	@JoinColumn(name = "in_charge")
	private General_user_master inCharge;
	@Column(name = "reg_date")
	private Date reg_date;
	@Column(name = "note")
	private String note;
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public Date getBirth() {
		return birth;
	}
	public void setBirth(Date birth) {
		this.birth = birth;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public General_user_master getInCharge() {
		return inCharge;
	}
	public void setInCharge(General_user_master inCharge) {
		this.inCharge = inCharge;
	}
	public Date getReg_date() {
		return reg_date;
	}
	public void setReg_date(Date reg_date) {
		this.reg_date = reg_date;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}

	
}
