package com.shop.service;


import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.shop.client.ProdutoClient;
import com.shop.dto.PedidoDto;
import com.shop.dto.ProdutoDto;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class PedidoService {
	
	private final ProdutoClient produtoClient;

	public PedidoDto simularPedido(List<Long> ids) {
		List<ProdutoDto> produtos = ids.stream().map(produtoClient::getProduct).collect(Collectors.toList());
		BigDecimal total = produtos.stream().map(ProdutoDto::getPrice).reduce(BigDecimal.ZERO, BigDecimal::add);
		return new PedidoDto(produtos, total);
	}

}
