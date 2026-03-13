package com.honey.service;

import com.honey.dto.ChatRoomDTO;

public interface ChatRoomService {

	public ChatRoomDTO get(Long roomId);

	public Long register(ChatRoomDTO chatRoomDTO);
	
	
}
