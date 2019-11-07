<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
  <title>Start Page</title>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <link rel="stylesheet" type="text/css" href="css/main.css">
</head>
<body>
  <div class="title">
    <center> <h1>${requestScope.centerOfInterest.name}<h1> </center>
      <div class="buttonsContainer">
        <button type="button" name="button">-</button>
        <button type="button" name="button">undefined</button>
        <button type="button" name="button">+</button>
      </div>

    </div>
    <div class="container">
      ${requestScope.centerOfInterest.description}
    </div>
  </body>
  </html>
