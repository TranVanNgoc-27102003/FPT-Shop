package com.example.bean;

import java.io.Serializable;
import java.util.List;

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
@Table(name="OrderDetails")
public class OrderDetails implements Serializable{
@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
private int OrderDetailId;
private Integer orderId;
private Integer productId;
@JsonIgnore
@ManyToOne @JoinColumn(name="OrderId",insertable = false,updatable = false)
private Orders Order;
@JsonIgnore
@ManyToOne @JoinColumn(name="ProductId",insertable = false,updatable = false)
private Products Product;
private int Quantity;
private Double Total;

public String toString() {
	return "OrderDetails{" + "OrderDetailId=" + OrderDetailId + ", productId='" + productId 
			+ "orderID="+orderId+  "Order="+Order+'\'' +
	// other attributes
			'}';
}
}
