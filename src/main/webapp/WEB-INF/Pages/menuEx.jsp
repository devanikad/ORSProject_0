 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ page isELIgnored="false"%>
 <%@ page language="java" contentType="text/html ; charset=UTF-8" pageEncoding="UTF-8"%> 
<!DOCTYPE html>
<html>
<head>
<script defer src="https://use.fontawesome.com/releases/v5.0.13/js/all.js" integrity="sha384-xymdQtn1n3lH2wcu0qhcdaOpQwyoarkgLVxC/wZ5q7h9gHtxICrpcaSUfygqZGOe" crossorigin="anonymous"></script>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style type="text/css">
body {
  font-family: "Lato", sans-serif;
  background-color: "#fff"
}
.sidenav {
  height: 79%;
  width: 0;
  position: fixed;
  z-index: 1;
  top: 110px;
  left: 0;
  /* background-color:#e3f2fd; */
  background-image: url("/ORSProject_0/resources/img/astronomy-2.jpg");
  overflow:hidden;
  transition: 0.5s;
  padding-top: 50px;
}
.sidenav a {
  padding: 8px 8px 8px 20px;
  text-decoration: none;
  font-size: 25px;
  color: #818181;
  display: block;
  transition: 0s;
}
.sidenav a:hover {
  color: red;
}
.sidenav .closebtn {
  position: absolute;
  top: 10px;;
  right: 25px;
  font-size: 36px;
  margin-left: 100px;
  overflow:hidden;
}
@media screen and (max-height: 450px) {
  .sidenav {padding-top: 20px;}
  .sidenav a {font-size: 5px;}
}
#menuB{
padding-right:5px;
 position: fixed;
  z-index: 1;
 font-size:12px;
 cursor:pointer;
  color:black; 

}
</style>
</head>
<body>
<c:if test="${not empty sessionScope.user}">
<div id="mySidenav" class="sidenav">
   <a href="javascript:void(0)" style="padding-bottom: 10px;color: orange;"  class="closebtn " onclick="closeNav()">&times;</a>
   <a><img src='<c:url value="/resources/img/logo.jpg"></c:url>' width="80px" height="20px" style="background-color:#f8f9fa80;"></a>
  <a  style="font-size: 15px;"  href="<c:url value="/ctl/User/UserListCtl"/>"><i class="fa fa-users " style="color:#ffeb3bfc"></i> <span style="color:#ff9800f5"><s:message code="label.userlist" /></span></a>
  <a  style="font-size: 15px;" href="<c:url value="/ctl/Role/RoleListCtl"/>"><i class="fa fa-users" style="color:#ffeb3bfc;"></i> <span style="color:#ff9800f5;"><s:message code="label.rolelist" /></span></a>
  <a  style="font-size: 13px;" href="<c:url value="/ctl/Marksheet/MarksheetListCtl"/>"><i class="fa fa-server" style="color:#ffeb3bfc;"></i> <span style="color:#ff9800f5;"><s:message code="label.marksheetlist"/></span></a>
  <a style="font-size: 15px;" href="<c:url value="/ctl/College/CollegeListCtl"/>"><i class="fa fa-server" style="color:#ffeb3bfc;"></i> <span style="color:#ff9800f5;"><s:message code="label.collegelist" /></span></a>
  <a  style="font-size: 15px;" href="<c:url value="/ctl/Course/CourseListCtl"/>"><i class="fa fa-server" style="color:#ffeb3bfc;"></i> <span style="color:#ff9800f5;"><s:message code="label.courselist" /></span></a>
  <a  style="font-size: 15px;" href="<c:url value="/ctl/Subject/SubjectListCtl"/>"><i  class="fa fa-server" style="color:#ffeb3bfc;"></i> <span style="color:#ff9800f5;"><s:message code="label.subjectlist" /></span></a>
  <a  style="font-size: 15px;" href="<c:url value="/ctl/Faculty/FacultyListCtl"/>"><i class="fa fa-users" style="color:#ffeb3bfc;"></i> <span style="color:#ff9800f5;"><s:message code="label.facultylist" /></span></a>
  <a  style="font-size: 15px;" href="<c:url value="/ctl/Student/StudentListCtl"/>"><i class="fa fa-users" style="color:#ffeb3bfc;"></i> <span style="color:#ff9800f5;"><s:message code="label.studentlist" /></span></a>
  <a  style="font-size: 13px;" href="<c:url value="/ctl/TimeTable/TimeTableListCtl"/>"><i  class="fa fa-server" style="color:#ffeb3bfc;"></i> <span style="color:#ff9800f5;"><s:message code="label.timetablelist" /></span></a>
  <br><br><br><br><br><br>
</div>
<span id="menuB"   class='btn btn-outline-warning' style="font-color: White;" onclick="openNav()"><i  class="fa fa-list" style="color:white;"></i>&nbsp;<span style="color:#fff;"><b><s:message code="label.menu" /></span></b></span>
<script>
 function openNav() {
  document.getElementById("mySidenav").style.width = "135px";
  document.getElementById("menuB").style.visibility ="hidden";
}
function closeNav() {
  document.getElementById("mySidenav").style.width = "0";
  document.getElementById("menuB").style.visibility ="visible";
} 

</script>
 </c:if>
</body>
</html>