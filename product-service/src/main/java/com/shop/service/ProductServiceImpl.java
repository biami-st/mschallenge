package com.shop.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.shop.dto.ProductDto;
import com.shop.entity.Product;
import com.shop.repository.ProductRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class ProductServiceImpl implements ProductService {

	private final ProductRepository productRepository;
	private ModelMapper modelMapper;

	@Override
	public ProductDto addProduct(ProductDto productDto) {
		Product product = modelMapper.map(productDto, Product.class);
		Product savedProduct = productRepository.save(product);
		ProductDto savedProductDto = modelMapper.map(savedProduct, ProductDto.class);
		return savedProductDto;
	}

	@Override
	public ProductDto getProduct(Long id) {
		Product product = productRepository.findById(id).orElseThrow();
		return modelMapper.map(product, ProductDto.class);
	}

	@Override
	public List<ProductDto> getAllProducts() {
		List<Product> allProducts = productRepository.findAll();
		return allProducts.stream().map((product) -> modelMapper.map(product, ProductDto.class)).collect(Collectors.toList());
	}

}
