<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
</head>
<body>
	<jsp:include page="menuBar.jsp"></jsp:include>
    
    <form  action="ComplexityController" enctype="multipart/form-data" method="POST">
  		<input type="file" name="file" multiple="true">
  		<p>Drag your files here or click in this area.</p>
  		<button type="submit">Calculate Complexity</button>
	</form>
    
</body>
</html>

<script>

$(document).ready(function(){
	
	  $('form input').change(function () {
	    $('form p').text(this.files.length + " file(s) selected");
	  });
	});
	
</script>