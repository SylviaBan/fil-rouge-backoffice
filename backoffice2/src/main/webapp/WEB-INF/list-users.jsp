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
  <title>List of Users</title>
  <c:import url="head.jsp"></c:import>
</head>
<body class="container my-custom-bg">
<c:import url="js-scripts.html"></c:import>
<c:import url="header-in.jsp"></c:import>

<main>
  <section class="py-5">
    <div class="container py-5">
      <h1 class="text-light d-flex justify-content-center mb-5">Liste des utilisateurs</h1>
      <table class="table text-center align-middle">
        <thead>
        <tr class="p-3 mb-2 bg-warning text-dark">
          <th>#</th>
          <th>Username</th>
          <th>Password</th>
          <th>Phone</th>
          <th>Photo</th>
          <th>Email</th>
          <th colspan="4" class="btn-actions">Actions</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${users}" var="user">
          <tr class="text-light">
            <th>${user.getId()}</th>
            <th>${user.getUsername()}</th>
            <td class="text-light">${user.getPassword()}</td>
            <td>${user.getPhoneNumber()}</td>
            <td>${user.getPhotoUrl()}</td>
            <td>${user.getEmail()}</td>
            <td class="td-btn">
              <a class="btn btn-primary"
                 href="${pageContext.request.contextPath}/edit?id=${user.getId()}">Edit</a>
            </td>
            <td class="td-btn">
            <form action="delete" method="POST" class="m-0">
              <button class="btn btn-danger" onclick="confirmDelete(${user.getId()})">
                <span class="material-symbols-outlined">Delete</span>
              </button>
              <input type="hidden" name="id" value="${user.getId()}">
            </form>
            </td>
            <td class="td-checkbox">
              <form action="activateUser" method="POST">
                <input type="hidden" name="id" value="${user.getId()}">
                <input type="checkbox" name="activate" id="activate-${user.getId()}">
                <label for="activate-${user.getId()}" class="checkbox-label-activ">Activer</label>
              </form>
            </td>
            <td class="td-checkbox">
              <form action="deactivateUser" method="POST">
                <input type="hidden" name="id" value="${user.getId()}">
                <input type="checkbox" name="deactivate" id="deactivate-${user.getId()}">
                <label for="deactivate-${user.getId()}" class="checkbox-label-deactiv">Désactiver</label>
              </form>
            </td>
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
