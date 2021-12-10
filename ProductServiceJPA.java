package com.astha.demo.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.astha.demo.Pojo.Product;
import com.astha.demo.dao.ProductDao;


import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceJPA {
	
	@Autowired
	ProductDao pd;
	
	public Product createProductService(Product newproduct) {
		return this.pd.save(newproduct);
	}
	
	public List<Product> getAllProductService() {
		return this.pd.findAll();
	}
	
	public Optional<Product> getProductDetailsService(int id) {
		return this.pd.findById(id);
	}
	
	public int deleteProductService(int id) {
		try {
			this.pd.deleteById(id);
			return 1;
		} catch (Exception e) {
			// TODO: handle exception
			return 0;
		}
	}
	
	public Product updateProductServer(Product productUpdate, int id) {
		Optional<Product> foundProduct = this.pd.findById(id);
		if (foundProduct.isPresent()) {
			Product oldProduct = foundProduct.get();
			oldProduct.setName(productUpdate.getName());
			oldProduct.setPrice(productUpdate.getPrice());
			oldProduct.setDescription(productUpdate.getDescription());
			
			return this.pd.save(oldProduct);
		}
		else {
			return null;
		}
	}

}
