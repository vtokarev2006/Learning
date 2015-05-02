package test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import javax.transaction.UserTransaction;

import entity.User;



public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	@PersistenceContext
	EntityManager em;

	
	@Resource
	UserTransaction ut;	
	
    public TestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		
				PrintWriter out = response.getWriter();
				response.setContentType("text/html");
				
				User user = new User();
				
				user.setFirstName("Slava1");
				user.setLastName("KPSS1");
				user.setUserName("vtokarev1");
				
				
				out.print("Before persist <br/>");
				
				out.print(user.getId());
				out.print("<br/>");
				
				
				ut.begin();
				em.persist(user);
				ut.commit();
					
				
				
				out.print("After persist <br/>");
				
				out.print(user.getId());
				
		} catch (Throwable e) {
			e.printStackTrace();
		}
		
	}

}
