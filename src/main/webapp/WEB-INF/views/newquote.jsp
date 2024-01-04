<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>Login To Site</title>
	</head>
	<body>
		<h3>Quote your own idea!!</h3>
		<form action="/qotd/newquote" method="POST">
			<label for="quote_title">Title</label>
			<input type="text" id="quote_title" name="quote_title" />

			<label for="quote_body">Body</label>
			<input type="text" id="quote_body" name="quote_body" />

			<label for="quote_contributor">Your Name</label>
			<input type="text" id="quote_contributor" name="quote_contributor" />

			<input type="submit" />
		</form>
		<%
			Boolean isInvalidInput = (Boolean)request.getAttribute("invalid_input"),
					isSuccessSaved = (Boolean)request.getAttribute("success_saved");
					
			System.out.print(isInvalidInput);
			
			if (isInvalidInput) {
		%>
		<h3 style="color:red;">Previous Input Was Invalid, Please Re Enter Your Input!!<h3>
		<%
			}
			
			if (isSuccessSaved) {
		%>
		<h3 style="color:green;">Successfully added new Quote!!<h3>
		<%
			}
		%>
		<a href="/qotd/welcome">Back To Hompage</a>
	</body>
</html>