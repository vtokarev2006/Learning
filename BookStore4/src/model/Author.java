package model;

public class Author {
	private Long id;
	private Long bookId;
	private String firstName;
	private String lastName;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getBookID() {
		return bookId;
	}
	public void setBookID(Long bookID) {
		this.bookId = bookID;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return "Author - Id: " + id + ", Book id: " + bookId + ", First Name: "
				+ firstName + ", Last Name: " +lastName;
	}
	
}
