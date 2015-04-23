package controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Author;
import model.Book;


public class BookController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BookController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
/*		
		Book book = new Book();
		book.setTitle("Learning Java");
		Author author = new Author();
		author.setName("Slava KPSS");
		book.setAuthor(author);
		
		Map<String,String> map = new HashMap<>();
		map.put("Java", "Beginning Java");

		request.setAttribute("map",map);
		
		
		
		request.setAttribute("book",book);
*/		
		
		String action = request.getParameter("action");
		
		if ("boo".equals(action) ) {
			
			RequestDispatcher view = request.getRequestDispatcher("/result.jsp");
			Cookie c = new Cookie("name", "Slava KPSS");
			c.setPath("/");
			response.addCookie(c);
			
			view.forward(request, response);
			
		} else {
		
		
			RequestDispatcher view = request.getRequestDispatcher("/book.jsp");
			view.forward(request, response);
		}
		
		
	}

}
