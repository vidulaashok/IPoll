<%@taglib uri="/struts-tags" prefix="s"%>
<div class="main">
	<h1>Welcome to I-Poll</h1>
		<p>
		An interactive online Polling solution
		</p>
	<h2>How do i I-Poll</h2>
	<p>
		you can I-poll if you are registered to the website.

		For registration
		<a href="<s:url action='register.action' />">click here</a>.
	</p>
	<p>
		Already registered proceed to
		<a href="<s:url action='login.action' />">Login</a>
	</p>
	<div class="spacer" >
	</div>
</div>