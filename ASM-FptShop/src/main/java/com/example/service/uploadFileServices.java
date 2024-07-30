package com.example.service;

import org.springframework.web.multipart.MultipartFile;

public interface uploadFileServices {
	public String uploadFile(MultipartFile file);
}
