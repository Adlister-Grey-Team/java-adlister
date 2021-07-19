<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
    boolean isNotLoggedIn;
    if (request.getSession().getAttribute("user") == null) {
        isNotLoggedIn = true;
    } else {
        isNotLoggedIn = false;
    }
%>

<nav class="navbar navbar-default">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <a class="navbar-brand" href="/ads">Adlister</a>
            <form action="/searchAds" method="post">
                <input type="text" id="search" name="search">
                <input type="submit" value="Search Ads">
            </form>
            <form action="#" method="post">
                <label for="selector">Categories</label>
                <select name="category" id="selector">
                    <option value="0">--Choose Category--</option>
                    <option value="1">Automotive</option>
                    <option value="2">Beauty and Health</option>
                    <option value="3">Books</option>
                    <option value="4">Clothing</option>
                    <option value="5">Computers</option>
                    <option value="6">Electronic</option>
                    <option value="7">Home and Garden</option>
                    <option value="8">Movies, Music, Games</option>
                    <option value="9">Outdoors</option>
                    <option value="10">Pets</option>
                    <option value="11">Sports</option>
                </select>
                <button type="submit">Search</button>
            </form>
        </div>
        <ul class="nav navbar-nav navbar-right">
            <c:choose>
                <c:when test="<%=isNotLoggedIn%>">
                    <li><a href="/login">Login</a></li>
                    <li><a href="/register">Register</a></li>
                </c:when>
                <c:otherwise>
                    <li><a href="/ads/create">Create Ad</a></li>
                    <li><a href="/profile">View Profile</a></li>
                    <li><a href="/updateProfile">Edit Profile</a></li>
                    <li><a href="/logout">Logout</a></li>
                </c:otherwise>
            </c:choose>
        </ul>
    </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>
