<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ITIS home page</title>
<style>

#section-left {
     line-height:30px;
     background-color:#ffffff;
     height:900px;
     width:20%;
     float:left;
}
#section-center {
    width:55%;
    height:900px;
    float:left;
    background-color:#87cefa;
}
#section-right {
	float:left;
	width:25%;
	height:900px;
    background-color:#ffa500;
}
#main {
	background-color:#ffffff;
	height:500px;
}
#main_bot {
	float:left;
	width:400px;
}
#right {
	background-color:#ffffff;
	height:300px;
}
#footer {
    background-color:black;
    color:white;
    clear:both;
    text-align:center;
    padding:5px; 
}
</style> 
</head>
<body>

<div id="section-left">
 	<img src="test_picture/ITIS_logo_white.jpg" width="300">
</div>

<div id="section-center">
	<div id="main"><a onClick="#"><img src="test_picture/main_picture.jpg" border="0" height="500"></a></div>
	<div id="main_bot">ITIS NEWS</div>
	<div id="main_bot">ITIS PICTURE</div>
</div>

<div id="section-right">
	<div id="right"><a onClick="#"><img src="test_picture/right_carrers.png" border="0"></a></div>
	<div id="right"><a onClick="#"><img src="test_picture/yellow_id.jpg" border="0"></a></div>
	<div>Calendar</div>
</div>

<div id="footer">
 Copyright © Kookmin University. MIS ITIS
</div>

</body> 
</html>