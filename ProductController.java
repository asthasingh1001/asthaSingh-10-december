package com.astha.demo.Controllers;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.astha.demo.Pojo.Product;


@RestController
@RequestMapping("product")
public class ProductController {
	
	private ArrayList<Product> products = new ArrayList<>();
	
	@PostMapping("add")
	public Product createUser(@RequestBody Product newProduct) {
		Product updateProductList = new Product(newProduct.getName(), newProduct.getPrice(), newProduct.getDescription());
		this.products.add(updateProductList);
		return updateProductList;
	}
	
	@GetMapping("all")
	public ArrayList<Product> getAllProduct(){
		return this.products;
	}
	
	@DeleteMapping("delete/{id}")
	public Boolean deleteProduct(@PathVariable("id") int id) {
		for (Product product : products) {
			if(product.getId()==id) {
				return products.remove(product);
			}
		}
		return false;
	}
	
	@PutMapping("update")
	public Boolean updateProduct(@RequestBody Product newProduct) {
		
		for (Product product : products) {
			if(product.getId()==newProduct.getId()) {
				product.setName(newProduct.getName());
				product.setPrice(newProduct.getPrice());
				product.setDescription(newProduct.getDescription());
				return true;
			}
		}
		
		return false;
	}

}
