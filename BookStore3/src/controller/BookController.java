package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Book;
import model.Category;
import dao.BookDAO;
import dao.BookDAOImpl;

public class BookController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BookController() {
        super();
    }
    
    @Override
    public void init(ServletConfig config) throws ServletException {
    	super.init(config);
    	BookDAO bookDAO = new BookDAOImpl();
    	List<Category> listCategory = bookDAO.findAllCategories();
    	config.getServletContext().setAttribute("listCategory", listCategory);

    }
    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String base = "/jsp/";
		String url = base + "home.jsp";
		String action = request.getParameter("action");
		String category = request.getParameter("category");
		String keyWord = request.getParameter("keyWord");
		
		if(action != null){
			switch (action) {
			
			case "allBooks":
				findAllBooks(request, response);
				url = base + "listOfBooks.jsp";
				break;

			case "category":
				findAllBooks(request, response);
				url = base + "category.jsp?category="+category;
				break;

			case "search":
				searchBooks(request, response, keyWord);
				url = base + "searchResult.jsp";
				break;
			}
			
		};
		
		RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher(url);
		requestDispatcher.forward(request, response);
		
		
		
/*		
		PrintWriter out = response.getWriter();
		
		
		
		Long current = System.currentTimeMillis();
		List<Book> allBooks = bookDAO.findAllBooks();
		List<Book> booksByKeyword = bookDAO.searchBooksByKeyword("Groovy");
		List<Category> allCategories = bookDAO.findAllCategories();
		
		out.println("<b>------------Categories------------</b><br>");
		
		for (Category c:allCategories) 
			out.println(c+"<br>");
		
		out.println("<br>");
		out.println("<br>");
		out.println("<b>------------Books by keyword 'Groovy'------------</b><br>");

		
		for(Book b:booksByKeyword) {
			out.println(b+"<br>");
			List<Author> allAuthor = b.getAuthors();
			for (Author a:allAuthor) {
				out.println("&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp---- "+a+"<br>");
			}
		}
		
		out.println("<br>");
		out.println("<br>");
		out.println("<b>------------All books------------</b><br>");

		
		for(Book b:allBooks) {
			out.println(b+"<br>");
			List<Author> allAuthor = b.getAuthors();
			for (Author a:allAuthor) {
				out.println("&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp---- "+a+"<br>");
			}
		}
		
		
		
		
		out.println("<br>");
		out.println("<b>Done in " + (System.currentTimeMillis() - current) + " milliseconds</b>");
*/		
		
	}
	
	private void findAllBooks(HttpServletRequest request, HttpServletResponse response){
		BookDAO bookDAO = new BookDAOImpl();
		List<Book> bookList = bookDAO.findAllBooks();
		request.setAttribute("bookList", bookList);
	}
	
	private void searchBooks(HttpServletRequest request, HttpServletResponse response, String keyWord){
		BookDAO bookDAO = new BookDAOImpl();
		List<Book> bookList = bookDAO.searchBooksByKeyword(keyWord);
		request.setAttribute("bookList", bookList);
	}
	
	
	

}
