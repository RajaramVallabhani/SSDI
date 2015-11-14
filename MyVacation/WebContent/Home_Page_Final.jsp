<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%  
String username=(String)request.getAttribute("name");  
if(username!=null){  
//out.print("Hello "+username);  
} else{
	//out.print("Hello Guest");
}  
 %> 
 
<html><head>
<link rel="stylesheet" href="css/home.css" type="text/css">
<link rel="stylesheet" href="css//jquery-ui.css">
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>

<title>My Vacation</title>
<style type="text/css">
  h2 {letter-spacing: 5px; font-size: .3in; 
  background-color: rgb(0,0,100); color: white;
  text-transform: uppercase; width: 600px}
  span {color: red}
  legend{font-variant: small-caps; font-weight:bold}
  fieldset{width: 600px; font-family: arial; 
           background-color: lightblue; color: rgb(0,0,100)}
  label {display: block; position: relative; line-height:2;
         margin: 10px 0px;}
  input {position: absolute; margin-left: 30px; width: 25em
         left: 180px}
  .placeButtons {position: relative; left: 0px; width: 110px} 
</style>

 <script>
  $(function() {
    $( "#tabs" ).tabs();
  });
  </script>

</head>
<body style="margin:0px;" background="http://www.macwallhd.com/wp-content/Wallpapers/20121028/Wallpaper%20Vacation%20Silhouette%20Island%20Seychelles888.jpg">
<div class="header" >
<img src="images/myvacalogo.png" alt="logo" style="width: 122px;" >  
	<div>Hello </div>
    <a href="Home_Page_Final2.jsp" class="btn btn-lg btn-block  btn-header " style="text-decoration: none;float:right; margin-top:15px;margin-right:10px;"> Logout </a>
	  
	    
</div>
<div class="maincontainer">
<div class="widget">
<div id="tabs">
  <ul>
    <li><a href="#destination">Destination</a></li>
  </ul>
<div class="destination">
<table style="width:100%">
 
     <tr><td>
   	<span class="widget-text">My Location</span> </td>
    </tr>
    
    <tr><td>
    <select name="MyLocation" class="dropDownList">
  <option value="Paris">Paris</option>
  <option value="Rome">Rome</option>
  <option value="London">London</option>
  <option value="Amsterdam">Amsterdam</option>
</select></td>
    </tr> 
        
    <tr>
    <td> 

     <img src="images/arrow-right.png" alt="arrow" height="20" width="20" style="margin-left: 80px;padding: 10px;">   

    </td>
    </tr> 
    
    
    <tr><td>
    <span class="widget-text">To</span> </td>
    </tr>
    
     
    <tr><td>
    <select name="To" class="dropDownList">
  <option value="Amsterdam">Amsterdam</option>
  <option value="Rome">Rome</option>
  <option value="London">London</option>
  <option value="Paris">Paris</option>
</select></td>
    </tr>

</table>
<a id="continue" href="javascript:void(0)" class="btn btn-lg btn-block  btn-primary-red " style="text-decoration: none;margin-top: 10px;"> Continue </a>
</div>

</div>
 


</div>

</div>
<div class="footer">
</div>
</body>
</html>