package com.example.report;


import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class NguoiMuaTheoNam {
	@Id
private String FullName;
private String PhoneNumber;
private Date date;
private String ProductName;
private String ProductImage;
	
}
