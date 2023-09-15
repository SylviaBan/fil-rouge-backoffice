<%--
  Created by IntelliJ IDEA.
  User: sylwia
  Date: 09/09/2023
  Time: 23:06
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<header>
    <!-- 1. La nav barre => la barre de navigation-->
    <nav class="navbar navbar-expand-md my-card-bg fixed-top py-2">
        <!-- 2. Container => pour y définir les div-->
        <div class="container-fluid">
            <a class="navbar-brand" href="https://passetonbillet.fr/">
                <i class="fas fa-ticket-alt fa-3x me-3" style="color: #ffffff;"></i>
            </a>

            <div class="collapse navbar-collapse justify-content-start" id="navbarNav">
                <ul class="navbar-nav">
                    <li class="nav-item col-3 active text-center mx-1">
                        <a class="nav-link bg-primary text-light rounded-3" href="home-admin">Home</a>
                    </li>
                    <li class="nav-item col-3 text-center mx-1">
                        <a class="nav-link bg-warning text-dark rounded-3" href="list">List</a>
                    </li>
                    <li class="nav-item col-3 text-center mx-1">
                        <a class="nav-link bg-warning text-dark rounded-3" href="search">Search</a>
                    </li>
                    <li class="nav-item col-3 text-center mx-1">
                        <a class="nav-link bg-warning text-dark rounded-3" href="add">Add</a>
                    </li>
                </ul>
            </div>
            <div class="collapse navbar-collapse justify-content-end">
                <ul class="navbar-nav">
                    <li class="nav-item bg-primary rounded-3">
                        <a class="nav-link text-light" href="addAdmin">Create admin</a>
                    </li>
                    <li class="nav-item bg-primary rounded-3 mx-2">
                        <a class="nav-link text-light" href="listAdmins">Show admin</a>
                    </li>
                    <li class="nav-item bg-danger rounded-3">
                        <a class="nav-link text-light" href="logout">Logout</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
</header>

