package test;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.UserTransaction;

import entity.Calendar;



public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@PersistenceContext
	EntityManager em;
	
	@Resource
	UserTransaction ut;
	
	
	
    public TestServlet() {
        super();
    }

protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	try {
	
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		out.print("Hello <br />");
		
		Calendar calendar = new Calendar();
		calendar.setDayOff(true);
		calendar.setDate(LocalDate.now() );
		
		
		
		ut.begin();
		em.persist(calendar );
		ut.commit();
		
		out.print(calendar.isDayOff() + "<br/>");
		out.print(calendar.getId() + "<br/>");
		
		
		
	} catch (Throwable e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		

	
	
	}

}
