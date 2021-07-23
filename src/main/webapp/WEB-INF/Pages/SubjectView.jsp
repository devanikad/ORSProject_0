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

<div class="card"  align="center">
<article class="card-body">

<c:choose>
<c:when test="${form.id==0}"><h4 class="card-title text-center mb-4 mt-1" style="color: #fff;"><u><s:message code="label.addsubject" /></u></h4></c:when>
<c:otherwise><h4 class="card-title text-center mb-4 mt-1" style="color: #fff;"><u><s:message code="label.updatesubject"></s:message></u></h4>
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
			
    <div align="left" style="color:#fff; " for="validationDefault02"><s:message code="label.coursename"/>
			<span style="color: red">*</span></div>
	<div class="input-group">
    <div class="input-group-prepend">
    <span class="input-group-text"><i class="fa fa-book"></i> </span></div>
		 
  <sf:label path="courseId">
							<c:set var="courseIdErrors">
									</c:set>
					<c:if test="${not empty courseIdErrors}">
						<i class="fa fa-exclamation-circle text-danger"
							onmouseover="showError('tcourseId')"
							onmouseout="hideError('tcourseId')"></i>
					</c:if>
							</sf:label>
				<sf:select path="courseId" class="form-control">
					<sf:option value="0">
						<s:message code="label.selectcourse"></s:message>
					</sf:option>
					<sf:options items="${courseList}" itemValue="id" itemLabel="name"/>
				</sf:select>
			 	
	</div>
	<div align="left"><font style="color: red" ><sf:errors path="courseId"/>
		</font></div>
	
	</div>
	
  
 	
	<div class="form-group">
			
    <div align="left" style="color:#fff; " for="validationDefault02"><s:message code="label.subject" />
				<span style="color: red">*</span></div>
	<div class="input-group">
    <div class="input-group-prepend">
    <span class="input-group-text"><i class="fa fa-copy"></i> </span></div>
		 
   <sf:label path="subjectName">
						<c:set var="firstNameErrors">
						
					</c:set>
					<c:if test="${not empty firstNameErrors}">
						<i class="fa fa-exclamation-circle text-danger"
							onmouseover="showError('tsubjectName')"
							onmouseout="hideError('tsubjectName')"></i>
					</c:if>
							</sf:label>
				<sf:input path="subjectName" class="form-control"
					placeholder="${enterName}" />
				
				</div>
	<div align="left"><font style="color: red" ><sf:errors path="subjectName" /></font></div>
	
	</div>
	
	<div class="form-group">
			
    <div align="left" style="color:#fff; " for="validationDefault02"><s:message code="label.description" />
			<span style="color: red">*</span></div>
	<div class="input-group">
    <div class="input-group-prepend">
    <span class="input-group-text"><i class='fas fa-qrcode'></i></span></div>
		 
   <sf:label path="description">
							<c:set var="descriptionErrors">
						
					</c:set>
					<c:if test="${not empty descriptionErrors}">
						<i class="fa fa-exclamation-circle text-danger"
							onmouseover="showError('tdescription')"
							onmouseout="hideError('tdescription')"></i>
					</c:if>
						</sf:label>
				<sf:textarea path="description" class="form-control"
					placeholder="${enterdescription}"/>
			</div>
	<div align="left"><font style="color: red" ><sf:errors path="description" /></font></div>
	
	</div>
	
	
	 <c:choose>
              		<c:when test="${form.id==0}"> 
				
	 <button type="submit" name="operation" style="float: left;width: 70px; margin-left: 50px;"  value="save"  class="btn btn-info btn-block button2 msgBtn" ><s:message code="label.save"/></button>
		 
	
	<button type="submit" name="operation" style="width: 70px;margin-left: 80px;" value="reset"  class="btn btn-warning btn-block button2" ><s:message code="label.reset"/></button>
	   
	   </c:when>
						<c:otherwise>
					<button type="submit" name="operation" style="float: left;width: 70px; margin-left: 50px;"  value="save"  class="btn btn-info btn-block button2 msgBtn" ><s:message code="label.update"/></button>
		 
	
	<button type="submit" name="operation" style="width: 70px;margin-left: 80px;" value="Cancel"  class="btn btn-warning btn-block button2" ><s:message code="label.cancel"/></button>
	</c:otherwise>
				</c:choose>
	
	
	   
	   </article>
</div>

	</aside>
	
</div> 



</sf:form>
</body>

</html>