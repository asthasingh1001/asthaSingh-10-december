package com.astha.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.astha.demo.Pojo.Product;



public interface ProductDao extends JpaRepository<Product, Integer> {

}
