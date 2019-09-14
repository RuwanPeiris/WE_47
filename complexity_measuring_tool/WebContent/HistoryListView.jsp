<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

</head>
<body>
	<jsp:include page="menuBar.jsp"></jsp:include>
	<div class="table-responsive">
	<c:set var="count" value="0" scope="page" />
	<table class="table table-dark table-striped table-bordered table-hover">
		<thead>
			<h2>Previous Complexities</h2>
			</h3>
			<tr>
				<th scope="col">#</th>
				<th scope="col">File Name</th>
				<th scope="col">Date Time</th>
				<th scope="col">CS</th>
				<th scope="col">CNS</th>
				<th scope="col">CTS</th>
				<th scope="col">CI</th>
				<th scope="col">CR</th>
				<th scope="col">TW</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${oldFileList}" var="line">
				<tr>
					<c:set var="count" value="${count + 1}" scope="page" />
					<th scope="row">${count}</th>
					<td><c:out value="${line.fileName}" /></td>
					<td><c:out value="${line.date}" /></td>
					<td><c:out value="${line.cs}" /></td>
					<td><c:out value="${line.cns}" /></td>
					<td><c:out value="${line.cts}" /></td>
					<td><c:out value="${line.ci}" /></td>
					<td><c:out value="${line.cr}" /></td>
					<td><c:out value="${line.tw}" /></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	</div>
</body>
</html>