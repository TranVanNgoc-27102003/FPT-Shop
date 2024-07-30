package com.example.report;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class NguoiMuaNhieuNhat implements Serializable{
	@Id
private String fullName;
private String phone;
private Long soLuotMua;
private Double TongTien;

	

}
