package test;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.ejb.EJB;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import services.TestStatlessEJB;
import entity.Brand;
import entity.Client;



public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@PersistenceContext
	EntityManager em;
	
	
	@EJB
	TestStatlessEJB testStatlessEJB;
	
	
	
    public TestServlet() {
        super();
    }

protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//	try {
		
		String c = request.getParameter("case");
		

		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		out.print("Hello <br />");
		
		
		if (c==null) return;
		Client client = new Client();
		Brand brand1 = new Brand();
		Brand brand2 = new Brand();
		Set<Brand> brands = new HashSet<>();
		
		switch (c) {
		case "1":

			client.setName("Client");
			client.setStartDate(LocalDate.now());
			
			brand1.setName("Brand1");
			brand1.setStartDate(LocalDate.now());
			brand1.setClient(client);
			
			brand2.setName("Brand2");
			brand2.setStartDate(LocalDate.now());
			brand2.setClient(client);
			
			brands.add(brand1);
			brands.add(brand2);
			client.setBrands(brands);
			
			testStatlessEJB.persistClient(client);

			
			out.print("Client: "+client.getName() + "<br/>");
			out.print("Brands: "+client.getBrands().toString() + "<br/>");
			break;
			
			
		case "2":
			brands = testStatlessEJB.GetAllBrands();
			
			for(Brand b:brands)
				out.print(b.getName()+"<br />");
			break;
			
		}
		

		
		

		
		
/*	} catch (Throwable e) {
		e.printStackTrace();
	}
*/		

	
	
	}

}
