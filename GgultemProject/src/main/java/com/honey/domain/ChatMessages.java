package com.honey.domain;

import com.honey.common.BaseTimeEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "chatmessages")
@SequenceGenerator(name = "CHATMESSAGES_SEQ_GEN",
		sequenceName = "CHATMESSAGES_SEQ",
		initialValue = 1,
		allocationSize = 1)
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ChatMessages extends BaseTimeEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CHATMESSAGES_SEQ_GEN")
	private Long msgId;
	
	@ManyToOne
    @JoinColumn(name = "ROOM_ID") // 실제 DB 테이블의 FK 컬럼명을 지정
	private ChatRoom chatRoom;
	
	private String senderId;
	private String content;
	private int isRead;
}
