package com.example.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.bean.Products;
import com.example.dao.ProductsDao;
import com.example.report.Report;
import com.example.service.ProductService;
import com.example.service.uploadFileServices;

import jakarta.servlet.ServletContext;

@Controller
@RequestMapping("Admin")
public class CreateProductsController {
	@Autowired
	ServletContext app;
	@Autowired
	ProductService prService;
	@Autowired uploadFileServices uploadService;
	@RequestMapping("/createProducts/index")
	public String index(@ModelAttribute("Product") Products pr, Model model) {

		List<Products> ListProduct = prService.findAll();
		model.addAttribute("ListProduct", ListProduct);
		return "/Admin/Createproducts";
	}

//	@RequestMapping("/create/products")
//	public String create(@Validated @ModelAttribute("Product") Products pr, Errors errors,@RequestParam("hinh") MultipartFile file) {
//
//		if (errors.hasErrors()) {
//			return "/Admin/Createproducts";
//		}
//
//		 String uploadRootpath=app.getRealPath("images");
//		 File uploadRootDir=new File(uploadRootpath);
//		 if(!uploadRootDir.exists())
//		 {
//			 uploadRootDir.mkdir();
//		 }
//		 try {
//			String filename=file.getOriginalFilename();
//			File serverFile=new File(uploadRootDir.getAbsoluteFile()+File.separator+filename);
//			BufferedOutputStream stream=new BufferedOutputStream(new FileOutputStream(serverFile));
//			stream.write(file.getBytes());
//			stream.close();
//			
//			pr.setImage(filename);
//			this.prService.Save(pr);
//			System.out.println(filename);
//			} catch (Exception e) {
//			// TODO: handle exception
//				e.printStackTrace();
//		}
//		 
//			
//		
//		return "redirect:/Admin/createProducts/index";
//	}

	
	@RequestMapping("/create/products")
	public String create(@Validated @ModelAttribute("Product") Products pr, Errors errors,@RequestParam("hinh") MultipartFile file) {

		if (errors.hasErrors()) {
			return "/Admin/Createproducts";
		}

		String fileName=uploadService.uploadFile(file);
		pr.setImage(fileName);
		prService.Save(pr);
		 
			
		
		return "redirect:/Admin/createProducts/index";
	}
	
	
	@RequestMapping("/edit/product/{id}")
	public String edit(@PathVariable("id") Integer id, Model model) {
		Products product = prService.findById(id).get();
		model.addAttribute("Product", product);
		model.addAttribute("id", id);
		List<Products> ListProduct = prService.findAll();
		model.addAttribute("ListProduct", ListProduct);
		return "/Admin/Createproducts";
	}

	@RequestMapping("/delete/product/{id}")
	public String delete(@PathVariable("id") Integer id) {
		prService.deleteById(id);
		return "redirect:/Admin/createProducts/index";
	}

	@RequestMapping("/reset/product")
	public String reset(@ModelAttribute("Product") Products pr) {
		return "redirect:/Admin/createProducts/index";
	}

	@RequestMapping("/update/products/{id}")
	public String update(@ModelAttribute("Product") Products pr,@RequestParam("hinh")MultipartFile file,@PathVariable("id") Integer id) {
		String fileName=uploadService.uploadFile(file);
		pr.setImage(fileName);	
		pr.setProductId(id);
		prService.Save(pr);
		return "redirect:/Admin/edit/product/" + pr.getProductId();
	}

}
