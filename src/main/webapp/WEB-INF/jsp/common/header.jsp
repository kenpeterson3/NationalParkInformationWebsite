<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>National Parks</title>
    <c:url value="/css/style.css" var="cssHref" />
    <link rel="stylesheet" href="${cssHref}">
</head>

<body>
	
    <header>
        <c:url var="logoImage" value="/img/logo.png"/>
         <img src="${logoImage }" class="logoImage"/><br>
    </header>
    
    <nav>
    <ul>
    <c:url var="homeLink" value="/" />
    <li><a href="${homeLink }">Home</a></li>
       <c:url var="surveyLink" value="/survey" />
    <li><a href="${surveyLink }">Survey</a></li>
           <c:url var="topParksLink" value="/topParks" />
    <li><a href="${topParksLink }">Top Parks</a></li>
    </ul>
  
    </nav>