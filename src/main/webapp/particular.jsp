<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="uni.iitu.beans.CommentBean" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Post</title>
    <%@include file="head.jsp" %>
</head>
<body>

<jsp:useBean id="post" class="uni.iitu.beans.PostBean" scope="request"/>
<jsp:setProperty name="post" property="*"/>

<%@include file="navbar.jsp" %>
<div class="container py-3 post-c">
    <div class="post">
        <div class="content">
            <p class="h2"><%=post.getUser().getUsername()%></p>
            <div class="topic">
                <p><%=post.getContent()%></p>
            </div>

            <p class="posted-date"><% SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
                String topicDate = format.format(post.getPublishedDate());
                out.print(topicDate); %></p>
        </div>
    </div>

    <% for (CommentBean comment: post.getComments()) { %>
    <div class="comment mt-4">
        <p class="h5"><%=comment.getUser().getUsername()%></p>
        <div class="answer">
            <p><%=comment.getContent()%></p>
        </div>

        <p class="posted-date">
            <%String commentDate = format.format(post.getPublishedDate());
            out.print(commentDate); %></p>
    </div>
    <% } %>
    <div class="comment mt-4">
        <p class="h5">Adil</p>
        <div class="answer">
            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Alias asperiores aut dolorem esse excepturi
                explicabo illum impedit iure laboriosam minus nihil non optio quidem, quisquam, ratione repellat
                reprehenderit sint voluptatem?</p>
        </div>

        <p class="posted-date">05.04.2021</p>
    </div>
    <div class="comment mt-4">
        <p class="h5">Adil</p>
        <div class="answer">
            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Alias asperiores aut dolorem esse excepturi
                explicabo illum impedit iure laboriosam minus nihil non optio quidem, quisquam, ratione repellat
                reprehenderit sint voluptatem?</p>
        </div>

        <p class="posted-date">05.04.2021</p>
    </div>

</div>
</body>
</html>

<style>
    .post {
        height: 200px;
        width: 90%;
        border-radius: 80px;
        margin: 0 auto;
        background-color: white;
    }

    .comment {
        height: 170px;
        width: 70%;
        background-color: white;
        margin: 0 135px;
        padding: 20px;
    }

    .content {
        padding: 15px 80px;
    }

    .answer {
        height: 80px;
        font-size: 15px;
    }

    .topic {
        height: 80px;
        font-size: 22px;
    }

    .posted-date {
        color: #b9b7b2;
    }

    .post-c {
        background-color: #f7f5f0;
        padding-top: 15px;
    }

</style>
