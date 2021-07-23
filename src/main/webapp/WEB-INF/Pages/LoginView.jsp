<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@page isELIgnored="false" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">


<style type="text/css">
body {
	background-image: url("/ORSProject_0/resources/img/galaxy.jpg");
    background-size: cover;
	background-repeat: no-repeat;
	background-attachment: fixed;
	background-position: center;
} 

 .card{
   background-color:#607d8b91!important;
  
}
 

	.button2 {
  background-color: white; 
  color: black; 
  border: 2px solid #257b0e;
}
.button2:hover {
  background-color: #257b0e;
  color: white;
}


</style>
<style type="text/css">
 
</style>
</head>
<body>
<sf:form   method="post" modelAttribute="form">

<sf:hidden  path="uri" value="${uri}"></sf:hidden>

<div class="container-fluid" align="center"  >

<aside class="col-sm-4">

<!-- <div class="card" style="background-color: rgb(255,255,255);opacity: 0.7;"> -->
<div class="card" >
<article class="card-body">

<a href="<c:url value="/Registration"></c:url>" class="float-right btn btn-info"><s:message code="label.signup"></s:message></a>

	<h3 class="card-title text-center mb-4 mt-1" style="color: #fff;"><u><s:message code="label.login"></s:message>:</u></h3>
	
	<hr color="white">
	<c:if test="${success != null}">
  <div class="alert alert-success alert-dismissible fade show">
    <button type="button" class="close" data-dismiss="alert">&times;</button>
    <b>${success}</b>
  </div>
  </c:if>
  
  <c:if test="${error != null}">
  <div class="alert alert-danger alert-dismissible fade show">
    <button type="button" class="close" data-dismiss="alert">&times;</button>
  <b>${error}</b>
  </div>
  </c:if>
  
  
	<div class="form-group">
			
    <div align="left" style="color:#fff; " for="validationDefault02">
    
    
	<sf:label path="emailId">
				
    <s:message code="label.email"></s:message><span style="color: red">*</span></div>
	<div class="input-group">
    <div class="input-group-prepend">
    <span class="input-group-text"><i class="fas fa-envelope"></i> </span></div>
		            
		          		
					
				</sf:label>
				
				<sf:input type="text" path="emailId" class="form-control"
					placeholder="${enteremail}" />

						 
  	
	</div>
	<div align="left"><font style="color: red" ><sf:errors path="emailId"/></font></div>
	
	</div>
	
	<div class="form-group">
	
	<div align="left" style="color:#fff;  for="validationDefault02">
	
	<sf:label path="password">
    <s:message code="label.password"></s:message><span style="color: red">*</span></div>
	<div class="input-group">
	<div class="input-group-prepend">
    <span class="input-group-text"> <i class="fa fa-lock"></i> </span></div>
    
    
	</sf:label>
	<sf:input type="password" path="password" class="form-control" placeholder="${enterpassword}" /> </div>
	<div align="left"> <font style="color: red"><sf:errors path="password"/></font></div></div>
	<br>
     <button type="submit" name="operation"  value="SignIn"  class="btn btn-primary btn-block button2" title="this is for login">
     <i  class='fa fa-paper-plane' style="color:" aria-hidden="true"></i> <s:message code="label.login"></s:message></button>
	
	<p class="text-center"><a href="<c:url value="ForgotPassword"/>" class="btn" style="color:white"	 title="this is for recover password"><u><s:message
					code="label.forgetpassword" />?</u></a></p>
	</div>
	
   </article>
</div>

	</aside>
	<br><br><br><br><br><br>
</div> 

</div> 

</sf:form>
</body>

</html>