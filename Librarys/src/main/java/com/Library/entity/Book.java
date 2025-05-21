package com.Library.entity;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.NoArgsConstructor;


	@NoArgsConstructor
	@Entity
	@Table(name = "BOOKS")
	public class Book {
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Integer id;
		@Column(length = 256, nullable = false, unique = true)
		private String title;
		@Column(length = 100, nullable = false)
		private String genre;
		@Column(precision = 6, scale = 2)
		private BigDecimal price;
		
		@Override
		public String toString() {
			return "Book [id=" + id + ", title=" + title + ", genre=" + genre + ", price=" + price + "]";
		}

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public String getGenre() {
			return genre;
		}

		public void setGenre(String genre) {
			this.genre = genre;
		}

		public BigDecimal getPrice() {
			return price;
		}

		public void setPrice(BigDecimal price) {
			this.price = price;
		}

		
}
