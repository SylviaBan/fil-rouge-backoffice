<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: sylwia
  Date: 09/09/2023
  Time: 23:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>List of Admins</title>
  <c:import url="head.jsp"></c:import>
</head>
<body class="container my-custom-bg">
<c:import url="js-scripts.html"></c:import>
<c:import url="header-in.jsp"></c:import>

<main>
  <section class="py-5">
    <div class="container py-5">
      <h1 class="text-light d-flex justify-content-center mb-5">Liste des administrateurs</h1>
      <table class="table text-center align-middle">
        <thead>
        <tr class="p-3 mb-2 bg-warning text-dark">
          <th>#</th>
          <th>Login</th>
          <th>Password</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${admins}" var="admin">
          <tr class="text-light">
            <th>${admin.getId()}</th>
            <th>${admin.getLogin()}</th>
            <td class="text-light">${admin.getPassword()}</td>
          </tr>
        </c:forEach>
        </tbody>
      </table>
    </div>
  </section>
</main>
<c:import url="footer.jsp"></c:import>
</body>
</html>
