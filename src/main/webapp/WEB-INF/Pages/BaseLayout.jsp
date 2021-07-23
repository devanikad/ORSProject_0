<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC >
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ page isErrorPage="false"%>
<html>
<head>
<meta charset="utf-8">

<meta
	content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0'
	name='viewport' />
<title>Rays Technologies</title>
<link rel="shortcut icon" href="/ORSProject_0/resources/img/icon.jpg" type="image/x-icon" class="img-circle"/>
</head>


	<tiles:insertAttribute name="header"></tiles:insertAttribute>
	<body>
	
<br><br>
	<div class="container-fluid" >

	<tiles:insertAttribute name="menu"></tiles:insertAttribute>


<div class="row ">
<div class="col-sm-1"></div>
<div class="col-sm-11">
	<tiles:insertAttribute name="body"></tiles:insertAttribute>
</div>
<!-- <div class="col-sm-1"></div> -->
</div>
</div>


	<tiles:insertAttribute name="footer"></tiles:insertAttribute>


</body>
</html>