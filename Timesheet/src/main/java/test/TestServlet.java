package test;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.UserTransaction;

import entity.Brand;
import entity.Client;



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
		ut.begin();
		
		
		
	
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		out.print("Hello <br />");
		
		
		Client client = new Client();
		client.setName("Client");
		client.setStartDate(LocalDate.now());
		
		Brand brand1 = new Brand();
		brand1.setName("Brand1");
		brand1.setStartDate(LocalDate.now());
		
		Brand brand2 = new Brand();
		brand2.setName("Brand2");
		brand2.setStartDate(LocalDate.now());
		
		

		
		Set<Brand> brands = new HashSet<>();
		brands.add(brand1);
		brands.add(brand2);
		client.setBrands(brands);
		
		

		em.persist(client);
		em.persist(brand1);
		em.persist(brand2);

		
	
		
		out.print("Client: "+client.getName() + "<br/>");
		out.print("Brands: "+client.getBrands().toString() + "<br/>");
		
		
		ut.commit();
		
		
	} catch (Throwable e) {
		e.printStackTrace();
	}
		

	
	
	}

}
