<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
   
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>



	<c:forTokens items="Clojure,Groovy,Java, Scala" delims=", " var="lang"  >
		<c:out value="${lang}"></c:out>
	
	</c:forTokens>	
	
</body>
</html>