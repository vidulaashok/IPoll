<%@taglib uri="/struts-tags" prefix="s"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored ="false" %> 

<div id="menu">
	<div class="heading">Navigate</div>
	<a href="<s:url action='home.action' />" alt="Home">Home</a>
	<br />
	<a href="<s:url action='news.action' />" alt="News">News</a>
	<br />
	<a href="<s:url action='help.action' />" alt="Help">Help</a>
	<br />
	<a href="<s:url action='logout.action' />" alt="logout">Logout</a>
	<br />
	<div class="heading">Register for</div>
	<a href="<s:url action='voteridReg.action' />" alt="home">Voter ID</a>
	<br />
	<c:if test="${sessionScope.user.type eq  \"WardUser\"}">
	<div class="heading">Manage requests</div>
	<a href="<s:url action='requestForVoterIdWardUser.action' />" alt="home">Voter ID</a>
	<br />
	</c:if>
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