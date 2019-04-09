<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Sberchat</title>

    <link href="${contextPath}/resources/bootstrap/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">

    <div class="row">
        <div class="col-md-4 col-xs-8 col-md-offset-2">
            <h2>Welcome to Sberchat</h2>
        </div>
    </div>
    <c:forEach items="${messages}" var="message">
        <div class="row">
            <div class="col-md-2 col-xs-2 col-md-offset-1"><span class="pull-right">${message.name}:</span></div>
            <div class="col-md-4 col-xs-4">${message.text}</div>
        </div>
    </c:forEach>

    <hr />

    <form action="" method="POST">
        <div class="row">
            <div class="col-md-2 col-xs-2 col-md-offset-1"><span class="pull-right">Name:</span></div>
            <div class="col-md-1 col-xs-1">
                <input type="text" name="name" value="${defaultName}">
            </div>
        </div>
        <div class="row">
            <div class="col-md-2 col-xs-2 col-md-offset-1"><span class="pull-right">Message:<span></div>
            <div class="col-md-4 col-xs-4">
                <textarea rows="3" cols="50" name="text">${defaultMessage}</textarea>
            </div>
        </div>
        <div class="row">
            <div class="col-md-1 col-xs-1 col-md-offset-2">
                <input type="submit" class="btn btn-success" value="Send">
            </div>
        </div>
    </form>

</div>
<!-- /container -->
    <script src="${contextPath}/resources/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>
