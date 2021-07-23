
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>

<html>
<head>
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script type="text/javascript" src="<c:url value="/resources/js/Checkbox11.js"></c:url>"></script>
<meta charset="utf-8">

<meta name="viewport" content="width=device-width, initial-scale=1.0">

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.7.0/css/all.css"
	integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ"
	crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
	integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
	integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
	crossorigin="anonymous"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
	integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
	crossorigin="anonymous"></script>
	<style type="text/css">
	.navbar-collapse.collapse.show {
  max-height: 50%;
  overflow-y: auto;
}
.btn-group{


 position: fixed;
  z-index: 1;
  
}
	</style>
	
</head>

<body>

	<!-- navbar -->

	<!-- <nav class="navbar navbar-expand-sm navbar-light fixed-top"
		style="background-color: rgb(227, 242, 253,0.8);">
	 -->	
	 <nav class="navbar navbar-expand-sm navbar-light fixed-top"
		style="background-color:#ffffffa1;height:60px;">
		
	 
	 <a href=""> <img
			src='<c:url value="/resources/img/logo.jpg"></c:url>' width="80px"
			height="30px"></a>&nbsp;
		
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarTogglerDemo03"
			aria-controls="navbarTogglerDemo03" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarTogglerDemo03">
			
			<ul class="navbar-nav mr-auto mt-2 mt-lg-0">
				<li class="nav-item active"><a class="nav-link text-light "
					style="font-size: 20px;" href="<c:url value="/Welcome"></c:url>"><i
						class="fas fa-home" style="color: #0f6810;"></i></a></li>
				<c:if test="${not empty sessionScope.user}">
					<li class="nav-item text-nowrap"><a
						class="nav-link text-light " style="font-size: 14px;"
						href="<c:url value="/ctl/User/AddUser"/>"><i
							class="fas fa-user" style="color: #0f6810;"></i> <span
							style="color: #8A2BE2;"><b><s:message code="label.adduser" /></b></span></a>

					</li>

					<li class="nav-item text-nowrap"><a
						class="nav-link text-light " style="font-size: 14px;"
						href="<c:url value="/ctl/Student/AddStudent"/>"><i
							class="fa fa-user-circle" style="color: #0f6810;"></i> <span
							style="color: #8A2BE2;"><b><s:message code="label.addstudent" /></b>
						</span></a></li>


					<li class="nav-item text-nowrap"><a
						class="nav-link text-light " style="font-size: 14px	;"
						href="<c:url value="/ctl/College/AddCollege"/>"><i
							class="fa fa-university" style="color: #0f6810;"></i> <span
							style="color: #8A2BE2;"><b><s:message code="label.addcollege" /></b></span></a>
					</li>

					<li class="nav-item text-nowrap"><a
						class="nav-link text-light " style="font-size: 14px;"
						href="<c:url value="/ctl/Faculty/AddFaculty"/>"><i
							class='fas fa-chalkboard-teacher' style="color: #0f6810;"></i> <span
							style="color: #8A2BE2;"><b><s:message code="label.addfaculty" /></b></span></a>
					</li>

					<li class="nav-item text-nowrap"><a
						class="nav-link text-light " style="font-size: 14px;"
						href="<c:url value="/ctl/Subject/AddSubject"/>"><i
							class="fa fa-copy" style="color: #0f6810;"></i> <span
							style="color: #8A2BE2;"><b><s:message code="label.addsubject" /></b></span></a>
					</li>

					<li class="nav-item text-nowrap"><a
						class="nav-link text-light " style="font-size: 14px;"
						href="<c:url value="/ctl/Role/AddRole"/>"><i
							class="fa fa-male" style="color: #0f6810;"></i>&nbsp;<span
							style="color: #8A2BE2;"><b><s:message code="label.addrole" /></b></span></a>
					</li>

					<li class="nav-item text-nowrap"><a
						class="nav-link text-light " style="font-size: 14px;"
						href="<c:url value="/ctl/Course/AddCourse"/>"><i
							class="fa fa-book" style="color: #0f6810;"></i> <span
							style="color: #8A2BE2;"><b><s:message code="label.addcourse" /></b></span></a>
					</li>

					<li class="nav-item text-nowrap"><a
						class="nav-link text-light " style="font-size: 14px;"
						href="<c:url value="/ctl/TimeTable/AddTimeTable"/>"><i
							class="fa fa-server" style="color: #0f6810;"></i> <span
							style="color: #8A2BE2;"><b><s:message
									code="label.addtimetable" /></b></span></a></li>


					<li class="nav-item dropdown text-nowrap"><a
						class="nav-link dropdown-toggle" data-toggle="dropdown" href=""
						role="button" aria-haspopup="true" aria-expanded="false"> <span><i
								class="fa fa-address-book"
								style="color: #0f6810; font-size: 14px;"></i></span>&nbsp;<span
							style="color: 8A2BE2; font-size: 14px;"><b><s:message
									code="label.marksheet" /></b></span></a>

						<div class="dropdown-menu dropdown-menu-right" style="background-color: #cceeff;">

							<a class="dropdown-item"
								href="<c:url value="/ctl/Marksheet/AddMarksheet"/>"><i
								class="fa fa-arrow-circle-right" aria-hidden="true"></i> <span
								style="color: #8A2BE2;"><b><s:message
										code="label.addmarksheet" /></b></span></a> <a class="dropdown-item"
								href="<c:url value="/ctl/Marksheet/GetMarksheet"/>"><i
								class="fa fa-arrow-circle-right" aria-hidden="true"></i> <span
								style="color: #8A2BE2;"><b><s:message
										code="label.getmarksheet" /></b></span></a> <a class="dropdown-item"
								href="<c:url value="/ctl/Marksheet/MeritList"/>"><i
								class='fa fa-user-circle' style="color: #0f6810;"></i><span
								style="color: #3fcc41;"> <span style="color: #8A2BE2;"><b><s:message
											code="label.marksheetmeritlist" /></b></span></span></a>



						</div></li>


				</c:if>

				<li class="nav-item dropdown"></li>
			</ul>
			
			
			
		<div class="navbar nav-item dropdown text-nowrap dropdown-menu-left">

			<a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#" style="font-size: 15px;"
				role="button" aria-haspopup="true" aria-expanded="false"> <span><i
					class="fa fa-user-circle" style="color: orange;"></i></span><span
				style="color: blue;"> <c:if
						test="${not empty sessionScope.user}">
						<c:set var="name" value="${sessionScope.user.firstName}" />
						<c:set var="role" value='${sessionScope.user.roleName}' />
						<b><c:out value="${name}(${role})"></c:out></b>
					</c:if> <c:if test="${empty sessionScope.user}">
						<b><s:message code="label.hiGuest"></s:message></b>
					</c:if>
			</span></a>

			<div class="dropdown-menu dropdown-menu-right" style="font-size: 15px;background-color: e6f7ff">

				<c:if test="${not empty sessionScope.user}">

					<a class="dropdown-item"
						href="<c:url value="/ctl/User/MyProfileCtl" />"><i
						class='fa fa-user-circle' style="color: #0f6810;"></i><span
						style="color: #3fcc41;"> <span style="color: #3fcc41;"><b><s:message
									code="label.myprofile" /></b></span></span></a>

					<a class="dropdown-item"
						href="<c:url value="/ctl/User/ChangePasswordCtl"/>"><i
						class="fa fa-random" aria-hidden="true" style="color: #0f6810;"></i>

						<span style="color: #3fcc41;"><span style="color: #3fcc41;"><b><s:message
									code="label.changepassword" /></b></span> </span></a>

					<a class="dropdown-item"
						 target="blank" href="<c:url value="resources/javadoc/index.html"/>"><i
						class='fas fa-caret-square-right' style="color: #0f6810;"></i> <span
						style="color: #3fcc41;"><span style="color: #3fcc41;"><b><s:message
									code="label.javadoc" /></b></span></span></a>
                           
                            <%-- <c:url var="logoutUrl" value="/Login">
                          <c:param name="signout" value="logout"></c:param>
                           </c:url> 
<c:url  value="${logoutUrl}"/> --%>
					<a class="dropdown-item" href="<c:url value="/Login">
                          <c:param name="signout" value="logout"></c:param>
                           </c:url>"><i
						class='fas fa-caret-square-left' style="color: #0f6810;"></i> <span
						style="color: #3fcc41;"><span style="color: #3fcc41;"><b><s:message
									code="label.logout" /></b></span></span></a>

				</c:if>

				<c:if test="${empty sessionScope.user}">

					<a class="dropdown-item" href="<c:url value="/Login"></c:url>"><i
						class="fa fa-arrow-circle-right" aria-hidden="true"></i> <span
						style="color: #3fcc41;"><b><s:message code="label.login" /></b></span></a>

					<a class="dropdown-item"
						href="<c:url value="/Registration"></c:url>"><i
						class="fa fa-arrow-circle-right" aria-hidden="true"></i> <span
						style="color: #3fcc41;"><b><s:message code="label.signup" /></b></span></a>

				</c:if>


			</div>

		</div>
			
		</div>


	</nav>
	<br><br><br>
&nbsp;&nbsp;&nbsp;&nbsp;

               <div class="btn-group" role="group" style="font-size: 10px;">
				<a class="btn btn-outline-warning" style="font-size: 10px;color: White;"
					href='<c:url value="?lang=en"></c:url>'><strong>English</strong></a>
				<a class="btn btn-outline-warning" style="font-size: 10px;color: White;"
					href='<c:url value="?lang=hi"></c:url>'><strong>हिन्दी</strong></a>
			</div>
			
</body>

</html>
