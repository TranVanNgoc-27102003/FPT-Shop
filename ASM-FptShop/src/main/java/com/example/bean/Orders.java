package com.example.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Orders")
public class Orders implements Serializable{
@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
private int OrderId;
@Temporal(TemporalType.DATE)
private Date OrderDate = new Date();
private Double TotalAmount;
private Integer AcountId;
@JsonIgnore
@ManyToOne @JoinColumn(name="AcountId",insertable=false, updatable=false)
Account account;

@OneToMany (mappedBy = "Order")
@JsonIgnore
List<OrderDetails>OrderDetail;

public String toString() {
	return "Order{" + "OrderId=" + OrderId + ", OrderDate='" + OrderDate 
			+ "TotalAmount="+TotalAmount+  "AcountId="+AcountId+'\'' +
	// other attributes
			'}';
}
}
