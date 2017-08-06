<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h1>Company List</h1>
<table border="2" width="70%" cellpadding="2">
    <tr><th>Id</th><th>Name</th><th>Earnings</th><th>Edit</th><th>Delete</th></tr>
    <c:forEach var="company" items="${listCompanies}">
        <tr>
            <td>${company.id}</td>
            <td>${company.companyName}</td>
            <td>${company.companyEarnings}</td>

            <td><a href="edit/${company.id}">Edit</a></td>
            <td><a href="remove/${company.id}">Delete</a></td>
        </tr>
    </c:forEach>
</table>
<br/>
<a href="companies/add">Add New Company</a>