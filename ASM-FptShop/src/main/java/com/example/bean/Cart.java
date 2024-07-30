package com.example.bean;

import java.io.Serializable;

import javax.sql.rowset.serial.SerialArray;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cart")
public class Cart implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int CartId;
	private Integer ProductId;
	private Integer accountId;
	@ManyToOne
	@JoinColumn(name = "ProductId", insertable = false, updatable = false)
	private Products product;
	
	@ManyToOne
	@JoinColumn(name = "AccountId", insertable = false, updatable = false)
	private Account account;
	private int Quantity;
}
