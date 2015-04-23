<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@page import="java.util.List" %>
<%@page import="model.Category" %>
<%@page import="model.Book" %>
<%@page import="model.Author" %>


<%@page import="java.util.ListIterator"%>


<%
	String category = request.getParameter("category");
	 String categoryDescription=null;
	 Long categoryId=null;
	 
	
	if(category != null) {
		categoryDescription = request.getParameter("categoryDescription");
		categoryId = Long.parseLong(request.getParameter("categoryId"));
		
%>
		<span> List of: <b><%=categoryDescription%></b></span>
<%
	} else if (request.getParameter("keyWord") != null) { 
%>
		<span> <b>Contain:</b> <%=request.getParameter("keyWord") %> </span>
<%
	} else { 
%>
		<span> <b>All books</b></span>

<%
	}
%>




<br>
<br>
<table> 
	<thead>
		<tr></tr>
			<th id="th-title">Book title</th>
			<th id = "th-author">Author</th>
		<tr></tr>
	</thead>
	
	<tbody>
		
<%
		List<Book> books = (List<Book>)request.getAttribute("bookList");
		ListIterator<Book> it = books.listIterator();
		while(it.hasNext()) {
			Book book = it.next();
			if ((category!=null)&&(book.getCategoryId()!=categoryId)) continue;
%>
		<tr>
			<td><%=book.getBookTitle()%></td>
<%
			List<Author> authors = book.getAuthors();
			ListIterator<Author> au = authors.listIterator();
			int i=1;
			while(au.hasNext()){
				Author author = au.next();
				if (i==1) {
%>
					<td><%=author.getFirstName()+" "+ author.getLastName()%></td>

<%					i++;
				} else {
%>
					<tr>
						<td></td>
						<td><%=author.getFirstName()+" "+ author.getLastName()%></td>
					</tr>
<%					
				}
			}
			
%>
		
		
		
		
		</tr>	
	
<%}%>
	
	
	</tbody>








	
	
</table>