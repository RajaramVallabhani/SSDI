<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Registration Page</title>
<link rel="stylesheet" type="text/css" href="css/style3.css" />
<link rel="stylesheet" type="text/css" href="css/animate-custom.css" />
</head>
<body style="margin: 0px;"
	background="http://www.macwallhd.com/wp-content/Wallpapers/20121028/Wallpaper%20Vacation%20Silhouette%20Island%20Seychelles888.jpg">
	
	<div class="maincontainer">
		<div id="container_demo">
			<!-- hidden anchor to stop jump http://www.css3create.com/Astuce-Empecher-le-scroll-avec-l-utilisation-de-target#wrap4  -->
			<a class="hiddenanchor" id="toregister"></a> <a class="hiddenanchor"
				id="tologin"></a>
			<div id="wrapper">
				<div id="login" class="animate form">
					<form action="LoginServlet" autocomplete="on" method="POST">
						<h1>Log in</h1>
						<p>
							<label for="username" class="uname" data-icon="u"> Your
								username </label> <input id="username" name="username"
								required="required" type="text"
								placeholder="myusername" value="" />
						</p>
						<p>
							<label for="password" class="youpasswd" data-icon="p">
								Your password </label> <input id="password" name="password"
								required="required" type="password" placeholder="eg. X8df!90EO" value="" />
						</p>
						<p class="keeplogin">
							<input type="checkbox" name="loginkeeping" id="loginkeeping"
								value="loginkeeping" /> <label for="loginkeeping">Keep
								me logged in</label>
						</p>
						<p class="login button">
							<input type="submit" value="Login" />
						</p>
						<p class="change_link" align="center">
						<a href="Home_Page_Final2.jsp" class="to_register" >Back to Home</a>
						&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
						Not a member yet ? <a href="#toregister" class="to_register">Join
								us</a>
						</p>
					</form>
				</div>

				<div id="register" class="animate form">
					<form action="register" autocomplete="on" method="POST">
						<h1>Sign up</h1>
						<p>
							<label for="usernamesignup" class="uname" data-icon="u"> Your username</label> <input id="usernamesignup" name="usernamesignup"
								required="required" type="text" placeholder="mysuperusername690" />
						</p>
						<p>
							<label for="emailsignup" class="youmail" data-icon="e">
								Your email</label> <input id="emailsignup" name="emailsignup"
								required="required" type="email"
								placeholder="mysupermail@mail.com" />
						</p>
						<p>
							<label for="passwordsignup" class="youpasswd" data-icon="p">Your
								password </label> <input id="passwordsignup" name="passwordsignup"
								required="required" type="password" placeholder="eg. X8df!90EO" />
						</p>
						<p>
							<label for="passwordsignup_confirm" class="youpasswd"
								data-icon="p">Please confirm your password </label> <input
								id="passwordsignup_confirm" name="passwordsignup_confirm"
								required="required" type="password" placeholder="eg. X8df!90EO" />
						</p>
						<p class="signin button">
							<input type="submit" value="Sign up" />
						</p>
						<p class="change_link" align="center">
						<a href="Home_Page_Final2.jsp" class="to_register" >Back to Home</a>
						&nbsp&nbsp&nbsp&nbsp&nbsp
							Already a member ? <a href="#tologin" class="to_register"> Go
								and log in </a>
						</p>
					</form>
				</div>

			</div>
		</div>

	</div>
	<div class="footer"></div>
</body>
</html>