

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
public class MultiValueFieldServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MultiValueFieldServlet() {
        super();
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
    		throws ServletException, IOException {
    	
    	
    	String[] enteredValue = req.getParameterValues("option");
    	
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		PrintWriter pw = resp.getWriter();
		
		pw.println("<p>");
		
		if (enteredValue!=null) {
			pw.println("Вы ввели: ");
			for(String s:enteredValue)
				pw.println(s);
			
		} else {
			pw.print("Вы ничего не выбрали");
		}
		pw.println("</p>");

		pw.close();
    	
    	
    	
    }
}
