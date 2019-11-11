<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
  <title>Start Page</title>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <link rel="stylesheet" type="text/css" href="/css/main.css">
</head>
<body>
  <div class="title">
    <center> <h1>Centers of interest<h1> </center>
  </div>

  <div>
    <c:forEach var="centerOfInterest" items="${requestScope.centersOfInterest}">
    <div class="container">
      <h2>
        <a href="${pageContext.request.contextPath}/center_of_interest?id=${centerOfInterest.id}">${centerOfInterest.name}</a>
      </h2>
      ${centerOfInterest.description}
    </div>
  </c:forEach>
  </div>

</body>
</html>
