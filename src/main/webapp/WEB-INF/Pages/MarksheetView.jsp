
<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@page isELIgnored="false"%>
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

<div class="card"  align="center">
<article class="card-body">
	<c:choose>
<c:when test="${form.id==0}"><h4 class="card-title text-center mb-4 mt-1" style="color: #fff;"><u><s:message code="label.addmarksheet" /></u></h4></c:when>
<c:otherwise><h4 class="card-title text-center mb-4 mt-1" style="color: #fff;"><u><s:message code="label.updatemarksheet"></s:message></u></h4>
</c:otherwise>
</c:choose> 
	
	
	
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
			
    <div align="left" style="color:#fff; " for="validationDefault02"><s:message code="label.rollNo" /><span style="color: red">*</span></div>
	<div class="input-group">
    <div class="input-group-prepend">
    <span class="input-group-text"><i class="fa fa-university"></i> </span></div>
		 
   <sf:label path="rollNo">
					
					<c:set var="rollNoErrors">
						
					</c:set>
					<c:if test="${not empty rollNoErrors}">
						<i class="fa fa-exclamation-circle text-danger"
							onmouseover="showError('trollNo')"
							onmouseout="hideError('trollNo')"></i>
					</c:if>
							</sf:label>
				<sf:input path="rollNo" class="form-control"
					placeholder="${enterRollNo}"/>
				
				
	</div>
	<div align="left"><font style="color: red" ><sf:errors path="rollNo" /></font></div>
	
	</div>
	
	<div class="form-group">
			
    <div align="left" style="color:#fff; " for="validationDefault02"><s:message code="label.name" /><span style="color: red">*</span></div>
	<div class="input-group">
    <div class="input-group-prepend">
    <span class="input-group-text"> <i class="fas fa-user"></i></span></div>
		 
    <sf:label path="studentId">
					
					<c:set var="studentIdErrors">
						
					</c:set>
					<c:if test="${not empty studentIdErrors}">
						<i class="fa fa-exclamation-circle text-danger"
							onmouseover="showError('tstudentId')"
							onmouseout="hideError('tstudentId')"></i>
					</c:if>
							</sf:label>
					<sf:select path="studentId" class="form-control">
					<sf:option value="0">
						<s:message code="label.select"></s:message>
					</sf:option>
					<sf:options items="${studentList}" itemValue="id" itemLabel="firstName"/>
				</sf:select>

               	
	</div>
	<div align="left"><font style="color: red" ><sf:errors path="studentId" /></font></div>
	
	</div>
	
	<div class="form-group">
			
    <div align="left" style="color:#fff; " for="validationDefault02"><s:message code="label.physics" /><span style="color: red">*</span></div>
	<div class="input-group">
    <div class="input-group-prepend">
    <span class="input-group-text"> <i class="fas fa-star"></i></i> </span></div>
		 
  <sf:label path="physics">
					
					<c:set var="physicsErrors">
							</c:set>
					<c:if test="${not empty physicsErrors}">
						<i class="fa fa-exclamation-circle text-danger"
							onmouseover="showError('tphysics')"
							onmouseout="hideError('tphysics')"></i>
					</c:if>
							</sf:label>
				<sf:input path="physics" class="form-control"
					placeholder="${enterPhysics}"/>
				
	</div>
	<div align="left"><font style="color: red" ><sf:errors path="physics" />
				</font></div>
	
	</div>
	
	<div class="form-group">
	
	<div align="left" style="color:#fff;  for="validationDefault02"><s:message code="label.chemistry" /><span style="color: red">*</span></div>
	<div class="input-group">
	<div class="input-group-prepend">
    <span class="input-group-text"> <i class='fas fa-star'></i></span></div>
	    
	 <sf:label path="chemistry">
					
					<c:set var="chemistryErrors">
						
					</c:set>
					<c:if test="${not empty chemistryErrors}">
						<i class="fa fa-exclamation-circle text-danger"
							onmouseover="showError('tchemistry')"
							onmouseout="hideError('tchemistry')"></i>
					</c:if>
				    </sf:label>
				<sf:input path="chemistry" class="form-control"
					placeholder="${enterChemistry}"/>
			</div>
	
	<div align="left"> <font style="color: red"><sf:errors path="chemistry" /></font></div>
	</div>
	
	<div class="form-group">
	
	<div align="left" style="color:#fff;  for="validationDefault02"><s:message code="label.maths" /><span style="color: red">*</span></div>
	<div class="input-group">
	<div class="input-group-prepend">
    <span class="input-group-text"> <i class='fas fa-star'></i> </span></div>
	 <sf:label path="maths">
					
					<c:set var="mathsErrors">
						
					</c:set>
					<c:if test="${not empty mathsErrors}">
						<i class="fa fa-exclamation-circle text-danger"
							onmouseover="showError('tmaths')"
							onmouseout="hideError('tmaths')"></i>
					</c:if>
							</sf:label>
				<sf:input path="maths" class="form-control"
					placeholder="${enterMaths}"/>
					
				</div>
	
	<div align="left"> <font style="color: red"><sf:errors path="maths" /></font></div>
	</div>
	
		<c:choose>
              		<c:when test="${form.id==0}"> 
				
	 <button type="submit" name="operation" style="float: left;width: 70px; margin-left: 50px;"  value="save"  class="btn btn-info btn-block button2 msgBtn" ><s:message code="label.save" /></button>
		 
	
	<button type="submit" name="operation" style="width: 70px;margin-left: 80px;" value="reset"  class="btn btn-warning btn-block button2" ><s:message code="label.reset" /></button>
	  
	</c:when>
						<c:otherwise>
					
	<button type="submit" name="operation" style="float: left;width: 70px; margin-left: 50px;"  value="save"  class="btn btn-info btn-block button2 msgBtn" ><s:message code="label.update" /></button>
		 
	
	<button type="submit" name="operation" style="width: 70px;margin-left: 80px;" value="Cancel"  class="btn btn-warning btn-block button2" ><s:message code="label.cancel" /></button>
	</c:otherwise>
				</c:choose>
   </article>
</div>

	</aside>
	<br><br><br>
</div> 


</sf:form>
</body>

</html>