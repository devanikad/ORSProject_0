<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@page isELIgnored="false"%>
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
<sf:form  modelAttribute="form" method="post">
<div class="container-fluid" align="center"  >
<aside class="col-sm-4">

<div class="card"  align="center" >
<article class="card-body">

<c:choose>
           			<c:when test="${form.id==0}"><h4 style="color: #fff;"><u><s:message code="label.myprofile" /></u></h4></c:when>
           			<c:otherwise><h4 style="color: #fff;"><u><s:message code="label.myprofile" /></u></h4></c:otherwise>
           		</c:choose> 
		

	<%-- <c:choose>
           			<c:when test="${form.id==0}"><h4 class="card-title text-center mb-4 mt-1" style="color: #C71585;"><s:message code="label.myprofile"></s:message></h4></c:when>
           			<c:otherwise></c:otherwise>
           		</c:choose> 
			
	 --%>
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
			
    <div align="left" style="color:#fff; " for="validationDefault02"><s:message code="label.email" /><span style="color: red">*</span></div>
	<div class="input-group">
    <div class="input-group-prepend">
    <span class="input-group-text"> <i class='fas fa-calendar-alt'></i></span></div>
		 
   <sf:label path="login">
					
					
					<c:set var="loginErrors">
						
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
	
	
	<div class="form-group">
			
    <div align="left" style="color:#fff; " for="validationDefault02"><s:message code="label.firstName" /><span style="color: red">*</span></div>
	<div class="input-group">
    <div class="input-group-prepend">
    <span class="input-group-text"> <i class="fas fa-user"></i></span></div>
		 
   <sf:label path="firstName">
					
					<c:set var="firstNameErrors">
						
					</c:set>
					<c:if test="${not empty firstNameErrors}">
						<i class="fa fa-exclamation-circle text-danger"
							onmouseover="showError('tfirstName')"
							onmouseout="hideError('tfirstName')"></i>
					</c:if>
					<sf:errors path="firstName" />		</sf:label>
				<sf:input path="firstName" class="form-control"
					placeholder="${enterfirstName}" />

		
	</div>
	<div align="left"><font style="color: red" ><sf:errors path="firstName" /></font></div>
	
	</div>
	
	<div class="form-group">
			
    <div align="left" style="color:#fff; " for="validationDefault02"><s:message code="label.lastName" /><span style="color: red">*</span></div>
	<div class="input-group">
    <div class="input-group-prepend">
    <span class="input-group-text"> <i class="fas fa-user"></i> </span></div>
		 
   <sf:label path="lastName">
					
					<c:set var="lastNameErrors">
					
					</c:set>
					<c:if test="${not empty lastNameErrors}">
						<i class="fa fa-exclamation-circle text-danger"
							onmouseover="showError('tlastName')"
							onmouseout="hideError('tlastName')"></i>
					</c:if>
						</sf:label>
				<sf:input path="lastName" class="form-control"
					placeholder="${enterLastName}"/>
	
	</div>
	<div align="left"><font style="color: red" >	<sf:errors path="lastName" /></font></div>
	
	</div>
	
	
	
	
	<div class="form-group">
			
    <div align="left" style="color:#fff; " for="validationDefault02"><s:message code="label.gender"/><span style="color: red">*</span></div>
	<div class="input-group">
    <div class="input-group-prepend">
    <span class="input-group-text"> <i class='fas fa-venus-double'></i></span></div>
		 
   <sf:label path="gender">
					
					<c:set var="genderErrors">
						
					</c:set>
					<c:if test="${not empty genderErrors}">
						<i class="fa fa-exclamation-circle text-danger"
							onmouseover="showError('tgender')"
							onmouseout="hideError('tgender')"></i>
					</c:if>
							</sf:label>
				<sf:select path="gender" class="form-control">
					<sf:option value="">
						<s:message code="label.selectgender"></s:message>
					</sf:option>
					<sf:options items="${genderList}" />
				</sf:select>
				
								
              
 	
	</div>
	<div align="left"><font style="color: red" ><sf:errors path="gender"/></font></div>
	
	</div>
	
	<div class="form-group">
	
	<div align="left" style="color:#fff;  for="validationDefault02"><s:message code="label.dob" /><span style="color: red">*</span></div>
	<div class="input-group">
	<div class="input-group-prepend">
    <span class="input-group-text"> <i class='fas fa-calendar-alt'></i></span></div>
	    
	<sf:label path="dob">
					
					<c:set var="dobErrors">
						
					</c:set>
					<c:if test="${not empty dobErrors}">
						<i class="fa fa-exclamation-circle text-danger"
							onmouseover="showError('tdob')" onmouseout="hideError('tdob')"></i>
					</c:if>
							</sf:label>
				<sf:input path="dob" class="form-control date"
					placeholder="${enterdob}" autocomplete="off" />

</div>
	
	<div align="left"> <font style="color: red"><sf:errors path="dob" /></font></div>
	</div>
	
	<div class="form-group">
	
	<div align="left" style="color:#fff;  for="validationDefault02"><s:message code="label.mobileNo" /><span style="color: red">*</span></div>
	<div class="input-group">
	<div class="input-group-prepend">
    <span class="input-group-text"> <i class='fas fa-mobile-alt'></i> </span></div>
	    
	<sf:label path="mobileNo">
					
					<c:set var="mobileNoErrors">
						
					</c:set>
					<c:if test="${not empty mobileNoErrors}">
						<i class="fa fa-exclamation-circle text-danger"
							onmouseover="showError('tmobileNo')"
							onmouseout="hideError('tmobileNo')"></i>
					</c:if>
						</sf:label>
				<sf:input path="mobileNo" class="form-control" maxlength="10"
					placeholder="${enterMobile}" />
					
				
	</div>
	<div align="left"> <font style="color: red"><sf:errors path="mobileNo" /></font></div>
	</div>
	
<div class="row">
<div class="clo-sm-6">
	<button type="submit" name="operation" style="width: 60px; margin-left: 15px;"  value="save"  class="btn btn-info btn-block button2 msgBtn" ><s:message code="label.save"/></button>
	</div>	 
	<div class="clo-sm-6">
	<button type="submit" name="operation" style="width: 150px;margin-left: 22px; " value="ChangePassword"  class="btn btn-warning btn-block button2" ><s:message code="label.changepassword"/></button>
	 </div>
	 </div>
	

	
   </article>
</div>

	</aside>
	<br>
</div> 

 

</sf:form>
</body>
</html>