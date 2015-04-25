<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

	<c:set var="param1" value="${initParam['param1']}" ></c:set>
	

<div id="menu">

	<ul id="menuList">
		<li> <p><a href="${param1}">Home</a></p></li>
		<li> <p><a href="${param1}?action=allBooks">All books</a></p></li>
		<li><p><b>Categories</b><br>
		
		<c:forEach var="category" items="${applicationScope.listCategory}">
			<c:url var="url" value="" >
				<c:param name="action" value="category" />
				<c:param name="categoryId" value="${category.id}"/>
				<c:param name="categoryDescription" value="${category.categoryDescription}"/>
			</c:url>
			<span>
				&#160;&#160;
				<a href="${url}">${category.categoryDescription}</a>
			</span>
			<br>
		</c:forEach>
		
		
		</p></li></ul>
	
		<form>
			<input type="hidden" name="action" value="search" /> 
			<input id="text" type="text" name="keyWord" size="12" />
			<input id="submit" type="submit" value="Search" />
		</form>

</div>