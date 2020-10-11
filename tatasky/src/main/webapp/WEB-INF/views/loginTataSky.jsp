<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<link rel="icon"
	href="<c:url value="https://www.tatasky.com/assets/favicon.ico"/>">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Login</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css"
	integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb"
	crossorigin="anonymous">
<!-- <link rel="stylesheet" href="/resources/assets/css/style.css"> -->
</head>
<body>
	<link href="<c:url value="/resources/assets/css/style.css" />"
		rel="stylesheet">
	<div style="height: 70px; position: relative; z-index: 10;">
		<header class="" style="box-shadow: none;">
			<nav class="navbar navbar-expand-md">
				<a class="navbar-brand no-space-logo" href="#!"> <img
					src="<c:url value="/resources/assets/images/tata-sky-logo.png" />"
					alt="Logo" title="Logo">
				</a>
			</nav>
		</header>
	</div>

	<div class="container">

		<div class="heading-md">
			<p class="heading1 gradient">Welcome to the Contract signing
				application!</p>
		</div>
		<div class="heading-md">
			<p class="heading2">Log in to manage your account</p>
		</div>

		<div class="row">
			<div class="col-md-4"></div>
			<div class="col-md-4">
				<form name='form' action='j_spring_security_check' method='POST'>
					<center>

						<fieldset style="width: 300px; margin-top: 50px">
							<legend>User Login</legend>

							<c:if test="${not empty SPRING_SECURITY_LAST_EXCEPTION}">
								<font color="red"> Your login attempt was not successful
									due to <br />
								<br /> <c:out value="${SPRING_SECURITY_LAST_EXCEPTION.message}" />.
								</font>
							</c:if>

							<c:if test="${not empty message}">
								<font color="red"> <c:out value="${message}" />.
								</font>
							</c:if>
							<c:if test="${not empty messageLogout}">
								<font color="red"> <c:out value="${messageLogout}" />.
								</font>
							</c:if>
							<table>
								<tr>
									<td>User Name:</td>
									<td><input type='text' name='j_username' value=''></td>
								</tr>
								<tr>
									<td>Password:</td>
									<td><input type='password' name='j_password' /></td>
								</tr>
								<tr>
									<td colspan='2'><input name="submit" type="submit"
										value="Login" /></td>
								</tr>
							</table>
						</fieldset>
					</center>
				</form>
			</div>
		</div>
		<div class="col-md-4"></div>
	</div>
	</div>

	<%-- <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
		integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
		integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
		crossorigin="anonymous"></script>
	<script src="<c:url value="/resources/assets/js/script.js" />"></script> --%>

</body>
</html>