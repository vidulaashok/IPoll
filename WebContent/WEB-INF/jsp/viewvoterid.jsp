<%@page import="dao.User"%>
<%@page import="dao.VoterId"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="dao.User"%>
<%@ page isELIgnored ="false" %>
<div id="info"><div id="left_uni"><span class="username_label">id: </span><span id="username_value" class="username_value">${requestScope.user.id}</span></div><div id="right_uni"><span class = "lastlogin_label">lastlogin: </span><span class = "lastlogin_value">${requestScope.user.lastLogin}</span></div></div>
<c:if test="${not empty requestScope.votercard}">
	<div class="votercard_header"><div id="left_uni"><span class="votercard_name_label"></span><span class="votercard_name_value">${requestScope.votercard.name} ${requestScope.votercard.surName}</span></div><div id="right_uni"><img class="votercard_image" src="./File?fileid=${requestScope.votercard.imageFileId }"></div></div>

			<div class="votercard_content">
				<span class="votercard_heading">Personal</span>
				<div class="votercard_personal">
					<div class = "votercard_property"><span class="votercard_label">Date of birth: </span><span class="votercard_value">${requestScope.votercard.dateOfBirth.date} / ${requestScope.votercard.dateOfBirth.month+1} / ${requestScope.votercard.dateOfBirth.year+1900}</span></div>
					<div class = "votercard_property"><span class="votercard_label">Sex: </span><span class="votercard_value">${requestScope.votercard.sex}</span></div>
					<div class = "votercard_property"><span class="votercard_label">Place of birth: </span><span class="votercard_value">${requestScope.votercard.placeOfBirth}</span></div>
					
					<span class="votercard_property_heading">Current address</span>
					<div class="votecard_sub_property"><span class="votercard_label">House : </span><span class="votercard_value">${requestScope.votercard.currentAddress}</span></div>
					<div class="votecard_sub_property"><span class="votercard_label">Ward n.o: </span><span class="votercard_value">${requestScope.votercard.currentAddressWardNo}</span></div>
					<div class="votecard_sub_property"><span class="votercard_label">City: </span><span class="votercard_value">${requestScope.votercard.currentAddressCityTown}</span></div>
					<div class="votecard_sub_property"><span class="votercard_label">State: </span><span class="votercard_value">${requestScope.votercard.currentAddressState}</span></div>
				</div>
				<span class="votercard_heading">Other</span>
				<div class="votercard_personal">
				<div class = "votercard_property"><span class="votercard_label">Father's name: </span><span class="votercard_value">${requestScope.votercard.fathersName}</span></div>
					<div class = "votercard_property"><span class="votercard_label">Rel Id: </span><span class="votercard_value">${requestScope.votercard.relID}</span></div>
				</div>
				<div class="votercard_property"><span class="votercard_label">Status: </span><span class="votercard_value"><c:if test="${requestScope.votercard.validity eq 2 }">Accepted</c:if><c:if test="${requestScope.votercard.validity eq 3 }">Rejected</c:if><c:if test="${requestScope.votercard.validity eq 0 }">Not validated</c:if></span>
				</div>
			</div>
			<c:if test="${requestScope.votercard.validity eq 3	 }">
				<form>
					<table class="verifyblock">
					<tbody>
					<tr>
					<td><input type="hidden" id="voterid" value="${requestScope.votercard.voterID}" name="voterid" /><input type="submit" value="edit"></td>
					</tr>
					</tbody>
					</table>
				</form>
			</c:if>
</c:if>