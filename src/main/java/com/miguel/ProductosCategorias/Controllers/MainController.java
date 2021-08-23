package com.miguel.ProductosCategorias.Controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.miguel.ProductosCategorias.Models.Category;
import com.miguel.ProductosCategorias.Models.Product;
import com.miguel.ProductosCategorias.Services.CategoryService;
import com.miguel.ProductosCategorias.Services.ProductService;

@Controller
public class MainController {
	// Agrega dependencias

	private final ProductService productService;
	private final CategoryService categoryService;

	// Constructor
	public MainController(ProductService productService, CategoryService categoryService) {
		this.productService = productService;
		this.categoryService = categoryService;

	}

	@RequestMapping("/")
	public String index() {
		return "/index.jsp";
	}

	// Crear un nuevo producto
	@RequestMapping("/products/new")
	public String newProduct(@ModelAttribute("product") Product product, Model model) {
		return "/newProduct.jsp";
	}

	@RequestMapping(value = "/products/new", method = RequestMethod.POST)
	public String createProduct(@Valid @ModelAttribute("product") Product product, BindingResult result, Model model) {
		if (result.hasErrors()) {
			List<Category> categories = categoryService.findAll();
			model.addAttribute("categories", categories);
			return "redirect:/products/new";
		} else {
			productService.createProduct(product);
			return "redirect:/products/new";
		}
	}

	/// obtiene priducto  by Id
	@RequestMapping("products/{id}")
	public String showProduct(@PathVariable("id") Long id, Model model) {

		Product product = productService.findProduct(id);
		model.addAttribute("product", product);
		model.addAttribute("categories", categoryService.getAllExcept(id));

		return "showProduct.jsp";
	}

	// Actualiza producto

	@PostMapping("products/{id}")
	public String updateProduct(@PathVariable("id") Long productId, @RequestParam("category") Long categoryId) {
		Product product = productService.findProduct(productId);
		Category category = categoryService.findCategory(categoryId);
		List<Category> categories = product.getCategories();
		categories.add(category);
		productService.update(product);
		return "redirect:/products/"+productId;
	}
	
	
	//crea una nueva categoria
	
	@RequestMapping("/categories/new")
	public String newCategory(@ModelAttribute("category") Category category, Model model) {

		return "/newCategory.jsp";
	}

	@RequestMapping(value = "/categories/new", method = RequestMethod.POST)
	public String createCategory(@Valid @ModelAttribute("category") Category category, BindingResult result,
			Model model) {
		if (result.hasErrors()) {
			List<Product> products = productService.findAll();
			model.addAttribute("products", products);
			return "redirect:/categories/new";
		} else {
			categoryService.createCategory(category);
			return "redirect:/categories/new";
		}
	}
	// Obetener categoria By ID

	// Update category
	@RequestMapping("/categories/{id}")
	public String showCat( @PathVariable("id") Long id, Model model) {
		Category category = categoryService.findCategory(id);
		model.addAttribute("category", category);
		model.addAttribute("products", productService.getAllExcept(id));
		return "showCategory.jsp";
	}

	@PostMapping("/categories/{id}")
	public String addProduct(@PathVariable("id") Long categoryId, @RequestParam("product") Long productId) {
		Category category = categoryService.findCategory(categoryId);
		Product product = productService.findProduct(productId);
		List<Product> products = category.getProducts();
		products.add(product);
		categoryService.update(category);
		return "redirect:/categories/"+categoryId;
	}
	
	
}