<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: sylwia
  Date: 09/09/2023
  Time: 22:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
  <title>Login</title>
  <c:import url="head.jsp"></c:import>
</head>
<body class="container-fluid my-custom-bg">
<c:import url="header-out.jsp"></c:import>
<main style="height: 100%; overflow: hidden;">
  <div class="bg-image p-5 text-center shadow-1-strong rounded mb-5 text-light">
    <h1 class="mt-5 mb-4 h1">
      Bienvenue sur MyTicket
      <i class="fas fa-ticket-alt" style="transform: rotate(45deg)"></i>
    </h1>
    <h6 class="text-center">
      Outil de gestion des utilisateurs
    </h6>
  </div>
</main>

<c:import url="footer.jsp"></c:import>
</body>
</html>
