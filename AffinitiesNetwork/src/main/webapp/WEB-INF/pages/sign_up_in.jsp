<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
  <title>Start Page</title>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <link rel="stylesheet" type="text/css" href="./css/main.css">
</head>
<body>

<form method="POST" action="./sign_in_up">
  <div class="container">
    <h1>Sign Up</h1>
    <p>Please fill in this form to sign in / create an account.</p>
    <hr>

    <label for="email"><b>Email</b></label>
    <input type="text" placeholder="Enter Email" name="username" required>

    <label for="psw"><b>Password</b></label>
    <input type="password" placeholder="Enter Password" name="psw" required>

    <div class="clearfix">
      <button type="submit" class="signup_signin_btn">Sign up/Sign in</button>
    </div>
    
    <c:if test="${badLogin != null}">
        <p class="errorMessage"> invalid credentials </p>
    </c:if>
    
  </div>
</form>

</body>
</html>
