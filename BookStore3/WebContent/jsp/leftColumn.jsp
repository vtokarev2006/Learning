<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@page import="java.util.List"%>
<%@page import="model.Category"%>
<%@page import="java.util.ListIterator"%>

	<c:set var="param1" value="${initParam['param1']}" ></c:set>
	

<div id="menu">

	<ul id="menuList">
		<li> <p><a href="${param1}">Home</a></p></li>
		<li> <p><a href="${param1}?action=allBooks">All books</a></p></li>
		<p><li><b>Categories</b></li>
		
		<c:forEach var="category" items="${applicationScope.listCategory}">
			<span>&nbsp&nbsp<a href="${param1}?action=category&categoryId=${category.id}&categoryDescription=${category.categoryDescription}">${category.categoryDescription}</a></span><br>
		</c:forEach>
		
		
		</p></ul>
	
		<form>
			<input type="hidden" name="action" value="search" /> 
			<input id="text" type="text" name="keyWord" size="12" />
			<input id="submit" type="submit" value="Search" />
		</form>

</div>