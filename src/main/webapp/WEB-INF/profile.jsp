<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Your Profile" />
    </jsp:include>
</head>
<body>
    <jsp:include page="/WEB-INF/partials/navbar.jsp" />

    <div class="container">
        <h1>Welcome, ${sessionScope.user.username}!</h1>
    </div>
    <div class="container">
        <h1>Here are your current ad listings!</h1>

        <c:forEach var="ad" items="${ads}">
            <div class="col-md-5">
                <h2>${ad.title}</h2>
                <p>${ad.description}</p>
                <form action="profile" method="post">
                    <button type="submit" name="deleteUpdate" value="delete-${ad.id}">Delete</button>
                    <button type="submit" name="deleteUpdate" value="update">Update</button>
                </form>
            </div>
        </c:forEach>
    </div>

</body>
</html>
