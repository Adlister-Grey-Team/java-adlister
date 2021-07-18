<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Viewing All The Ads"/>
    </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp"/>

<div class="container">
    <h1 class="text-center title">Advertisements git add<a href="/ads/create">
        <button id="create"></button>
    </a></h1>
    </h1>

    <c:forEach var="ad" items="${ads}">
        <a href="/ads/show?id=${ad.id}">
            <div>
                <div>
                    <h2>
                        <p><c:out value="${ad.title} - ${ad.user.username}"/></p>
                        <p>Category Type: <em><c:out value="${ad.category.classification}"/></em></p>
                    </h2>

                    <c:if test="${(sessionScope.user.id == ad.userId)}">
                        <div>
                            <form action="/ads/delete" method="post">
                                <div class="form-group">
                                    <input type="hidden" name="id" class="form-control" value="${ad.id}">
                                    <span>
                                        <button id="delete">
                                        </button>
                                    </span>
                                </div>
                            </form>
                            <form action="/ads/update" method="get" id="ads-update">
                                <div class="form-group">
                                    <input type="hidden" name="id" class="form-control" value="${ad.id}">
                                    <span>
                                    <button id="update">
                                    </button>
                                </span>
                                </div>
                            </form>
                        </div>
                    </c:if>
                </div>

                    <div>
                        <div>
                            <p><c:out value="${ad.description}"/></p>
                            <p> - <c:out value="${ad.user.firstname}"/></p>
                        </div>
                    </div>
                </div>
            </a>
    </c:forEach>
</div>


</body>
</html>


