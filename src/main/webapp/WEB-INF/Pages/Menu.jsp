<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%> --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ page isELIgnored="false"%>
 <%@ page language="java" contentType="text/html ; charset=UTF-8" pageEncoding="UTF-8"%> 

<html>
<head>
<script defer src="https://use.fontawesome.com/releases/v5.0.13/js/all.js" integrity="sha384-xymdQtn1n3lH2wcu0qhcdaOpQwyoarkgLVxC/wZ5q7h9gHtxICrpcaSUfygqZGOe" crossorigin="anonymous"></script>

<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script type="text/javascript">
$(document).ready(function(){
    $('#select_all').on('click',function(){
        if(this.checked){
            $('.checkbox').each(function(){
                this.checked = true;
            });
        }else{
             $('.checkbox').each(function(){
                this.checked = false;
            });
        }
    });
    
    $('.checkbox').on('click',function()
    {
        if($('.checkbox:checked').length == $('.checkbox').length){
            $('#select_all').prop('checked',true);
        }else{
            $('#select_all').prop('checked',false);
        }
    });
});
</script>

	

<style>
body {
 font-family: "Lato", sans-serif;
}

.sidebar {
  height: 85%;
  width: 10px;
  position: fixed;
  z-index: 1;
  top: 100px;
  left: 0;
 /*  background-color:#F8F8FF ;  */
  background-color:#fff ;
  overflow-x: hidden;
  transition: 0.5s;
  padding-top: 15px;
  
}

.sidebar a {
  padding: 5px 8px 8px 32px;
  text-decoration: none;
  font-size: 25px;
  /* color: #818181; */
  color: #fff;
  display: block;
  transition: 0.3s;
}

.sidebar a:hover {
  color: #21b60b;
}

.sidebar .closebtn {
  position: absolute;
  top: 0;
  right: 45px;
  font-size: 25px;
  margin-left: 0px;
}

.openbtn {
  font-size: 15px;
  cursor: pointer;
  background-color: #4B0082;
  color: white;
  padding: 10px 15px;
  border: none;
  margin-top: -87px;
}

.openbtn:hover {
  background-color: #444;
}

#main {
  transition: margin-left .5s;
  padding: 16px;
}

/* On smaller screens, where height is less than 450px, change the style of the sidenav (less padding and a smaller font size) */
@media screen and (max-height: 450px) {
  .sidebar {padding-top: 15px;}
  .sidebar a {font-size: 18px;}
}
</style>
</head>
<body >
<c:if test="${not empty sessionScope.user}">
<div id="mySidebar" class="sidebar">


 <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">
<i class="fa fa-times" aria-hidden="true"></i>
</a>
  <span style="color:#fff;"><br></span>
  <img src='<c:url value="/resources/image/sun.jpg"></c:url>'  width="140px" height="40px">
  <hr color="white">
  <a href="<c:url value="/ctl/User/UserListCtl"/>"><i class="fa fa-users" style="color:#fff;"></i> <span style="color:#fff;"><u><s:message code="label.userlist" /></u></span></a>
  <a href="<c:url value="/ctl/Role/RoleListCtl"/>"><i class="fa fa-users" style="color:C71585;"></i> <span style="color:#fff;"><u><s:message code="label.rolelist" /></u></span></a>
  <a href="<c:url value="/ctl/Marksheet/MarksheetListCtl"/>"><i class="fa fa-server" style="color:C71585;"></i> <span style="color:#fff;"><u><s:message code="label.marksheetlist"/></u></span></a>
  <a href="<c:url value="/ctl/College/CollegeListCtl"/>"><i class="fa fa-server" style="color:C71585;"></i> <span style="color:#fff;"><u><s:message code="label.collegelist" /></u></span></a>
  <a href="<c:url value="/ctl/Course/CourseListCtl"/>"><i class="fa fa-server" style="color:C71585;"></i> <span style="color:#fff;"><u><s:message code="label.courselist" /></u></span></a>
  <a href="<c:url value="/ctl/Subject/SubjectListCtl"/>"><i  class="fa fa-server" style="color:C71585;"></i> <span style="color:#fff;"><u><s:message code="label.subjectlist" /></u></span></a>
  <a href="<c:url value="/ctl/Faculty/FacultyListCtl"/>"><i class="fa fa-users" style="color:C71585;"></i> <span style="color:#fff;"><u><s:message code="label.facultylist" /></u></span></a>
  <a href="<c:url value="/ctl/Student/StudentListCtl"/>"><i class="fa fa-users" style="color:C71585;"></i> <span style="color:#fff;"><u><s:message code="label.studentlist" /></u></span></a>
  <a href="<c:url value="/ctl/TimeTable/TimeTableListCtl"/>"><i  class="fa fa-server" style="color:C71585;"></i> <span style="color:#fff;"><u><s:message code="label.timetablelist" /></u></span></a>
</div>


<div id="main">
  <button class="openbtn" onclick="openNav()" style="margin-top:60px;" ><i class="fa fa-list"></i><s:message code="label.menu" /></button>  

</div>


<script>
function openNav() {
  document.getElementById("mySidebar").style.width = "230px";
  document.getElementById("main").style.marginLeft = "250px";
  openbtn="hide"
}

function closeNav() {
  document.getElementById("mySidebar").style.width = "0";
  document.getElementById("main").style.marginLeft= "0";
}
</script>
  </c:if>

</body>
</html>