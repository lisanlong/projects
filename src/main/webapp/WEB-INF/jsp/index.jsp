<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<title>测试jsp</title>

<h3>标签 c:if</h3>
<c:if test="${username !=null}">
<p>用户名为：${username}<p>
</c:if>

<h3>标签 c:choose</h3>
<c:choose>
    <c:when test="${salary <= 0}">
        太惨了。
    </c:when>
    <c:when test="${salary > 1000}">
        不错的薪水，还能生活。
    </c:when>
    <c:otherwise>
        什么都没有。
    </c:otherwise>
</c:choose>