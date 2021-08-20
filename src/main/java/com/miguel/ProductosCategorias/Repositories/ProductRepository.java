package com.miguel.ProductosCategorias.Repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.miguel.ProductosCategorias.Models.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {

	
	List<Product> findAll();
	
}

