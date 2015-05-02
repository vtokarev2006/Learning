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
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

import model.User;

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
		
		out.print("Hello");
		
		User user = new User();
		
		user.setFirstName("Slava");
		user.setLastName("KPSS");
		
		ut.begin();
		em.persist(user);
		ut.commit();

	} catch (NotSupportedException e) {
		e.printStackTrace();
	} catch (SystemException e) {
		e.printStackTrace();
	} catch (SecurityException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IllegalStateException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (RollbackException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (HeuristicMixedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (HeuristicRollbackException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	}

}
