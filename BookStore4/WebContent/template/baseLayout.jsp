<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%><!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title><tiles:insertAttribute name="title" ignore="true" /></title>
	</head>
	
	<body>
	
		<div id="centered">
		
			<tiles:insertAttribute name="header"/>
		
			<tiles:insertAttribute name="menu"/>
		
			<tiles:insertAttribute name="body"/>
		
		</div>
	
	</body>
</html>