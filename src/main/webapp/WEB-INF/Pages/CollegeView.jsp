<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@page isELIgnored="false"%>

<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8>
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
<sf:form  modelAttribute="form" method="post">
<div class="container-fluid" align="center"  >

<aside class="col-sm-4">

<div class="card"  align="center" >
<article class="card-body">


<c:choose>
<c:when test="${form.id==0}"><h4 class="card-title text-center mb-4 mt-1" style="color: #fff;"><u><s:message code="label.addcollege" /></u></h4></c:when>
<c:otherwise>
<h4 class="card-title text-center mb-4 mt-1" style="color: #fff;"><u><s:message code="label.updatecollege"></s:message></u></h4>
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
			
    <div align="left" style="color:#fff; " for="validationDefault02"><s:message code="label.name" /><span style="color: red">*</span></div>
	<div class="input-group">
    <div class="input-group-prepend">
    <span class="input-group-text"><i class="fa fa-university"></i> </span></div>
		 
   <!--  <input type="text" name="name" class="form-control" placeholder="college" value="">
	 -->
	 
	 <sf:label path="name">
					
					<c:set var="firstNameErrors">
							</c:set>
					<%-- <c:if test="${not empty firstNameErrors}">
						<i class="fa fa-exclamation-circle text-danger"
							onmouseover="showError('tname')"
							onmouseout="hideError('tname')"></i>
			   </c:if> --%>
			    </sf:label>
				<sf:input path="name" class="form-control"
					placeholder="${enterName}" />
	                                                </div>
	<div align="left"><font style="color: red" ><sf:errors path="name" />
				</font></div>
	
	</div>
	
	<div class="form-group">
			
    <div align="left" style="color:#fff; " for="validationDefault02"><s:message code="label.address" /><span style="color: red">*</span></div>
	<div class="input-group">
    <div class="input-group-prepend">
    <span class="input-group-text"><i class='fas fa-crosshairs'></i></span></div>
		 
   
	<sf:label path="address">
					
					<c:set var="addressErrors">
									</c:set>
					<%-- <c:if test="${not empty addressErrors}">
						<i class="fa fa-exclamation-circle text-danger"
							onmouseover="showError('taddress')"
							onmouseout="hideError('taddress')"></i>
					</c:if> --%>
						</sf:label>
				<sf:textarea path="address" class="form-control"
					placeholder="${enterAddress}"/>
					
			
		
	</div>
	<div align="left"><font style="color: red" ><sf:errors path="address" />
		</font></div>
	
	</div>
	
	<div class="form-group">
			
    <div align="left" style="color:#fff; " for="validationDefault02"><s:message code="label.state" />
				<span style="color: red">*</span></div>
	<div class="input-group">
    <div class="input-group-prepend">
    <span class="input-group-text"> <i class='fas fa-fighter-jet'></i></span></div>
 
 <sf:label path="state">
						<c:set var="stateErrors">
								</c:set>
					<%-- <c:if test="${not empty stateErrors}">
						<i class="fa fa-exclamation-circle text-danger"
							onmouseover="showError('tstate')"
							onmouseout="hideError('tstate')"></i>
					</c:if> --%>
									</sf:label>
				<sf:input path="state" class="form-control"
					placeholder="${enterState}"/>
									</div>
	<div align="left"><font style="color: red" ><sf:errors path="state" />
			</font></div>
	</div>
	
	<div class="form-group">
			
    <div align="left" style="color:#fff; " for="validationDefault02"><s:message code="label.city" />
			<span style="color: red">*</span></div>
	<div class="input-group">
    <div class="input-group-prepend">
    <span class="input-group-text"> <i class='fas fa-crosshairs'></i></span></div>
		 

 
 <sf:label path="city">
							<c:set var="cityErrors">
							</c:set>
					<%-- <c:if test="${not empty cityErrors}">
						<i class="fa fa-exclamation-circle text-danger"
							onmouseover="showError('tcity')"
							onmouseout="hideError('tcity')"></i>
					</c:if>
					 --%>		</sf:label>
				<sf:input path="city" class="form-control"
					placeholder="${enterCity}"/>
				</div>
	<div align="left"><font style="color: red" ><sf:errors path="city" />
				</font></div>
	
	</div>
	
	
	
	
	<div class="form-group">
	
	<div align="left" style="color:#fff;  for="validationDefault02"><s:message code="label.phoneNo" />
				<span style="color: red">*</span></div>
	<div class="input-group">
	<div class="input-group-prepend">
    <span class="input-group-text"> <i class='fas fa-mobile-alt'></i> </span></div>
	    
	<!--  <input type="text" name="phoneNo" class="form-control" placeholder="phone number" value="">
	 --> 
	 <sf:label path="phoneNo">
						<c:set var="phoneNoErrors">
									</c:set>
					<%-- <c:if test="${not empty phoneNoErrors}">
						<i class="fa fa-exclamation-circle text-danger"
							onmouseover="showError('tphoneNo')"
							onmouseout="hideError('tphoneNo')"></i>
					</c:if>
					 --%>		</sf:label>
				<sf:input path="phoneNo" class="form-control"
					placeholder="${enterPhoneNo}"/>
	</div>
	
	<div align="left"> <font style="color: red">	<sf:errors path="phoneNo" />
	</font></div>
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
<br><br><br>
</body>
</html>