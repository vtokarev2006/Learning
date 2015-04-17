<%@ include file="header.jsp"  %>

<%!
	public String hello(){
		String msg = "Hello world";
		return msg;
}
%>


<%
	



	Object book=null;
	getServletContext().setAttribute("book", book);
	application.setAttribute("book", book);
	
	
	
%>


<p>

	<% out.print(hello()); %>
<p>
<%@ include file="footer.jsp"  %>
