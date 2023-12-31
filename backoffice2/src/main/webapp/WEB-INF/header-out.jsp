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
            <div class="collapse navbar-collapse justify-content-start">
                <ul class="navbar-nav">
                    <li class="nav-item active mx-2">
                        <a class="nav-link text-light bg-success rounded btn btn-lg" href="home">Home</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link text-light bg-primary rounded btn btn-lg" href="login">Login</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
</header>

