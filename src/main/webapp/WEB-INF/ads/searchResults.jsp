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
    <h1><c:out value="${result}\"${search}\"" /></h1>
    <c:forEach var="ad" items="${ads}">
        <div class="col-md-6">
            <h2><c:out value="${ad.title}" /></h2>
            <p><c:out value="${ad.description}" /></p>
            <c:forEach var="cat" items="${cats}">
                <c:if test="${ad.id==cat.ad_id}">
                    <p>${cat.category}</p>
                </c:if>
            </c:forEach>
        </div>
    </c:forEach>


</div>

</body>
</html>
