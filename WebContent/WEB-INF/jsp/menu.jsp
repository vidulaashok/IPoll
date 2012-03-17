<%@taglib uri="/struts-tags" prefix="s"%>
<div id="menu">
	<div class="heading">Navigate</div>
	<a href="<s:url action='home.action' />" alt="Home">Home</a>
	<br />
	<a href="<s:url action='news.action' />" alt="News">News</a>
	<br />
	<a href="<s:url action='login.action' />" alt="Login">Login</a>
	<br />
	<a href="<s:url action='help.action' />" alt="Help">Help</a>
	<br />
	<div class="heading">Register for</div>
	<a href="<s:url action='register.action' />">User</a>
	<br />
	<div class="heading">Search</div>
	<center>
	<div id="searchBox">
		<span>Google</span><br>
		<input type="text" class="textBox" />
		<button class="button" alt="go">Go</button>
	</div>
	</center>
	<div class="spacer">
	</div>
</div>