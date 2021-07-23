<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>

<style type="text/css">
body {
	background-image: url("/ORSProject_0/resources/img/astronomy-2.jpg");
    background-size: cover;
	background-repeat: no-repeat;
	background-attachment: fixed;
	background-position: center;
} 


 .card{
   background-color:#607d8b91!important;
  
}
</style>
</head>
<body>
<sf:form method="post" modelAttribute="form">

<div class="container-fluid" align="center"  >

<aside class="col-sm-4">

<div class="card" >
<article class="card-body">


	<h4 class="card-title text-center mb-4 mt-1" style="color: #fff;"><u><s:message code="label.forgetpassword"></s:message></u></h4>
	  <lable style="color: #fff;"><u><s:message code="label.forgetpassword1"></s:message></u></lable><br><br>
               
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
			
    <div align="left" style="color:#fff; " for="validationDefault02"> <s:message code="label.email"></s:message><span style="color: red">*</span></div>
	<div class="input-group">
    <div class="input-group-prepend">
    <span class="input-group-text"> <i class="fas fa-envelope"></i> </span></div>
		 
   
	<sf:label path="login">
						<c:set var="loginErrors">
						<sf:errors path="login"/>
					</c:set>
					<c:if test="${not empty loginErrors}">
						<i class="fa fa-exclamation-circle text-danger"
							onmouseover="showError('tlogin')"
							onmouseout="hideError('tlogin')"></i>
					</c:if>
							</sf:label>
				<sf:input path="login" class="form-control"
					placeholder="${enteremail}" />
			
	
		
	</div>
	<div align="left"><font style="color: red" ><sf:errors path="login"/></font></div>
	
	</div>
	
	
    <button type="submit" name="operation"  value="Go"  class="btn btn outline-info btn-block button2" ><i  class='fa fa-paper-plane' style="color:" aria-hidden="true"></i><s:message code="label.go"/></button>
	
	</div>
	
   </article>
</div>

	</aside>
	
  </div>  

</div>  

</sf:form>
</body>
</html>