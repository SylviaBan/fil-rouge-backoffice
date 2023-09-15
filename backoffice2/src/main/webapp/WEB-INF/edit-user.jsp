<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: sylwia
  Date: 13/09/2023
  Time: 21:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
  <title>Mise à jour</title>
  <c:import url="head.jsp"></c:import>
</head>
<body class="container my-custom-bg">
<c:import url="header-in.jsp"></c:import>
<main class="my-5">
  <section class="py-5">
    <div class="container">
      <div class="row">
        <div class="col-12 text-center">
          <h3 class="text-light">Ajouter un administrateur</h3>
        </div>
        <c:choose>
        <c:when test="${gameNotFound}">
          <div class="alert alert-danger" role="alert">
            Game not found
          </div>
        </c:when>

        <c:otherwise>
      </div>
      <div class="row justify-content-center">
        <div class="col-12 col-md-6">
          <form method="post" action="${pageContext.request.contextPath}/edit" class="bg-warning p-4 rounded mt-4">
            <div class="mb-3">
              <label class="form-label" for="username">Username :</label>
              <input id="username" class="form-control text-secondary" type="text" name="username"
                     value="<c:out value="${userEdit.getUsername()}" />">
            </div>
            <div class="mb-3">
              <label class="form-label" for="password">Password :</label>
              <input id="password" class="form-control text-secondary" type="password" name="password"
                     value="<c:out value="${userEdit.getPassword()}" />">
            </div>
            <div class="mb-3">
              <label class="form-label" for="phoneNumber">Téléphone :</label>
              <input id="phoneNumber" class="form-control text-secondary" type="tel" name="phoneNumber"
                     value="<c:out value="${userEdit.getPhoneNumber()}" />">
            </div>
            <div class="mb-3">
              <label class="form-label" for="photoUrl">Photo URL :</label>
              <input id="photoUrl" class="form-control text-secondary" type="url" name="photoUrl"
                     value="<c:out value="${userEdit.getPhotoUrl()}" />">
            </div>
            <div class="mb-3">
              <label class="form-label" for="email">E-mail :</label>
              <input id="email" class="form-control text-secondary" type="email" name="email"
                     value="<c:out value="${userEdit.getEmail()}" />">
            </div>

            <div class="text-end">
              <button class="btn btn-success">Edit</button>
              <input type="hidden" name="id" value="${userEdit.id}">
            </div>
          </form>
          </form>
        </div>
      </div>
    </div>
    </c:otherwise>

    </c:choose>
  </section>
</main>
</body>
</html>
