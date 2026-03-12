package com.honey.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.honey.dto.ItemBoardDTO;
import com.honey.service.ItemBoardService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;


@RestController
@RequiredArgsConstructor
@Log4j2
@RequestMapping("/honey/itemBoard")
public class ItemBoardController {

	private final ItemBoardService service;
	
	@GetMapping("{no}")
	public ItemBoardDTO getItemBoard(@PathVariable(name = "id") Long id) {
		return service.get(id);
	}
	
	
	
	
	
}
