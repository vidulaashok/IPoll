<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<html>
<head>

<link rel="stylesheet" type="text/css" href="css/layout.css">
<link rel="stylesheet" type="text/css" href="css/theme.css">
</head>

<body>
	<div id="box">
		<div id="head">
			<div id="headNavigation">
				<tiles:insertAttribute name="headNavigation" />
			</div>
			<div id="logo">
				<img src="images/Logo.png" />
			</div>
		</div>
		<div id="left">
			<tiles:insertAttribute name="menu" />
		</div>
		<div id="content">
			<tiles:insertAttribute name="content" />
		</div>
		<div id="right">
			<tiles:insertAttribute name="right" />
		</div>
	</div>
</body>
</html>