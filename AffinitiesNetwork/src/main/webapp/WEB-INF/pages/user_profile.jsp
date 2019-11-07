<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
  <title>Start Page</title>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <link rel="stylesheet" type="text/css" href="css/main.css">
</head>
<body>
  <div class="title">
    <h2> Profile of user: ${user.name} </h2>
  </div>
  <div class="container">
    <h3> Affinities </h3>
    <table class="container">
      <tr>
        <th>Intensity of affinity</th>
        <th>Center Of Interest</th>
      </tr>
      <c:forEach var="affinity" items="${user.affinities}">
        <tr>
          <td>${affinity.intensity}</td>
          <td>${affinity.centerOfInterest.name}</td >
        </tr>
      </c:forEach>
    </table>
  </div>
</body>
