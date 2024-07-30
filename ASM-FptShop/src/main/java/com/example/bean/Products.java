package com.example.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Products")
public class Products implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	public int ProductId;
	@NotBlank(message= "không được bỏ trống tên sản phẩm")
	private String ProductName;
	
	public String Image;
	@NotBlank(message= "không được bỏ trống loại sản phẩm")
	private String Category;
	@PositiveOrZero(message="Giá sản phẩm không được là số âm")
	@NotNull(message= "không được bỏ trống giá sản phẩm")
	private Double Price;
	@PositiveOrZero(message="Giá sản phẩm không được là số âm")
	@NotNull(message= "không được bỏ trống giảm giá sản phẩm")
	private Double Discount;
	@NotNull(message= "không được bỏ trống số lượng sản phẩm")
	@PositiveOrZero(message="số lượng không được là số âm")
	private int Quantity;
	private String Color;

	@OneToMany(mappedBy = "Product")
	@JsonIgnore
	List<OrderDetails> OrderDetail;
	@JsonIgnore
	@OneToMany(mappedBy = "product")
	List<Cart> cart;
	@Override

	public String toString() {
		return "Products{" + "ProductId=" + ProductId + ", ProductName='" + ProductName + '\'' +
		// other attributes
				'}';
	}
}
