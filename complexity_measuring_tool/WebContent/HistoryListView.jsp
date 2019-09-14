<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
		<table
			class="table table-dark table-striped table-bordered table-hover">
			<thead>
				<h2>Previous Complexities</h2>
				</h3>
				<tr>
					<th scope="col">#</th>
					<th scope="col">File Name</th>
					<th scope="col">Date Time</th>
					<th scope="col">Cs</th>
					<th scope="col">Ctc</th>
					<th scope="col">Cnc</th>
					<th scope="col">Ci</th>
					<th scope="col">TW</th>
					<th scope="col">Cps</th>
					<th scope="col">Cr</th>
					<th scope="col">Cp</th>
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
						<td><c:out value="${line.cts}" /></td>
						<td><c:out value="${line.cns}" /></td>
						<td><c:out value="${line.ci}" /></td>
						<td><c:out value="${line.tw}" /></td>
						<td><c:out value="${line.cps}" /></td>
						<td><c:out value="${line.cr}" /></td>
						<td><c:out value="${line.cs+line.cts+line.cns+line.ci+line.tw+line.cps+line.cr}" /></td>
					</tr>
				</c:forEach>
				
			</tbody>
		</table>
	</div>
</body>
</html>