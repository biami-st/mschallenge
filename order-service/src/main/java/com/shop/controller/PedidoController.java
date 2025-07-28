package com.shop.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shop.dto.PedidoDto;

import com.shop.service.PedidoService;

import feign.FeignException;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/pedidos")
public class PedidoController {

	@Autowired
	private PedidoService pedidoService;

	@PostMapping
	public ResponseEntity<?> simular(@RequestBody List<Long> ids) {
		/*
		 * PedidoDto pedido = pedidoService.simularPedido(ids); return
		 * ResponseEntity.ok(pedido);
		 */
		try {
			PedidoDto pedido = pedidoService.simularPedido(ids);
			return ResponseEntity.ok(pedido);
		} catch (FeignException feignEx) {
			Map<String, String> error = new HashMap<>();
			error.put("error", "Não foi possível buscar o produto: " + feignEx.getMessage());
			return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
