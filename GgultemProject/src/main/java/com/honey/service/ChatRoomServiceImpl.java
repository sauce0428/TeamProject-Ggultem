package com.honey.service;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.honey.domain.ChatRoom;
import com.honey.dto.ChatRoomDTO;
import com.honey.repository.ChatRoomRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ChatRoomServiceImpl implements ChatRoomService {
	private final ModelMapper modelMapper;
	private final ChatRoomRepository repository;

	@Override
	public ChatRoomDTO get(Long roomId) {
		Optional<ChatRoom> result = repository.findById(roomId);
		ChatRoom chatRoom = result.orElseThrow();
		
		ChatRoomDTO chatRoomDTO = modelMapper.map(chatRoom, ChatRoomDTO.class);
		
		return chatRoomDTO;
	}
	
	@Override
	public Long register(ChatRoomDTO chatRoomDTO) {
		ChatRoom chatRoom = modelMapper.map(chatRoomDTO, ChatRoom.class);
		
		chatRoom.changeEnabled(1);
		
		ChatRoom savedChatRoom = repository.save(chatRoom);
		
		return savedChatRoom.getRoomId();
	}

	
}
