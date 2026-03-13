package com.honey.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.honey.dto.CartDTO;
import com.honey.service.CartService;
import com.honey.service.ItemBoardService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RestController
@RequiredArgsConstructor
@Log4j2
@RequestMapping("/honey/cart")
public class CartController {

	private final CartService cartService;
	private final ItemBoardService itemBoardService;
	
	@GetMapping("{id}")
	public CartDTO getCart(@PathVariable(name = "id")Long id) {
		return cartService.get(id);
	}
}
