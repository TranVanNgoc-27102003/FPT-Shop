package com.example.report;

import java.io.Serializable;

import com.example.bean.Products;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Report implements Serializable{
@Id

private String productName;
private String productImage;
private Long soLuong;
private Double sum;

}
