package com.example.bean;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Account")

public class Account implements Serializable{	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int AcountId ;
	private String Email;
	private String PassWord;
	private String FullName;
	private String Address;
	private String PhoneNumber;
	private Boolean Role;
	@JsonIgnore
	@OneToMany(mappedBy = "account")
	List<Orders> orders;
	@JsonIgnore
	@OneToMany(mappedBy = "account")
	List<Cart> cart;
	@Override

	public String toString() {
		return "Account{" + "Email=" + Email + ", PassWord='" + PassWord + '\'' +
		// other attributes
				'}';
	}
	
}
