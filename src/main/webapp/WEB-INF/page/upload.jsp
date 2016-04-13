<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
	</head>
	<body>
		<form action="testFileUpload.mvc" method="post"
			enctype="multipart/form-data">
			<input type="text" name="username">
			<input type="file" name="file">
			<input type="submit" value="开始上传">
		</form>
	</body>
</html>
