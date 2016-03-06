<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>   

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Web Restaurants - ${restoran.naziv}</title>

<link rel="stylesheet" type="text/css" href="css/styles.css" />
<link rel="stylesheet" type="text/css" href="css/default.css" />
<link rel="stylesheet" type="text/css" href="css/component.css" />
<link rel="stylesheet" type="text/css" href="css/jquery.toastmessage.css" />
<link rel="stylesheet" type="text/css" href="plugins/fbox/source/jquery.fancybox.css?v=2.1.5" media="screen" />
<link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">

<link rel="stylesheet" href="jqwidgets/styles/jqx.base.css" type="text/css" />


<script type="application/javascript" src="js/jquery-1.11.3.min.js"></script>
<script src="js/modernizr.custom.js"></script>

<script type="text/javascript" src="js/jquery.toastmessage.js"></script>
<script src='js/jquery.elevatezoom.js'></script>
<script type="text/javascript" src="plugins/fbox/source/jquery.fancybox.js?v=2.1.5"></script>
<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
<script type="text/javascript" src="jqwidgets/jqxcore.js"></script>
<script type="text/javascript" src="jqwidgets/jqxmenu.js"></script>
<script type="text/javascript" src="jqwidgets/jqxbuttons.js"></script>
<script type="text/javascript" src="jqwidgets/jqxfileupload.js"></script>
<script type="text/javascript" src="jqwidgets/jqxpanel.js"></script>
<script type="text/javascript" src="jqwidgets/jqxscrollbar.js"></script>


</head>
<body>

<div id="wrapper">
  <div id="headerDiv">
			<div>
				<a href="">
					<img src="images/logo.jpg" name="logo" width="220" id="logo"/></a>WEB Restaurants	  </div>
	</div>
	
	<div id="menuDivSplit"></div>
	<div id="adminContentDiv">
      <h2>${restoran.naziv}</h2>
      <br/> <p><a href="home-guest.jsp">Home</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="home-guest-restaurants.jsp">Restaurants</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="home-guest-friends.jsp">Friends</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="home-guest-profile.jsp">My Profile</a></p>
      <br/>
      <p>Logged as: <b><i>${korisnik.email}</i></b> , Name:&nbsp;<b><i>${korisnik.ime}</i></b>, Surname:<b><i> ${korisnik.prezime}</i></b>&nbsp;, Role: <b><i>Restaurant Guest</i></b> &nbsp;&nbsp;&nbsp;&nbsp;<span><a href="./LogOutServlet">Sign Out</a></span> &nbsp;&nbsp;</p>
      <br/>
      <p> Opened restaurant:</p>
      <table id="restaurantsList" width="100%" border="1" cellpadding="2">
      		<div>
      		    <tr>
      		      <td width="25%" rowspan="3" align="center"><img src="${restoran.slika}" width="256" height="166"></td>
      		      <td width="17%" height="37" valign="top">Name:<b><i>${restoran.naziv}</i></b></td>
      		      <td width="24%" valign="top">Contact:<b><i>${restoran.kontakt}</i></b></td>
      		      <td width="34%" rowspan="3" valign="top">Location:
      		        <iframe width="400" height="130" frameborder="0" style="border:0" src="https://www.google.com/maps/embed/v1/place?q=loc:36.26577,-92.54324&key=AIzaSyBrjeABCsOwW1rhi7eW6_b_fWF8OK2HeiA" allowfullscreen></iframe></td>
   		        </tr>
      		    <tr>
      		      <td height="79" valign="top" bgcolor="#FFFFFF">Address:<b><i>${restoran.adresa}</i></b></td>
      		      <td rowspan="2" valign="top">Description:<b><i>${restoran.opis}</i></b></td>
	          </tr>
      		    <tr>
      		      <td valign="bottom" bgcolor="#FFFFFF">&nbsp;</td>
   		      </tr>
      		</div>
      </table>
      <br/>
	</div>		
  <p><br>
  </p>
	</div>
	<div id="footerDiv">
		<h5>Aleksandar Bošnjak. ISA-project 2016.</h5>
	</div>
</div>
	<script src="js/grid.js"></script>
	<script>		
		$(function() {		// automatski se poziva na kraju loada
			Grid.init();
		});
	</script>
</body>
</html>