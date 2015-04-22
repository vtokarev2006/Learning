package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Author;
import model.Book;
import model.Category;
import dao.BookDAO;
import dao.BookDAOImpl;

public class BookController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BookDAO bookDAO;
       
    public BookController() {
        super();
    }
    
    @Override
    public void init(ServletConfig config) throws ServletException {
    	super.init(config);
    	bookDAO = new BookDAOImpl();
    	List<Category> listCategory = bookDAO.findAllCategories();
    	config.getServletContext().setAttribute("listCategory", listCategory);

    }
    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		
		
		
		Long current = System.currentTimeMillis();
		List<Book> allBooks = bookDAO.findAllBooks();
		List<Book> booksByKeyword = bookDAO.searchBooksByKeyword("Groovy");
		List<Category> allCategories = bookDAO.findAllCategories();
		
		out.println("------------Categories------------");
		out.println();
		out.print(allCategories.size());
		
		for (Category c:allCategories) 
			out.println(c);
		
		out.println();
		out.println();
		out.println("------------Books by keyword 'Groovy'------------");

		
		for(Book b:booksByKeyword) {
			out.println(b);
			List<Author> allAuthor = b.getAuthors();
			for (Author a:allAuthor) {
				out.println("          ---- "+a);
			}
		}
		
		out.println();
		out.println();
		out.println("------------All books------------");

		
		for(Book b:allBooks) {
			out.println(b);
			List<Author> allAuthor = b.getAuthors();
			for (Author a:allAuthor) {
				out.println("          ---- "+a);
			}
		}
		
		
		
		
		out.println();
		out.println("Done in " + (System.currentTimeMillis() - current) + " milliseconds");
		
		
		
		
		
		
		
		
	}

}
