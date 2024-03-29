package com.sahuyash.Book.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@Data
@Table(name="book")
public class Book {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="bid")
	private int bid;
	
	@Column(name="title")
	private String title;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "author_id")
	private Name author;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "price_id")
	private Collection<Price> availablePrice;

}
