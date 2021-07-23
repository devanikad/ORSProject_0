<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.9.0/css/bootstrap-datepicker.css">
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.9.0/js/bootstrap-datepicker.js"></script>
<%-- <script type="text/javascript">
$(function() {
	$("#date").datepicker({
		/*  beforeShowDay:DisableSunday, */
		changeMonth : true,
		changeYear : true,
		yearRange : '2020:2030',
		/* dateFormat : 'dd-mm-yy',
 */	    /*minDate:0 */
	});
});
</script>

 --%>
  <script>
  
<%--  function disableSunday(d){
	  var day = d.getDay();
	  if(day==0)
	  {
	   return [false];
	  }else
	  {
		  return [true];
	  }
  } --%>
  
  $( function() {
	  $( "#date" ).datepicker({
		  changeMonth :true,
		  changeYear :true,
		  yearRange :'0:+3',
		 /*  dateFormat:'dd-mm-yy', */
         dateFormat:'mm/dd/yy',   
		 
// Disable for Sunday
		//beforeShowDay : disableSunday,		  
		daysOfWeekDisabled: [0],
// Disable for back date
		  startDate : new Date()
	  });
  } );
  </script>
 
 
 
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
           			<c:when test="${form.id==0}"><h4 class="card-title text-center mb-4 mt-1" style="color: #fff;"><u><s:message code="label.addtimetable" /></u></h4>
	</c:when>
           			<c:otherwise><h4 class="card-title text-center mb-4 mt-1" style="color: #fff;"><u><s:message code="label.updatetimetable"></s:message></u></h4>
           			</c:otherwise>
           		</c:choose> 


	
	
	<hr>
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
			
    <div align="left" style="color:#fff; " for="validationDefault02">
    <s:message code="label.course"/><span style="color: red">*</span></div>
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
					<sf:option value="0"><s:message code="label.selectcourse"/></sf:option>
					<sf:options items="${courseList}" itemValue="id" itemLabel="name"/>
				</sf:select> 
				
		
	</div>
	<div align="left"><font style="color: red" ><sf:errors path="courseId"/></font></div>
	
	</div>
	
	<div class="form-group">
			
    <div align="left" style="color:#fff; " for="validationDefault02"><s:message code="label.subject"/><span style="color: red">*</span></div>
	<div class="input-group">
    <div class="input-group-prepend">
    <span class="input-group-text"><i class="fa fa-copy"></i> </span></div>
		 
 <sf:label path="subjectId">
					
					<c:set var="subjectIdErrors">
						

					</c:set>
					<c:if test="${not empty subjectIdErrors}">
						<i class="fa fa-exclamation-circle text-danger"
							onmouseover="showError('tsubjectId')"
							onmouseout="hideError('tsubjectId')"></i>
					</c:if>
								</sf:label>
				<sf:select path="subjectId" class="form-control">
					<sf:option value="0"><s:message code="label.selectsubject"/></sf:option>
					<sf:options items="${subjectList}" itemValue="id" itemLabel="name"/>
				</sf:select> 
				
			</div>
	<div align="left"><font style="color: red" ><sf:errors path="subjectId"/></font></div>
	
	</div>
	
	
	<div class="form-group">
			
    <div align="left" style="color:#fff; " for="validationDefault02"><s:message code="label.semester"/>
    <span style="color: red">*</span></div>
	<div class="input-group">
    <div class="input-group-prepend">
    <span class="input-group-text"><i class="fa fa-location-arrow" aria-hidden="true"></i>
</span></div>
<sf:label path="semester">
					
					<c:set var="semesterErrors">
						
					</c:set>
					<c:if test="${not empty semesterErrors}">
						<i class="fa fa-exclamation-circle text-danger"
							onmouseover="showError('tsemester')"
							onmouseout="hideError('tsemester')"></i>
					</c:if>
						</sf:label>
				<sf:select path="semester" class="form-control">
					<sf:option value=""><s:message code="label.selectsemester"/></sf:option>
					<sf:option value="1st" label="I"></sf:option>
					<sf:option value="2nd" label="II"></sf:option>
					<sf:option value="3rd" label="III"></sf:option>
					<sf:option value="4th" label="IV"></sf:option>
					<sf:option value="5th" label="V"></sf:option>
					<sf:option value="6th" label="VI"></sf:option>
					<sf:option value="7th" label="VII"></sf:option>
					<sf:option value="8th" label="VIII"></sf:option>
				</sf:select>
				
				</div>
	<div align="left"><font style="color: red" ><sf:errors path="semester"/></font></div>
	
	</div>
	
	<div class="form-group">
			
    <div align="left" style="color:#fff; " for="validationDefault02"><s:message code="label.examtime"/><span style="color: red">*</span></div>
	<div class="input-group">
    <div class="input-group-prepend">
    <span class="input-group-text"><i class="fa fa-hourglass-start" aria-hidden="true"></i></span></div>
		 
  <sf:label path="examTime">
					
					<c:set var="examTimeErrors">
						
					</c:set>
					<c:if test="${not empty examTimeErrors}">
						<i class="fa fa-exclamation-circle text-danger"
							onmouseover="showError('texamTime')"
							onmouseout="hideError('texamTime')"></i>
					</c:if>
							</sf:label>
				<sf:select path="examTime" class="form-control">
					<sf:option value=""><s:message code="label.selecttime"/></sf:option>
					<sf:option value="09:00 AM to 12:00 AM" label="09:00 AM to 12:00 AM"></sf:option>
					<sf:option value="10:00 AM to 01:00 PM" label="10:00 AM to 01:00 PM"></sf:option>
					<sf:option value="12:00 AM to 03:00 PM" label="12:00 AM to 03:00 PM"></sf:option>
					<sf:option value="01:00 PM to 04:00 PM" label="02:00 PM to 05:00 PM"></sf:option>
				</sf:select> 
				
	</div>
	<div align="left"><font style="color: red" ><sf:errors path="examTime"/></font></div>
	
	</div>
	
	
	
	
	
	<div class="form-group">
			
    <div align="left" style="color:#fff; " for="validationDefault02"><s:message code="label.examdate" /><span style="color: red">*</span></div>
	<div class="input-group">
    <div class="input-group-prepend">
    <span class="input-group-text"><i class='fas fa-calendar-alt'></i></span></div>
	<sf:label path="examDate">
					
					<c:set var="examDateErrors">
						
					</c:set>
					<c:if test="${not empty examDateErrors}">
						<i class="fa fa-exclamation-circle text-danger"
							onmouseover="showError('texamDate')" onmouseout="hideError('texamDate')"></i>
					</c:if>
									</sf:label>
				<sf:input path="examDate" class="form-control" id="date"
					placeholder="${enterDate}" autocomplete="off" />
					
	</div>
	<div align="left"><font style="color: red" ><sf:errors path="examDate" /></font></div>
	
	</div>
	
	<%-- <div class="form-group">
			
    <div align="left" style="color:#8A2BE2; " for="validationDefault02"><s:message code="label.description" /><span style="color: red">*</span></div>
	<div class="input-group">
    <div class="input-group-prepend">
    <span class="input-group-text"><i class='fas fa-calendar-alt'></i></span></div>
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
	 --%>
	
	
	
	<c:choose>
	<c:when test="${form.id==0}">
	 <button type="submit" name="operation" style="float: left;width: 70px; margin-left: 50px;"  value="save"  class="btn btn-info btn-block button2 msgBtn" ><s:message code="label.save" />
	 </button>
		 
	
	<button type="submit" name="operation" style="width: 70px;margin-left: 80px;" value="reset"  class="btn btn-warning btn-block button2" ><s:message code="label.reset" />
	</button>
	</c:when>
	<c:otherwise>
	 <button type="submit" name="operation" style="float: left;width: 70px; margin-left: 50px;"  value="save"  class="btn btn-info btn-block button2 msgBtn" ><s:message code="label.save" />
	 </button>
		 
	
	<button type="submit" name="operation" style="width: 70px;margin-left: 80px;" value="Cancel"  class="btn btn-warning btn-block button2" ><s:message code="label.cancel" />
	</button>
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