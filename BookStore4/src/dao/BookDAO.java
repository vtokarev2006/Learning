package dao;

import java.util.List;

import model.Book;
import model.Category;
import model.User;

public interface BookDAO {
	public List<Book> findAllBooks();
	public List<Book> searchBooksByKeyword(String keyWord);
	public List<Category> findAllCategories();
	public List<Book> findBooksByCategory(int categoryId);	
	public boolean isUserAllowed(User user);
	
	public void insert(Book book);
	public void update(Book book);
	public void delete(Long bookId);
}