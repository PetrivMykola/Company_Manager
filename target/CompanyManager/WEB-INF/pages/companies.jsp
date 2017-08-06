<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>
<html>
<head>
    <title>Books Page</title>
</head>
<body>
<a href="../../index.jsp">Back to main menu</a>

<br/>
<br/>

<h1>Company List</h1>

<c:if test="${!empty listCompanies}">
    <table class="tg">

        <c:forEach items="${listCompanies}" var="company">
            <tr>
                <td>${company.id}</td>
                <td><a href="/companydata/${company.id}" target="_blank">${company.name}</a></td>
                <td>${company.name}</td>
                <td><a href="<c:url value='/edit/${company.id}'/>">Edit</a></td>
                <td><a href="<c:url value='/remove/${company.id}'/>">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>


<h1>Add a Company</h1>

<c:url var="addAction" value="/companies/add"/>

<form:form action="${addAction}" commandName="company">
    <table>
        <c:if test="${!empty company.companyName}">
            <tr>
                <td>
                    <form:label path="id">
                        <spring:message text="ID"/>
                    </form:label>
                </td>

            </tr>
        </c:if>
        <tr>
            <td>
                <form:label path="companyName">
                    <spring:message text="Title"/>
                </form:label>
            </td>
            <td>
                <form:input path="companyName"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="companyEarnings">
                    <spring:message text="Author"/>
                </form:label>
            </td>
            <td>
                <form:input path="companyEarnings"/>
            </td>
        </tr>

        <tr>
            <td colspan="2">
                <c:if test="${!empty company.companyName}">
                    <input type="submit"
                           value="<spring:message text="Edit Book"/>"/>
                </c:if>
                <c:if test="${empty company.companyName}">
                    <input type="submit"
                           value="<spring:message text="Add Company"/>"/>
                </c:if>
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>