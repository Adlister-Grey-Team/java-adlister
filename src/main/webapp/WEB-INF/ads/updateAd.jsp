<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Update Ad" />
    </jsp:include>
</head>
<body>
<div class="container">
    <h1>Update your Ad</h1>
<c:forEach var="ad" items="${selectedAd}">
    <form action="/updateAd" method="post">
        <div class="form-group">
            <label for="title">Title</label>
            <input id="title" name="title" class="form-control" type="text" value="${ad.title}">
        </div>
        <div class="form-group">
            <label for="description">Description</label>
            <textarea id="description" name="description" class="form-control" type="text" placeholder="${ad.description}">${ad.description}</textarea>
        </div>
        <div class="form-group">
            <label>Categories</label><br>
            <label for="automotive">Automotive</label>
            <input id="automotive" type="checkbox" name="checkbox" value="1">
            <label for="beauty_health">Beauty and Health</label>
            <input id="beauty_health" type="checkbox" name="checkbox" value="2">
            <label for="books">Books</label>
            <input id="books" type="checkbox" name="checkbox" value="3">
            <label for="clothing">Clothing</label>
            <input id="clothing" type="checkbox" name="checkbox" value="4">
            <label for="computers">Computers</label>
            <input id="computers" type="checkbox" name="checkbox" value="5">
            <label for="electronics">Electronics</label>
            <input id="electronics" type="checkbox" name="checkbox" value="6">
            <label for="home_garden">Home and Garden</label>
            <input id="home_garden" type="checkbox" name="checkbox" value="7">
            <label for="movies_music_games">Movies, Music, Games</label>
            <input id="movies_music_games" type="checkbox" name="checkbox" value="8">
            <label for="outdoors">Outdoors</label>
            <input id="outdoors" type="checkbox" name="checkbox" value="9">
            <label for="pets">Pets</label>
            <input id="pets" type="checkbox" name="checkbox" value="10">
            <label for="sports">Sports</label>
            <input id="sports" type="checkbox" name="checkbox" value="11">
        </div>
        <input type="submit" class="btn btn-block btn-primary">
    </form>
</c:forEach>
</div>
</body>
</html>
