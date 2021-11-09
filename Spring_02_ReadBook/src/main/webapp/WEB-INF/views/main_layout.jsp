<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tilse" uri="http://tiles.apache.org/tags-tiles" %>
<c:set var="rootPath" value="${pageContext.request.contextPath}"/>

<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0">
    <script src="https://code.jquery.com/jquery-latest.min.js"></script>
    <link href="${rootPath}/static/css/main.css?ver=0006" rel="stylesheet" />

    <title>독서록</title>
</head>
<body>
    <tilse:insertAttribute name="header"/>

    <section class="content">
        <tilse:insertAttribute name="content"/>
    </section>

    <tiles:insertAttribute name="footer"/>

</body>
</html>
