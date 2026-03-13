package com.honey.service;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.honey.domain.ItemBoard;
import com.honey.dto.CartDTO;
import com.honey.repository.CartRepository;
import com.honey.repository.ItemBoardRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Transactional
@Slf4j
@RequiredArgsConstructor
public class CartServiceImpl implements CartService {

	private final ModelMapper modelMapper;
	private final CartRepository cartReposiotory;
	private final ItemBoardRepository itemBoardRepository;
	
	@Override
	public CartDTO get(Long id) {
		Optional<ItemBoard> result = itemBoardRepository.findById(id);
		ItemBoard itemBoard = result.orElseThrow();
		return null;
	}
	
	
}
