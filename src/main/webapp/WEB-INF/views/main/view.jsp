<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<body>
	<form name="file-form" action="/uploadFile" method="post" enctype="multipart/form-data">
		<input type="file" id="file" name="file"/>
		<input type="text" id="fileName" name="fileName"/>
		<button type="submit">upload</button>
	</form>
</body>

<!-- js -->
<script type="text/javascript" src="/js/jquery/jquery.min.js"></script>
<script type="text/javascript" src="/js/bootstrap/bootstrap.min.js"></script>
<script type="text/javascript" src="/js/common.js"></script>

<script type="text/javascript">
	$( function() {
		common.fetch(
				'/testDto'
				, {str : '111', number : 1}
				, function(r) {console.log(r)
				}
		)
	});
</script>
</html>