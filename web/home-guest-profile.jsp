<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>   

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Web Restaurants - Guest Profile</title>

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
      <h2>My Profile</h2><br/> <p><a href="home-guest.jsp">Home</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="home-guest-restaurants.jsp">Restaurants</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="./FriendsServlet">Friends</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;My Profile</p>
      <br/>
      <p>Logged as: <b><i>${korisnik.email}</i></b> , Name:&nbsp;<b><i>${korisnik.ime}</i></b>, Surname:<b><i> ${korisnik.prezime}</i></b>&nbsp;, Role: <b><i>Restaurant Guest</i></b> &nbsp;&nbsp;&nbsp;&nbsp;<span><a href="./LogOutServlet">Sign Out</a></span> </p>
      <br/>
      <p> Profile data:</p>
      <br/>
      <table width="100%" border="1" cellpadding="2">
        <form method="post" class="userForm" id="userForm-${menadzer[0]}" action="./AccountServlet">
        <tr>
          <td width="7%" rowspan="2" align="center" valign="middle"><img src="images/avatar.png" width="64" height="64"></td>
          <td width="14%" rowspan="2" valign="top">Name:<b><i><input type="text" value="${korisnik.ime}" name="name"></i></b></td>
          <td width="16%" valign="top">Surname:<b><i><input type="text" value="${korisnik.prezime}" name="surname"></i></b></td>
          <td width="15%" valign="top">Email:<b><i><input name="email" type="text" value="${korisnik.email}" readonly></i></b></td>
        </tr>
        <tr>
          <td width="16%" rowspan="2" valign="top">Address:<b><i>
            <textarea name="address" rows="3">${korisnik.adresa}</textarea>
          </i></b></td>
          <td width="15%" valign="top">Password:<b><i>
          <input name="password" type="text" id="password" value="${korisnik.lozinka}">
          </i></b></td>
        </tr>
        <tr>
          <td align="center" valign="middle"><input type="submit" value="Submit changes!"></td>
          <td width="14%" valign="top">ID:<b><i>
            <input name="id" type="text" value="${korisnik.id}" readonly>
          </i></b></td>
          <td width="15%" valign="top">&nbsp;</td>
        </tr>
        </form>
      </table>
      <p>&nbsp;</p>
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