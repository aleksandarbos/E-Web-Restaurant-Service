<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>   

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Web Restaurants - Friends</title>

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
      <h2>Friends</h2><br/> <p><a href="home-guest.jsp">Home</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="home-guest-restaurants.jsp">Restaurants</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Friends&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="home-guest-profile.jsp">My Profile</a></p>
      <br/>
      <p>Logged as: <b><i>${korisnik.email}</i></b> , Name:&nbsp;<b><i>${korisnik.ime}</i></b>, Surname:<b><i> ${korisnik.prezime}</i></b>&nbsp;, Role: <b><i>Restaurant Guest</i></b> &nbsp;&nbsp;&nbsp;&nbsp;<span><a href="./LogOutServlet">Sign Out</a></span> </p>
      <br/>
      <br/>
      <p>Friends list:</p>
      <table width="100%" border="1" cellpadding="2">
        <c:forEach items="${prijatelji}" var="prijatelj">
        <tr>
          <td width="7%" align="center" valign="middle"><img src="images/avatar.png" width="64" height="64"></td>
          <td width="14%">Name:<b><i>${prijatelj.ime}</i></b></td>
          <td width="16%">Surname:<b><i>${prijatelj.prezime}</i></b></td>
          <td width="15%">Email:<b><i>${prijatelj.email}</i></b></td>
          <td valign="middle"><form action="./FriendsServlet" method="post">
          <input type="text" value="${prijatelj.id}" name="id" style="display:none">
          <input type="text" value="removeFriend" name="instruction" style="display:none">
          <input type="submit" value="Remove friend"></form></td>
          
        </tr>
        </c:forEach>
                <form method="post" action="./FriendsServlet">
        <tr>
          <td width="7%" align="center" valign="middle"><img src="images/addAvatar.png" width="64" height="64"></td>
          <td width="14%">Name:<b><i><input name="personId" type="text" id="personId" list="friendsList" value=""></i></b></td>
          <datalist id="friendsList">
          <c:forEach items="${korisnici}" var="korisnik">
                <option value="${korisnik.prezime} ${korisnik.ime}-${korisnik.id}">                
                <option value="${korisnik.ime} ${korisnik.prezime}-${korisnik.id}">                
          </c:forEach>
          </datalist>
          <td width="16%"><input type="submit" value="Add new friend!"></td>
          <td width="20%" valign="top">&nbsp;</td>
          <td width="15%">&nbsp;</td>
        </tr>
        <input type="text" value="addFriend" name="instruction" style="display:none">
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