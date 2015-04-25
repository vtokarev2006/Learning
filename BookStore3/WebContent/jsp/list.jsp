<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<c:set var="category" value="${param.category}" />
<c:set var="categoryId" value="${param.categoryId}" />
<c:set var="categoryDescription" value="${param.categoryDescription}" />
<c:set var="keyWord" value="${param.keyWord}" />

<c:choose>
	<c:when test="${category != null}">
		<span> List of: <b>${categoryDescription}</b></span>
	</c:when>
	<c:when test="${keyWord != null}">
		<span> <b>Contain:</b> ${keyWord}</span>
	</c:when>
	<c:otherwise>
		<span> <b>All books</b></span>
	</c:otherwise>
</c:choose>


<br>
<br>
<table> 
	<thead>
		<tr>
			<th id="th-title">Book title</th>
			<th id = "th-author">Author</th>
		</tr>
	</thead>
	
	<tbody>
	
	<c:forEach var="book" items="${requestScope.bookList}" >
		<c:if test="${(category==null)||(category!=null&&categoryId==book.categoryId) }">
			<tr>
				<td>${book.bookTitle}</td>
				<c:forEach var="author" items="${book.authors}" varStatus="i" >
				
					<c:choose>
						<c:when test="${i.count==1}">
							<td>${author.firstName}&#160;${author.lastName}</td>
						</c:when>
						<c:otherwise>
							<tr>
								<td></td>
								<td>${author.firstName}&#160;${author.lastName}</td>
							</tr>
						</c:otherwise>
					</c:choose>
				
				</c:forEach>
			</tr>
		</c:if>
	</c:forEach>

	</tbody>
</table>