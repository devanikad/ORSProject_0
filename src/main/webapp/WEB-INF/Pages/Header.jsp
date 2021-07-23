 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html PUBLIC >
<%@page import="in.co.sunrays.proj0.dto.*" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ page isELIgnored="false"%>
<html>
<head>
<style type="text/css">
.dropdown-menu{

}
</style>
<!-- Required meta tags -->
 
<meta charset="utf-8">
 
<meta name="viewport" content="width=device-width, initial-scale=1.0">
 

  <script src="https://code.jquery.com/jquery-2.1.3.min.js"></script>
 
<!-- Bootstrap CSS -->
 
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">
 
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js" integrity="sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k" crossorigin="anonymous"></script>
 

<!--fontawesome-->
 
<script defer src="https://use.fontawesome.com/releases/v5.0.13/js/all.js" integrity="sha384-xymdQtn1n3lH2wcu0qhcdaOpQwyoarkgLVxC/wZ5q7h9gHtxICrpcaSUfygqZGOe" crossorigin="anonymous"></script>
 
<!--This is used for search icon. Instead putting icon manually it is loaded from fontawesome-->
 
 
 
 

 
</head>
<body>
 
<!-- navbar -->
 
<nav class="navbar fixed-top navbar-expand-sm navbar-light bg-light">
   <div class="container-fluid">
    <img src='<c:url value="../resources/img/back14.png"></c:url>'  width="80px" height="30px">
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbar-collapse"><span class="navbar-toggler-icon" style="color: #21b60b;"></span>
    </button> 
    <div class="collapse navbar-collapse" id="navbar-collapse">
    
     <a class="text-dark bg-warning circle p-1 m-0" href='<c:url value="?lang=en"></c:url>'><strong>English</strong></a>
     	<a class="text-dark bg-success circle p-1 m-0" href='<c:url value="?lang=hi"></c:url>'><strong>हिन्दी</strong></a>
		<a class="nav-link text-light font-weight-bold px-3" href="<c:url value="/Welcome"></c:url>"><i class="fas fa-home" style="color:#0f6810;"></i></a>

        <ul class="nav navbar-nav  text-nowrap">
            
      <c:if test="${not empty sessionScope.user}">  
      <li class="nav-item">
     <a class="nav-link " style="font-size:15px;"  href="<c:url value="/ctl/User/AddUser"/>"><i class="fas fa-user" style="color:#0f6810;"></i> <span style="color:#8A2BE2;"><s:message code="label.adduser" /></span></a>

     </li>
     
     <li class="nav-item"> 
     <a class="nav-link " style="font-size:15px;" href="<c:url value="/ctl/Student/AddStudent"/>"><i class="fa fa-user-circle" style="color:#0f6810;" ></i> <span style="color:#8A2BE2;"><s:message code="label.addstudent" /> </span></a>

     </li>
            
           
      <li class="nav-item"> 
      <a class="nav-link " style="font-size:15px;" href="<c:url value="/ctl/College/AddCollege"/>"><i class="fa fa-university" style="color:#0f6810;"></i> <span style="color:#8A2BE2;"><s:message code="label.addcollege" /></span></a>
      </li>
            
      <li class="nav-item"> 
      <a class="nav-link " style="font-size:15px;" href="<c:url value="/ctl/Faculty/AddFaculty"/>"><i class='fas fa-chalkboard-teacher' style="color:#0f6810;"></i> <span style="color:#8A2BE2;"><s:message code="label.addfaculty" /></span></a>
       </li>
            
      <li class="nav-item"> 
      <a class="nav-link " style="font-size:15px;" href="<c:url value="/ctl/Subject/AddSubject"/>"><i  class="fa fa-copy" style="color:#0f6810;"></i> <span style="color:#8A2BE2;"><s:message code="label.addsubject" /></span></a>
      </li>
            
     <li class="nav-item"> 
     <a class="nav-link "style="font-size:15px;" href="<c:url value="/ctl/Role/AddRole"/>"><i  class="fa fa-male" style="color:#0f6810;"></i><span style="color:#8A2BE2;"><s:message code="label.addrole" /></span></a>
      </li>
            
     <li class="nav-item">
     <a class="nav-link" style="font-size:15px;" href="<c:url value="/ctl/Course/AddCourse"/>"><i  class="fa fa-book" style="color:#0f6810;"></i> <span style="color:#8A2BE2;"><s:message code="label.addcourse" /></span></a>
     </li>
           
     <li class="nav-item"> 
     <a class="nav-link "style="font-size:15px;"  href="<c:url value="/ctl/TimeTable/AddTimeTable"/>"><i  class="fa fa-server" style="color:#0f6810;"></i> <span style="color:#8A2BE2;"><s:message code="label.addtimetable" /></span></a>
     </li>
     
    
       <li class="nav-item dropdown text-nowrap">
                <a class="nav-link dropdown-toggle" data-toggle="dropdown" href="" role="button" aria-haspopup="true" aria-expanded="false">
                <span><i  class="fa fa-address-book" style="color: #0f6810; font-size: 15px;" ></i></span><span style="color:8A2BE2;font-size:15px; "><s:message code="label.marksheet"/></span></a>
                
                <div class="dropdown-menu dropdown-menu-right">
                   
                    <a class="dropdown-item" href="<c:url value="/ctl/Marksheet/AddMarksheet"/>"><i class="fa fa-arrow-circle-right" aria-hidden="true"></i>
                    <span style="color:#8A2BE2;"><s:message code="label.addmarksheet" /></span></a>
                   
                    <a class="dropdown-item" href="<c:url value="/ctl/Marksheet/GetMarksheet"/>"><i class="fa fa-arrow-circle-right" aria-hidden="true"></i>
						<span style="color:#8A2BE2;"><s:message code="label.getmarksheet" /></span></a>
                    
                    <a class="dropdown-item" href="<c:url value="/ctl/Marksheet/MeritList"/>"><i class='fa fa-user-circle' style="color:#0f6810;"></i><span style="color:#3fcc41;">
                    <span style="color:#8A2BE2;"><s:message code="label.marksheetmeritlist" /></span></span></a>
                   
                   

                </div>
            </li> 

     
     </c:if>
     
            <li class="nav-item dropdown  text-nowrap">
                <a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">
                <span><i  class="fa fa-user-circle" style="color: orange;font-size:15px;" ></i></span><span style="color:blue;font-size:15px;">
                
                <c:if test="${not empty sessionScope.user}">
					<c:set var="name" value="${sessionScope.user.firstName}" />
    				<c:set var="role" value='${sessionScope["role"]}' />
    				<c:out value="${name}(${role})"></c:out> 
    				</c:if>
    				<c:if test="${empty sessionScope.user}">
    					<s:message code="label.hiGuest"></s:message>
    				</c:if>
                    </span></a>
                
                <div class="dropdown-menu dropdown-menu-right ">
                
                <c:if test="${not empty sessionScope.user}">
                    
                  <a class="dropdown-item" href="<c:url value="/ctl/User/MyProfileCtl" />"><i class='fa fa-user-circle' style="color:#0f6810;"></i><span style="color:#3fcc41;">
                  <span style="color:#3fcc41;"><s:message code="label.myprofile" /></span></span></a>
                   
                   <a class="dropdown-item" href="<c:url value="/ctl/User/ChangePasswordCtl"/>"><i class="fa fa-random" aria-hidden="true" style="color:#0f6810;"></i>

          <span style="color:#3fcc41;"><span style="color:#3fcc41;"><s:message code="label.changepassword" /></span> </span></a>
          
          <a class="dropdown-item" href="<c:url value="resources/doc/index.html"/>"><i class='fas fa-caret-square-right' style="color:#0f6810;" ></i>
          <span style="color:#3fcc41;"><span style="color:#3fcc41;"><s:message code="label.javadoc" /></span></span></a>
          
           <a class="dropdown-item" href="<c:url value="/Login"/>"><i class='fas fa-caret-square-left' style="color:#0f6810;" ></i>
           <span style="color:#3fcc41;"><span style="color:#3fcc41;"><s:message code="label.logout" /></span></span></a>
            
            </c:if>
            
            <c:if test="${empty sessionScope.user}">
                    
            <a class="dropdown-item" href="<c:url value="/Login"></c:url>"><i class="fa fa-arrow-circle-right" aria-hidden="true"></i>
            <span style="color:#3fcc41;"><s:message code="label.login" /></span></a>
                   
            <a class="dropdown-item" href="<c:url value="/Registration"></c:url>"><i class="fa fa-arrow-circle-right" aria-hidden="true"></i>
	        <span style="color:#3fcc41;"><s:message code="label.signup" /></span></a>
                    
                    </c:if>
                  

                </div>
            </li>
        </ul>
    </div>
    
  </div>  
</nav> 
</body>
</html>