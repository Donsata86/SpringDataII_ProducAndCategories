package com.miguel.ProductosCategorias.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.miguel.ProductosCategorias.Models.Category;
import com.miguel.ProductosCategorias.Models.Product;
import com.miguel.ProductosCategorias.Repositories.CategoryRepository;
import com.miguel.ProductosCategorias.Repositories.ProductRepository;

@Service
public class CategoryService {

	// agrega dependencia

	private final CategoryRepository categoryRepository;
	private final ProductRepository productRepository;

	// Constructor
	public CategoryService(CategoryRepository categoryRepository, ProductRepository productRepository) {
		this.categoryRepository = categoryRepository;
		this.productRepository = productRepository;
	}

	// crea una categoria

	public Category createCategory(Category category) {
		return categoryRepository.save(category);
	}

	// encuentra todas categorias

	public List<Category> findAll() {
		return categoryRepository.findAll();
	}

	// encuentra categorias por id

	public Category findCategory(Long id) {
		Optional<Category> findCategory = categoryRepository.findById(id);
		if (findCategory.isPresent()) {
			return findCategory.get();
		} else {
			return null;
		}
	}

	// Actualiza Categoria
	public void update(Category category) {
		categoryRepository.save(category);
	}

	// Get all other products
	public List<Category> getAllExcept(Long productId) {
		List<Category> categories = this.findAll();
		Optional<Product> product = productRepository.findById(productId);
		if (product.isPresent()) {
			List<Category> productCategories = product.get().getCategories();
			categories.removeAll(productCategories);
			return categories;
		} else {
			return null;
		}
	}

}
