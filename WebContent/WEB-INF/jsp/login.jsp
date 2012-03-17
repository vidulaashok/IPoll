<%@taglib uri="/struts-tags" prefix="s"%>
<%@ page isELIgnored ="false" %>
<div class="main">
	<h1>Welcome to I-Poll</h1>
		<p>
		An interactive online Polling solution
		</p>
	<h2>Please login here</h2>
	<s:form action="logmein.action" method="post">
	<table>
			<s:div cssClass="error">${requestScope.error}</s:div>
			<s:textfield label="Username" cssClass="textBox" id="user" name="user" />
			<s:password label="Password"  cssClass="textBox" id="pswd" name="pswd" />
		<tr>
			<td colspan="2"><input  type="submit" value="Login" /></td>
		</tr>
	</table>
	</s:form>
	
	<p>
		Not a member ?
		For registration
		<a href="">click here</a>.
	</p>
	<div class="spacer" >
	</div>
</div>