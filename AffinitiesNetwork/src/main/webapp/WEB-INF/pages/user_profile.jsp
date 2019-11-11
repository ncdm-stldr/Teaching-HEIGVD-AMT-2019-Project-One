<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
  <title>Start Page</title>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <link rel="stylesheet" type="text/css" href="./css/main.css">
</head>
<body>
  <div class="title">
    <h1> <center> Profile of user: ${user.firstName} </center> </h1>
  </div>
  <div class="container">
      <h2> <center> Affinities </center> </h2>
    <table class="container" align="center">
      <tr>
        <th>Intensity of affinity</th>
        <th>Center Of Interest</th>
      </tr>
      <c:forEach var="centerOfInterest" items="${centerOfInterests}">
        <tr>
          <td>${centerOfInterest.name}</td >
        </tr>
      </c:forEach>
    </table>
  </div>
</body>
