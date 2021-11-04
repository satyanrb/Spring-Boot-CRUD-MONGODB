package com.javatachie.spring.mongo.api.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Document(collection="Book")
public class Book {

	@Id
	private int id;
	private String bookName;
	private String authorName;
}
