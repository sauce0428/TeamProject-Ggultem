package com.honey.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.honey.domain.ItemBoard;
import com.honey.dto.ItemBoardDTO;
import com.honey.repository.ItemBoardRepository;
import com.honey.util.CustomFileUtil;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Transactional
@Slf4j
@RequiredArgsConstructor
public class ItemBoardServiceImpl implements ItemBoardService {

	private final ModelMapper modelMapper;
	private final ItemBoardRepository itemBoardRepository;
	private final CustomFileUtil fileUtil;

	@Override
	public ItemBoardDTO get(Long id) {
		Optional<ItemBoard> result = itemBoardRepository.findById(id);
		ItemBoard itemBoard = result.orElseThrow();

		ItemBoardDTO itemBoardDTO = modelMapper.map(itemBoard, ItemBoardDTO.class);

		List<String> fileNameList = itemBoard.getItemList().stream().map(itemList -> itemList.getFileName())
				.collect(Collectors.toList());

		if (fileNameList != null && fileNameList.isEmpty()) {
			itemBoardDTO.setUploadFileNames(fileNameList);
		} else {
			itemBoardDTO.setUploadFileNames(List.of("default.jpg"));
		}

		return itemBoardDTO;
	}

}
