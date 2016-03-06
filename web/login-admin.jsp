<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

<link rel="stylesheet" type="text/css" href="css/styles.css" />
<link rel="stylesheet" type="text/css" href="css/jquery.toastmessage.css" />


<script type="application/javascript" src="js/jquery-1.11.3.min.js"></script>
<script type="text/javascript" src="js/jquery.toastmessage.js"></script>



</head>

<body>
   
<div id="loginDiv"> 
    <form method="get" id="loginForm" accept-charset="UTF-8" action="./LogInServlet">
        <table id="tableLogin">
            <tr class="windowHeading">
                <th id="tableHeadingCell" colspan="2"><img src="images/logo.jpg" width="338" height="338"></th>     
            </tr>
            <tr class="windowHeading">
              <th id="tableHeadingCell2" colspan="2">Employee:-Log In</th>
            </tr>
            <tr>
                <td>Email:</td>
                <td><input name="email" type="text" id="email"/></td>
            </tr>
            <tr>
                <td>Password:</td>
                <td><input name="pwd" type="password" id="pass"/></td>
            </tr>
            <tr>
                <td>
                    <input type="submit" value="Submit" id="submitBtn"/>
                </td>
                <td>&nbsp;</td>
            </tr>
        </table>
    </form>
</div>


</body>
</html>
