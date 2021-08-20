package com.miguel.ProductosCategorias.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.miguel.ProductosCategorias.Models.Category;
import com.miguel.ProductosCategorias.Models.Product;
import com.miguel.ProductosCategorias.Repositories.CategoryRepository;
import com.miguel.ProductosCategorias.Repositories.ProductRepository;

@Service
public class ProductService {

//agrega dependencia

	private final ProductRepository productRepository;
	private final CategoryRepository categoryRepository;
	

//Constructor
	public ProductService(ProductRepository productRepository,CategoryRepository categoryRepository) {
		this.productRepository = productRepository;
		this.categoryRepository = categoryRepository;
	}

//crea una new Product

	public Product createProduct(Product product) {
		return productRepository.save(product);
	}

//encuentra todas product

	public List<Product> findAll() {
		return productRepository.findAll();
		
	}
	
	 //Actualiza Producto
	public void update(Product product) {
		productRepository.save(product);
	}

//encuentra product por id

	public Product findProduct(Long id) {
		Optional<Product> findProduct = productRepository.findById(id);
		if (findProduct.isPresent()) {
			return findProduct.get();
		} else {
			return null;
		}
	}

	
	// obtiene todos las otros productos
	public List<Product> getAllExcept(Long categoryId) {
		List<Product> products = this.findAll();
		Optional<Category> category = categoryRepository.findById(categoryId);
		if (category.isPresent()) {
			List<Product> categoryProducts = category.get().getProducts();
			products.removeAll(categoryProducts);
			return products;
		} else {
			return null;
		}
	}

	

}