package client;

import java.util.List;

import model.Author;
import model.Book;
import model.Category;
import dao.BookDAO;
import dao.BookDAOImpl;

public class ConsoleClient {

	public static void main(String[] args) {
		BookDAO bookDAO = new BookDAOImpl();
		
		Long current = System.currentTimeMillis();
		List<Book> allBooks = bookDAO.findAllBooks();
		List<Book> booksByKeyword = bookDAO.searchBooksByKeyword("Java");
		List<Category> allCategories = bookDAO.findAllCategories();
		
		System.out.println("------------Categories------------");
		System.out.println();
		
		for (Category c:allCategories) 
			System.out.println(c);
		
		System.out.println();
		System.out.println();
		System.out.println("------------Books by keyword 'Java'------------");

		
		for(Book b:booksByKeyword) {
			System.out.println(b);
			List<Author> allAuthor = b.getAuthors();
			for (Author a:allAuthor) {
				System.out.println("          ---- "+a);
			}
		}
		
		System.out.println();
		System.out.println();
		System.out.println("------------All books------------");

		
		for(Book b:allBooks) {
			System.out.println(b);
			List<Author> allAuthor = b.getAuthors();
			for (Author a:allAuthor) {
				System.out.println("          ---- "+a);
			}
		}
		
		
		
		
		System.out.println();
		System.out.println("Done in " + (System.currentTimeMillis() - current) + " milliseconds");
		
		
		
	}

}
