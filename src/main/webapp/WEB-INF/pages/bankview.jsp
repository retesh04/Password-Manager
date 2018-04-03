<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body background="key-1013662_960_720.jpg">

	<div class="container">
		<table class="table table-hover">
			<thead>
				<tr>
					<th>id</th>
					<th>userid</th>
					<th>Password</th>
					<th>AccountType</th>
					<th>NameType</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="list" items="${list}">
					<tr>
						<td>${list.id}</td>
						<td>${list.userid}</td>
						<td>${list.password}</td>
						<td>${list.accountType}</td>
						<td>${list.nameType}</td>
						<td><a
							href="${pageContext.request.contextPath}/edit/${list.id}">
								Edit</a><br> <a
							href="${pageContext.request.contextPath}/delete/${list.id}">
								Delete</a><br></td>
					</tr>

				</c:forEach>
			</tbody>
		</table>
	</div>

</body>
</html>