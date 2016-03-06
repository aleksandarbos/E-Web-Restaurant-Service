<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>   

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Web Restaurants - Admin</title>

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
<script type="text/javascript" src="js/home-admin.js"></script>


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
      <h2>System Manager's Home Page</h2>
      <br/>
      <p>Logged as: <b><i>${korisnik.email}</i></b> &nbsp;, Name:&nbsp;<b><i>${korisnik.ime}</i></b>, Surname:<b><i> ${korisnik.prezime}</i></b>&nbsp;, &nbsp;Role: <b><i>System Manager</i></b>&nbsp;&nbsp;&nbsp;&nbsp;<span><a href="./LogOutServlet">Sign Out</a></span>
      </p><br/>
      <h2>Restaurants list:</h2>
      <table id="restaurantsList" width="100%" border="1" cellpadding="2">
      <c:forEach items="${restorani}" var="restoran">
      		<div>
            <form method="post" action="./RestaurantsServlet">
      		    <tr>
      		      <td width="28%" rowspan="4" align="center" rowinput="2"><img src="${restoran.slika}" width="256" height="166"></td>
      		      <td width="17%" height="7" valign="top">Name:<b><i><input name="name" id="restaurantName" type="text" value="${restoran.naziv}"></i></b></td>
      		      <td width="15%" valign="top">Contact:<b><i><input name="contact" id="restaurantContact" type="text" value="${restoran.kontakt}"></i></b></td>
      		      <td width="40%" rowspan="4" valign="top" rowinput="3">Location:
      		        <iframe width="460" height="130" frameborder="0" style="border:0" src="https://www.google.com/maps/embed/v1/place?q=loc:36.26577,-92.54324&key=AIzaSyBrjeABCsOwW1rhi7eW6_b_fWF8OK2HeiA" allowfullscreen></iframe></td>
   		        </tr>
      		    <tr>
      		      <td height="3" valign="top">Address:<b><i>
      		        <input name="address" id="restaurantAddress" type="text" value="${restoran.adresa}">
      		      </i></b></td>
      		      <td width="15%" rowspan="3" valign="top">Description:<b><i>
      		        <textarea rows="5" name="description" id="restaurantDesc">${restoran.opis}</textarea>
      		      </i></b></td>
	          </tr>
      		    <tr>
      		      <td height="0" valign="top">Picture URL:
                    <input name="photo" type="text" id="restaurantId3" value="${restoran.slika}"></td>
   		      </tr>
      		    <tr>
      		      <td height="1" valign="top">Id:
                  <input name="id" type="text" id="restaurantId2" value="${restoran.id}" readonly></td>
   		      </tr>
      		    <tr>
      		      <td height="18" valign="top"><input name="Submit" type="submit" id="editRestaurant-${restoran.id}" value="Submit restaurant: ${restoran.naziv} changes!"></td>
      		      <td width="17%" valign="top">&nbsp;</td>
	          </tr>
      		    <tr>
      		      <td width="28%" align="center">&nbsp;</td>
      		      <td valign="top" bgcolor="#FFFFFF">&nbsp;</td>
      		      <td valign="top">&nbsp;</td>
	          </tr>
              </form>
      		</div>
      </c:forEach>
      <div>
            <form method="post" action="./RestaurantsServlet">
      		    <tr>
      		      <td width="28%" rowspan="4" align="center" rowinput="2"><img src="images/addImage.png" width="154" height="154"></td>
      		      <td width="17%" height="7" valign="top">Name:<b><i><input name="name" id="restaurantName" type="text"> </i></b></td>
      		      <td width="15%" valign="top">Contact:<b><i><input name="contact" id="restaurantContact" type="text"> </i></b></td>
      		      <td width="40%" rowspan="4" valign="top" rowinput="3">Location:
      		        <iframe width="460" height="130" frameborder="0" style="border:0" src="https://www.google.com/maps/embed/v1/place?q=loc:36.26577,-92.54324&key=AIzaSyBrjeABCsOwW1rhi7eW6_b_fWF8OK2HeiA" allowfullscreen></iframe></td>
   		        </tr>
      		    <tr>
      		      <td height="3" valign="top">Address:<b><i>
      		        <input name="address" id="restaurantAddress" type="text" >
      		      </i></b></td>
      		      <td width="15%" rowspan="3" valign="top">Description:<b><i>
      		        <textarea rows="5" name="description" id="restaurantDesc"></textarea>
      		      </i></b></td>
	          </tr>
      		    <tr>
      		      <td height="38" valign="top">Picture URL:<b><i>
      		        <input name="photo" id="restaurantAddress2" type="text">
      		      </i></b></td>
   		      </tr>
      		    <tr>
      		      <td height="42" valign="top">Id: 
   		          <input name="id" type="text" disabled id="restaurantId"></td>
   		      </tr>
      		    <tr>
      		      <td height="18" valign="top"><input name="Submit" type="submit" id="editRestaurant" value="Add new restaurant!"></td>
      		      <td width="17%" valign="top">&nbsp;</td>
	          </tr>
      		    <tr>
      		      <td width="28%" align="center">&nbsp;</td>
      		      <td valign="top" bgcolor="#FFFFFF">&nbsp;</td>
      		      <td valign="top">&nbsp;</td>
	          </tr>
              </form>
      		</div>

      </table>
      <br/>
      <br/>
      <h2>Managers list:</h2>
      <table width="100%" border="1" cellpadding="2">
        <c:forEach items="${menadzeri}" var="menadzer">
        <form method="post" class="userForm" id="userForm-${menadzer[0]}" action="./AccountServlet">
        <tr>
          <td width="7%" rowspan="2" align="center" valign="middle"><img src="images/avatar.png" width="64" height="64"></td>
          <td width="14%" rowspan="2" valign="top">Name:<b><i><input type="text" value="${menadzer[2]}" name="name"></i></b></td>
          <td width="16%" valign="top">Surname:<b><i><input type="text" value="${menadzer[3]}" name="surname"></i></b></td>
          <td width="20%" rowspan="2" valign="top">Role:<b><i>
          	<c:if test="${menadzer[6] == 'MR'}">
               <input type="text" value="Restaurant Manager" name="role">
			</c:if>
            <c:if test="${menadzer[6] == 'MS'}">
               <input type="text" value="System Manager" name="role">
			</c:if>
            </i></b></td>
          <td width="15%" valign="top">Email:<b><i><input type="text" value="${menadzer[5]}" name="email"></i></b></td>
        </tr>
        <tr>
          <td width="16%" rowspan="2" valign="top">Address:<b><i>
            <textarea name="address" rows="3">${menadzer[4]}</textarea>
          </i></b></td>
          <td width="15%" valign="top">Password:<b><i>
          <input name="password" type="text" id="password" value="${menadzer[7]}">
          </i></b></td>
        </tr>
        <tr>
          <td align="center" valign="middle"><input type="submit" value="Submit changes!"></td>
          <td width="14%" valign="top">ID:<b><i>
            <input name="id" type="text" value="${menadzer[0]}" readonly>
          </i></b></td>
          <td width="20%" valign="top">Assigned Rest:<b><i>
          <c:if test="${menadzer[6] == 'MS'}"> 
          <input name="assigned" type="text" id="assigned" value="${assignedRestaurants[menadzer[0]]}" class="assignRestaurant" readonly>
          </c:if>
          <c:if test="${menadzer[6] == 'MR'}"> 
          <input name="assigned" type="text" id="assigned" value="${assignedRestaurants[menadzer[0]]}" class="assignRestaurant">
          </c:if>
          </i></b></td>
          <td width="15%" valign="top">&nbsp;</td>
        </tr>
        </form>
        </c:forEach>
        <form method="get" action="./CreateAccountServlet">
        <tr>
          <td width="7%" rowspan="2" align="center" valign="middle"><img src="images/addAvatar.png" width="64" height="64"></td>
          <td width="14%" rowspan="2">Name:<b><i><input type="text" value="" name="name"></i></b></td>
          <td width="16%">Surname:<b><i><input type="text" value="" name="surname"></i></b></td>
          <td width="20%" valign="top">Role:<b><i><input type="text" value="" name="role"></i></b></td>
          <td width="15%">Email:<b><i><input type="text" value="" name="email"></i></b></td>
        </tr>
        <tr>
          <td valign="top">Address:<b><i>
          <textarea name="address" rows="3" id="address"></textarea>
          </i></b></td>
          <td width="20%" valign="top">&nbsp;</td>
          <td width="15%" valign="top">Password:<b><i>
          <input name="password" type="text" id="password">
          </i></b></td>
        </tr>
        <tr>
          <td align="center" valign="middle"><input type="submit" value="Add new manager!"></td>
          <td width="14%">ID:<b><i>
            <input name="id" type="text" disabled>
          </i></b></td>
          <td width="16%">&nbsp;</td>
          <td width="20%" valign="top">Assigned Rest:<b><i>
            <input name="assigned" type="text" disabled="disabled" class="assignRestaurant" id="assigned" value="">
          </i></b></td>
          <td width="15%">&nbsp;</td>
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