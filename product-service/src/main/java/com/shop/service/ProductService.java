package com.shop.service;

import java.util.List;
import com.shop.dto.ProductDto;

public interface ProductService {
	
ProductDto addProduct(ProductDto productDto);
ProductDto getProduct(Long id);
List<ProductDto> getAllProducts();

}
