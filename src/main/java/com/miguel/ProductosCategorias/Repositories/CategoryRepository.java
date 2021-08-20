package com.miguel.ProductosCategorias.Repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.miguel.ProductosCategorias.Models.Category;

@Repository
public interface CategoryRepository extends  CrudRepository<Category, Long> {

	List<Category> findAll();
}

