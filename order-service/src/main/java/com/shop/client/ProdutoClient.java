package com.shop.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.shop.dto.ProdutoDto;

@FeignClient(value = "product-service", path="/produtos")
public interface ProdutoClient {

    @GetMapping("/{id}")
    ProdutoDto getProduct(@PathVariable Long id);

    @GetMapping()
    List<ProdutoDto> getAllProducts();
}