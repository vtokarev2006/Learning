<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@page import="java.util.List"%>
<%@page import="model.Category"%>
<%@page import="java.util.ListIterator"%>



<%
	String param1 = application.getInitParameter("param1");
%>


<div id="menu">

	<ul id="menuList">
		<li> <p><a href="<%=param1%>">Home</a></p></li>
		<li> <p><a href="<%=param1%>?action=allBooks">All books</a></p></li>
		<p><li><b>Categories</b></li>
		<%
			List<Category> categoryList = (List<Category>)application.getAttribute("listCategory");
			ListIterator<Category> it = categoryList.listIterator();
			while(it.hasNext()){
				Category category = it.next(); 
		%>
				<span>&nbsp &nbsp<a href="<%=param1%>?action=category&categoryId=<%=category.getId()%>&categoryDescription=<%=category.getCategoryDescription()%>"><%=category.getCategoryDescription()%></a><br></span>
		<%
			}
		%>
	</p></ul>
	
	<form>
		<input type="hidden" name="action" value="search" /> 
		<input id="text" type="text" name="keyWord" size="12" />
		<input id="submit" type="submit" value="Search" />
	</form>

</div>
