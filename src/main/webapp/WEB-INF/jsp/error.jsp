<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Something Went Wrong</title>
    <style>
        body {
            font-family: "Trebuchet MS", Arial, sans-serif;
            background: radial-gradient(circle at top, #fff2f2, #f7f7ff);
            margin: 0;
            padding: 24px;
        }
        .container {
            max-width: 640px;
            margin: 0 auto;
            background: #ffffff;
            padding: 24px;
            border-radius: 12px;
            box-shadow: 0 10px 30px rgba(0, 0, 0, 0.08);
        }
        h1 {
            margin: 0 0 12px;
            color: #c0392b;
        }
        p {
            color: #333;
            margin: 0 0 16px;
        }
        a {
            color: #2f5dff;
            text-decoration: none;
            font-weight: 600;
        }
    </style>
</head>
<body>
<div class="container">
    <h1>Request Error</h1>
    <p><c:out value="${message}" /></p>
    <a href="<c:url value='/menu' />">Back to menu list</a>
</div>
</body>
</html>
