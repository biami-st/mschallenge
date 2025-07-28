package com.shop.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shop.dto.ProductDto;
import com.shop.service.ProductService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/produtos")
public class ProductController {

	private final ProductService productService;

	@PostMapping
	public ResponseEntity<ProductDto> addProduct(@RequestBody ProductDto productDto) {
		ProductDto savedProduct = productService.addProduct(productDto);
		return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
	}

	@GetMapping("{id}")
	public ResponseEntity<?> getProduct(@PathVariable("id") Long id) {
		/*
		 * ProductDto ProductDto = productService.getProduct(id); return new
		 * ResponseEntity<>(ProductDto, HttpStatus.OK);
		 */
		try {
			ProductDto ProductDto = productService.getProduct(id);
			return new ResponseEntity<>(ProductDto, HttpStatus.OK);
		} catch (NoSuchElementException ex) {
			Map<String, String> error = new HashMap<>();
			error.put("error", "Não existe produto com o id: " + id);
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
		}
	}

	@GetMapping()
	public ResponseEntity<List<ProductDto>> getAllProducts() {
		List<ProductDto> ProductsDto = productService.getAllProducts();
		return new ResponseEntity<>(ProductsDto, HttpStatus.OK);
	}
}
