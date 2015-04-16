package model;

import java.util.List;

public class Book {
	private Long id;
	private Long categoryId;
	private List<Author> authors;
	private String bookTitle;
	private String publisheName;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}
	public List<Author> getAuthors() {
		return authors;
	}
	public void setAuthors(List<Author> authors) {
		this.authors = authors;
	}
	public String getBookTitle() {
		return bookTitle;
	}
	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}
	public String getPublisheName() {
	return publisheName;
	}
	public void setPublisheName(String publisheName) {
		this.publisheName = publisheName;
	}
	
	@Override
	public String toString() {
		return "Book - Id: " + id + ", Book Title: " + bookTitle;
	}
}
