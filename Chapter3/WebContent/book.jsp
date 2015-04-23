<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>

<body>

	<form action="books" method="post">
	
		<input type="hidden" name="action" value="boo"/>
		
		<p>Book Title:<input type="text" name="bookTitle"></p>
		<p>Author 1 Name:<input type="text" name="authorName"></p>
		<p>Author 2 Name:<input type="text" name="authorName"></p>
		
		<input type="submit"/>
	</form>
			
</body>

</html>