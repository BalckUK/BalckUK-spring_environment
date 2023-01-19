<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>파일업로드 페이지</title>
</head>
<body>

	<form:form method="post" enctype="multipart/form-data" action="upload">
		<h3>uploadForm</h3>
		file<br />
		<input type="file" name="mpfile" />
		<br />
		<p style="color: red; font-weight: bold;">
			<form:errors path="mpfile"></form:errors>
		</p>
		<br />
		<textarea rows="10" cols="40" name="desc"></textarea>
		<br />
		<input type="submit" value="send" />
	</form:form>

</body>
</html>