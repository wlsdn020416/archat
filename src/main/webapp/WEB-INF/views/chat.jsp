<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>ChatBot</title>
</head>
<body>


    <section>
        <c:forEach var ="chat" items = "chats">
            <div>
                <ul>
                    <li><strong>${chat.owner}</strong></li>
                    <li> 모델 : ${chat.model}</li>
                    <li> ${chat.message}</li>
                    <li> 작성일시 : ${chat.timestamp}</li>
                </ul>
            </div>
        </c:forEach>
    </section>
</body>
</html>
