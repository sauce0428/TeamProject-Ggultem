package com.honey.domain;

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
@Getter
@ToString
@Table(name = "cart")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@SequenceGenerator(name = "CART_SEQ_GEN", sequenceName = "CART_SEQ", allocationSize = 1, initialValue = 1)
public class Cart {

	@Id
	@GeneratedValue(generator = "CART_SEQ_GEN",strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "MEMBER_NO")
	private Member member;
	
	@ManyToOne
	@JoinColumn(name = "ITEM_ID")
	private ItemBoard itemBoard;
	
}
