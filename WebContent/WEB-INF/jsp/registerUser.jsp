<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored ="false" %>
<script language="javascript" type="text/javascript">
var isValid = false;
function hasFilledfields()
{
	if(document.getElementById('user').value.length!=0&&document.getElementById('password').value.length!=0&&
			document.getElementById('conPassword').value.length!=0&&document.getElementById('email').value
			.length!=0&&document.getElementById('language').value.length!=0)
	{
		var temp = document.getElementById("error");
		temp.innerHTML = "";
		return true;
	}
	var temp = document.getElementById("error");
	temp.innerHTML = "<p>Error: Empty Fields.</p>";
	return false;
}
function passTest()
{
	if(document.getElementById('password').value==document.getElementById('conPassword').value)
	{
		var temp = document.getElementById("passError");
		temp.innerHTML = "";
		return true;
	}
	var temp = document.getElementById("passError");
	temp.innerHTML = "<p>Error: Password dont match.</p>";
	return false;
}
function verifyForm()
{
	verify();
	if(passTest()&&hasFilledfields())
	{
		return isValid;
	}
	return false;
}
function verify()
{
	var xmlhttp;
	var txt,xx,x,i;
	if (window.XMLHttpRequest)
	  {// code for IE7+, Firefox, Chrome, Opera, Safari
	  xmlhttp=new XMLHttpRequest();
	  }
	else
	  {// code for IE6, IE5
	  xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
	  }
	xmlhttp.onreadystatechange=function()
	  {
	  if (xmlhttp.readyState==4 && xmlhttp.status==200)
	    {
		  x=xmlhttp.responseXML.documentElement.getElementsByTagName("msg");
		  if(x.length==1)
			{
			  
				xx=x[0].getElementsByTagName("Query");
				var temp = xx[0].firstChild.nodeValue;
				if(temp=="UserExist")
				{
					
					xx=x[0].getElementsByTagName("value");
					if(xx[0].firstChild.nodeValue=="false")
					{
						var temp = document.getElementById("idError");
						temp.innerHTML="";
						isValid = true;
					}
					else if(xx[0].firstChild.nodeValue=="true"){
						var temp = document.getElementById("idError");
						temp.innerHTML = "<p>Error: User Exists try a different id.</p>";
						isValid = false;
					}
					else
					{
						var temp = document.getElementById("idError");
						temp.innerHTML = "<p>Error: Internal Error please try later.</p>";
						isValid = false;
					}
				}
			}
	    }
	  }
	var pval = "user=" + document.getElementById("user").value;
	xmlhttp.open("GET","/IPoll/UserExist?"+pval,true);
	xmlhttp.send();
}
</script>
<div class="main">
	<h2>Register As User</h2>

	<c:if test="${not empty requestScope.msg}">
	<label class="error">${requestScope.msg}</label>
	</c:if>
	<s:form onsubmit="return verifyForm()" action="regUser.action">
		<s:label id="error" />
		<s:textfield onblur="verify()" label="UserID " name="user" id="user" />
		<s:label id="idError" />
		<s:password label="Password " name = "password" id="password" />
		<s:password onblur="passTest()" name="conPassword" label="Confirm password " id ="conPassword" />
		<s:label id="passError" />
		<s:combobox label="Language " id="language" name="language" list="{'EN-US','KAN','HIN','SKT'}" />
		<s:textfield size="25" label="Email-ID " name="email" id="email" />
		<s:submit value="Register" />
	</s:form>
</div>