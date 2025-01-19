package com.crud.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.crud.entity.Product;

public interface ProductRespository extends JpaRepository<Product, Long> {
	    Page<Product> findAll(Pageable pageable);
	}

