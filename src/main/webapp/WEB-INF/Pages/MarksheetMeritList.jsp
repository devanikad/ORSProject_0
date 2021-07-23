
<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
</style>
</head>
<body>
<center>
<h1 style="color: white;">Top 5 Students</h1>
</center>
<c:set value="${findList}" var="findtotal"></c:set>
<c:set value="${list}" var="total"></c:set>

<div class="row d-flex justify-content-center h-100">
	
	<div class="col-lg-12 col-sm-12 ml-auto mr-auto">
		<div class="card card-table">
			<h3 class="w-100 text-center under-over-line" style="color: white;">
				<s:message code="label.marksheetmeritlist"></s:message>
			</h3>
				<c:set value="1" var="index"></c:set>
				<c:if test="${!empty list}">
				<div class="row p-2 d-flex justify-content-center">
					<div class="col-lg-2">
								<a class="btn btn-info btn-block btn-round w-100" href='<c:url value="/ctl/Jasper"></c:url>'><i class="fa fa-print" aria-hidden="true"></i>Print</a>
					</div>
				</div>
				<div class="row d-flex justify-content-center">
					<div class="col-lg-12 table-responsive">
						<table class="table table-hover table-striped border border-secondary">
							<thead style="background-color: #ff9800a3;">
								<tr>
									<th scope="col" class="text-center" style="color: white;">S.No.</th>
									<th scope="col" class="text-center" style="color: white;"><s:message code="label.name"/></th>
									<th scope="col" class="text-center" style="color: white;"><s:message code="label.rollNo"/></th>
									<th scope="col" class="text-center" style="color: white;"><s:message code="label.physics"/></th>
									<th scope="col" class="text-center" style="color: white;"><s:message code="label.chemistry"/></th>
									<th scope="col" class="text-center" style="color: white;"><s:message code="label.maths"/></th>
									<th scope="col" class="text-center" style="color: white;"><s:message code="label.total"/></th>
									<th scope="col" class="text-center" style="color: white;"><s:message code="label.percentage"/></th>
								</tr>
							</thead>
							<tbody style="background-color: white;">
							<c:forEach items="${list}" var="marksheet" varStatus="ct">
							<c:set var="percentage"><fmt:formatNumber type="number" minFractionDigits="2" maxFractionDigits="2" value="${(marksheet.physics+marksheet.chemistry+marksheet.maths)/3}" /></c:set>
								<tr>								
									<td class="text-center">
										<c:out value="${ct.index+1}" />
										<c:set var="index" value="${ct.index+1}" />
									</td>
									<td class="text-center">${marksheet.name}</td>
									<td class="text-center">${marksheet.rollNo}</td>
									<td class="text-center">${marksheet.physics}</td>
									<td class="text-center">${marksheet.chemistry}</td>
									<td class="text-center">${marksheet.maths}</td>
									<td class="text-center">${marksheet.physics+marksheet.chemistry+marksheet.maths}</td>
									<td class="text-center">${percentage}%</td>
								</tr>
							</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
				</c:if>
		</div>
	</div>
</div>
</body>
</html>