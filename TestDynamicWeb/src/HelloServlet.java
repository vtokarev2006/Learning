

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloServlet
 */
@WebServlet("/HelloServlet")
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelloServlet() {
        super();
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
    		throws ServletException, IOException {
    	
    	
    	String enteredValue = req.getParameter("enteredValue");
    	
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		PrintWriter pw = resp.getWriter();
		
		
		pw.println("<p>");
		pw.print("Вы ввели: ");
		pw.println(enteredValue);
	
		
		pw.println("</p>");

		pw.close();
    	
    	
    	
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
    		throws ServletException, IOException {
    	// TODO Auto-generated method stub
    	String enteredValue = req.getParameter("enteredValue");
    	
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		PrintWriter pw = resp.getWriter();
		

		
		pw.println("<p>");
		pw.print("Вы ввели: ");
		pw.println(enteredValue);
	
		
		pw.println("</p>");

		pw.close();
    }
    
    
}
