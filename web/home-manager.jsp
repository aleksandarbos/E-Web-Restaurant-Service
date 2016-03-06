<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>   

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Web Restaurants - Manager</title>

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
<script type="text/javascript" src="js/home-manager.js"></script>


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
      <h2>Restaurant Manager's Home Page</h2>
      <br/>
      <p>Logged as: <b><i>${korisnik.email}</i></b> , Name:&nbsp;<b><i>${korisnik.ime}</i></b>, Surname:<b><i> ${korisnik.prezime}</i></b>&nbsp;, Role: <b><i>Restaurant Manager</i></b>
      &nbsp;&nbsp;&nbsp;&nbsp;<span><a href="./LogOutServlet">Sign Out</a></span>
      </p>
      <br/>
      <h2> Assigned Restaurant:</h2>
      <table id="restaurantsList" width="100%" border="1" cellpadding="2">
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
      </table>
      <p>&nbsp;</p>
      <h2>Restaurant's configuration:</h2>
      <table width="70%" border="1" cellpadding="5" cellspacing="3" id="restaurantTable">
      	<tr>
        	<td align="center">1</td>
        	<td align="center">2</td>
        	<td align="center">3</td>
        	<td align="center">4</td>
        	<td align="center">5</td>
        	<td align="center">6</td>
        	<td align="center">7</td>
       	</tr>
      	<tr>
      	  <td align="center">8</td>
      	  <td align="center">9</td>
      	  <td align="center">10</td>
      	  <td align="center">11</td>
      	  <td align="center">12</td>
      	  <td align="center">13</td>
      	  <td align="center">14</td>
   	    </tr>
      	<tr>
      	  <td align="center">15</td>
      	  <td align="center">16</td>
      	  <td align="center">17</td>
      	  <td align="center">18</td>
      	  <td align="center">19</td>
      	  <td align="center">20</td>
      	  <td align="center">21</td>
   	    </tr>
      	<tr>
      	  <td align="center">22</td>
      	  <td align="center">23</td>
      	  <td align="center">24</td>
      	  <td align="center">25</td>
      	  <td align="center">26</td>
      	  <td align="center">27</td>
      	  <td align="center">28</td>
   	    </tr>
      	<tr>
      	  <td align="center">29</td>
      	  <td align="center">30</td>
      	  <td align="center">31</td>
      	  <td align="center">32</td>
      	  <td align="center">33</td>
      	  <td align="center">34</td>
      	  <td align="center">35</td>
   	    </tr>
      	<tr>
      	  <td align="center">36</td>
      	  <td align="center">37</td>
      	  <td align="center">38</td>
      	  <td align="center">39</td>
      	  <td align="center">40</td>
      	  <td align="center">41</td>
      	  <td align="center">42</td>
   	    </tr>
      	<tr>
      	  <td align="center">43</td>
      	  <td align="center">44</td>
      	  <td align="center">45</td>
      	  <td align="center">46</td>
      	  <td align="center">47</td>
      	  <td align="center">48</td>
      	  <td align="center">49</td>
   	    </tr>
   	  </table>
    <p>Submit table configuration:<input type="button" id="submitTableConf" value="Submit"></p>
      <p><br/>
      </p>
      <h2>Restaurant's menu:</h2>
      <table width="100%" border="1" cellpadding="2" style="background-color:#FFF">
        <c:forEach items="${jela}" var="jelo">
        <form method="post" class="userForm" id="userForm" action="./MealsServlet">
        <tr>
          <td width="7%" rowspan="2" align="center" valign="middle"><img src="images/meal.jpg" width="70" height="70"></td>
          <td width="14%" rowspan="2" valign="top">Name:<b><i>
            <textarea name="name" rows="3">${jelo.naziv}</textarea>
          </i></b></td>
          <td valign="top">Price:<b><i>
            <input name="price" type="text" id="price" value="${jelo.cena}">
          </i></b></td>
          <td rowspan="2" valign="top">Description:<b><i>
            <textarea name="description" rows="4" id="description">${jelo.opis}</textarea>
          </i></b></td>
          <td valign="top">&nbsp;</td>
          </tr>
        <tr>
          <td valign="top">&nbsp;</td>
          <td valign="top">&nbsp;</td>
        </tr>
        <tr>
          <td align="center" valign="middle"><input type="submit" value="Submit changes!"></td>
          <td width="14%" valign="top">ID:<b><i>
            <input name="id" type="text" value="${jelo.id}" readonly>
            </i></b></td>
          <td valign="top">&nbsp;</td>
          <td valign="top">&nbsp;</td>
          <td valign="top">&nbsp;</td>
        </tr>
        </form>
        </c:forEach>
        <form method="post" action="./MealsServlet">
        <tr>
          <td width="7%" rowspan="2" align="center" valign="middle"><img src="images/addMeal.png" width="77" height="77"></td>
          <td width="14%" rowspan="2" valign="top">Name:<b><i>
            <textarea name="name" rows="3"></textarea>
          </i></b></td>
          <td valign="top">Price:<b><i>
            <input name="price" type="text" id="price">
          </i></b></td>
          <td rowspan="2" valign="top">Description:<b><i>
            <textarea name="description" rows="4" id="description"></textarea>
          </i></b></td>
          <td valign="top">&nbsp;</td>
          </tr>
        <tr>
          <td valign="top">&nbsp;</td>
          <td valign="top">&nbsp;</td>
        </tr>
        <tr>
          <td align="center" valign="middle"><input type="submit" value="Add new item!"></td>
          <td width="14%" valign="top">ID:<b><i>
            <input name="id" type="text" disabled readonly>
            </i></b></td>
          <td valign="top">&nbsp;</td>
          <td valign="top">&nbsp;</td>
          <td valign="top">&nbsp;</td>
        </tr>
        </form>
      </table>
      <p>&nbsp;</p>
	</div>		
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