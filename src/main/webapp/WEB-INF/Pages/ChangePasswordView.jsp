<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
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
<sf:form  modelAttribute="form" method="post">
<div class="container-fluid" align="center"  >

<aside class="col-sm-4">

<div class="card"  align="center">
<article class="card-body">



	<h4 class="card-title text-center mb-4 mt-1" style="color: #fff;"><u><s:message code="label.changepassword"></s:message></u></h4>
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
  
   <sf:hidden path="id" />
				<sf:hidden path="createdBy" />
				<sf:hidden path="modifiedBy" />
				<sf:hidden path="createdDatetime" />
				<sf:hidden path="modifiedDatetime" />
    
	
	<div class="form-group">
			
    <div align="left" style="color:#fff; " for="validationDefault02"><s:message code="label.oldPassword" /><span style="color: red">*</span></div>
	<div class="input-group">
    <div class="input-group-prepend">
    <span class="input-group-text"> <i class="fas fa-user"></i></span></div>
		 
  <sf:label path="oldPassword">
					
					<c:set var="oldPasswordErrors">
						
					</c:set>
					<c:if test="${not empty oldPasswordErrors}">
						<i class="fa fa-exclamation-circle text-danger"
							onmouseover="showError('toldPassword')"
							onmouseout="hideError('toldPassword')"></i>
					</c:if>
						</sf:label>
				<sf:input path="oldPassword" class="form-control"
					placeholder="${enteroldpassword}" />

	
	</div>
	<div align="left"><font style="color: red" ><sf:errors path="oldPassword" /></font></div>
	
	</div>
	
	<div class="form-group">
			
    <div align="left" style="color:#fff; " for="validationDefault02"><s:message code="label.newPassword" /><span style="color: red">*</span></div>
	<div class="input-group">
    <div class="input-group-prepend">
    <span class="input-group-text"> <i class="fas fa-user"></i> </span></div>
		 
    <sf:label path="newPassword">
					
					<c:set var="newPasswordErrors">
						
					</c:set>
					<c:if test="${not empty newPasswordErrors}">
						<i class="fa fa-exclamation-circle text-danger"
							onmouseover="showError('tnewPassword')"
							onmouseout="hideError('tnewPassword')"></i>
					</c:if>
						</sf:label>
				<sf:input type="newPassword" path="newPassword" class="form-control"
					placeholder="${enternewpassword}" />
					
			
	</div>
	<div align="left"><font style="color: red" ><sf:errors path="newPassword"/></font></div>
	
	</div>
	
	<div class="form-group">
			
    <div align="left" style="color:#fff; " for="validationDefault02"><s:message code="label.confirmPassword" /><span style="color: red">*</span></div>
	<div class="input-group">
    <div class="input-group-prepend">
    <span class="input-group-text"> <i class="fas fa-user"></i> </span></div>
		 
   <sf:label path="confirmPassword">${error1}
					
					<c:set var="confirmPasswordErrors">
						
					</c:set>
					<c:if test="${not empty confirmPasswordErrors}">
						<i class="fa fa-exclamation-circle text-danger"
							onmouseover="showError('tconfirmPassword')"
							onmouseout="hideError('tconfirmPassword')"></i>
					</c:if>
							</sf:label>
				<sf:input type="password" path="confirmPassword" class="form-control"
					placeholder="${enterconPassword}" />	
					
	</div>
	<div align="left"><font style="color: red" ><sf:errors path="confirmPassword"/></font></div>
	
	</div>
	
	<%-- 
	<button type="submit" name="operation"  value="save" style="width: 70px; margin-left: 15px;" class="btn btn-info btn-block button2" ><s:message code="label.save"/> </button>
	<button type="submit" name="operation"  value="Cancel" style="width:70px;margin-left: 25px;" class="btn btn-warning btn-block button2 msgBtn" ><s:message code="label.myprofile"/></button>
		 
	 --%>
		 
		<div class="row">
<div class="clo-sm-6">
	<button type="submit" name="operation" style="width: 60px; margin-left: 15px;"  value="save"  class="btn btn-info btn-block button2 msgBtn" ><s:message code="label.save"/></button>
	</div>	 
	<div class="clo-sm-6">
	<button type="submit" name="operation" style="width: 150px;margin-left: 22px; " value="My Profile"  class="btn btn-warning btn-block button2" ><s:message code="label.myprofile"/></button>
	 </div>
	 </div>
	
	 

	
   </article>
</div>

	</aside>
	<br><br><br><br>
</div> 



</sf:form>
</body>
</html>