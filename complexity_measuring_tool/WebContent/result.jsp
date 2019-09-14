<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
</head>
<body>

	<jsp:include page="menuBar.jsp"></jsp:include>

	<div class="overflow-auto"
		style="height: 75%; float: left; width: 100%; background-color: white;">

		<c:if test="${oldFileNotFound == 'false'}">
			
			<div class="table-responsive">
				<c:set var="count" value="0" scope="page" />
				<c:set var="cp" value="${cp = 0}" scope="page" />
				<table
					class="table table-dark table-striped table-bordered table-hover">
					<thead>
						<h2>${fileName}</h2>
						<h3>${old_datTime}</h3>
						<tr>
							<th scope="col">Line no</th>
							<th scope="col">Program Statements</th>
							<th scope="col">Cs</th>
							<th scope="col">Ctc</th>
							<th scope="col">Cnc</th>
							<th scope="col">Ci</th>
							<th scope="col">TW</th>
							<th scope="col">Cps</th>
							<th scope="col">Cr</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${recordList}" var="line">
							<tr>
								<c:set var="count" value="${count + 1}"  />
								<th scope="row">${count}</th>
								<td><c:out value="${line.value}" /></td>
								<td><c:out value="${line.cs}" /></td>
								<td><c:out value="${line.cts}" /></td>
								<td><c:out value="${line.cns}" /></td>
								<td><c:out value="${line.ci}" /></td>
								<td><c:out value="${line.tw}" /></td>
								<td><c:out value="${line.cps}" /></td>
								<td><c:out value="${line.cr}" /></td>
							</tr>
						</c:forEach>
							<tr>
								<th scope="row"></th>
								<td><c:out value="Cp" /></td>
								<td><c:out value="" /></td>
								<td><c:out value="" /></td>
								<td><c:out value="" /></td>
								<td><c:out value="" /></td>
								<td><c:out value="" /></td>
								<td><c:out value="" /></td>
								<td><c:out value="${cp}" /></td>
							</tr>
					</tbody>
				</table>
			</div>
		</c:if>

		<c:if test="${oldFileNotFound == 'true'}">
			<h2>Sorry, No such file found in previous calculations...</h2>
		</c:if>
	</div>
</body>
</html>