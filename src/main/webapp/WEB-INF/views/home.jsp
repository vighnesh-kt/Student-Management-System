<!doctype html>
<%@page import="com.staffms.entity.Student"%>
<%@page import="java.util.List"%>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Student Information</title>
<style>
/* Global Styles */
body {
	font-family: 'Roboto', sans-serif;
	background-color: #f5f5f5;
	display: flex;
	justify-content: center;
	align-items: flex-start;
	height: 100vh;
	margin: 0;
	padding: 20px;
}

/* Container Styles */
.container {
	background-color: #fff;
	padding: 2rem;
	border-radius: 0.5rem;
	box-shadow: 0 4px 6px -1px rgba(0, 0, 0, 0.1), 0 2px 4px -1px
		rgba(0, 0, 0, 0.06);
	width: 100%;
	max-width: 800px;
}

.error{
color:red;
}

h1 {
	text-align: center;
	margin-bottom: 1.5rem;
	color: #1a202c;
}

h4 {
	text-align: center;
	color: #4a5568;
}

.table {
	width: 100%;
	margin: 1.5rem 0;
	border-collapse: collapse;
}

.table th, .table td {
	padding: 12px;
	text-align: left;
	border: 1px solid #e2e8f0;
}

.table th {
	background-color: #f7fafc;
}

/* Button Styles */
.btn {
	display: inline-block;
	background-color: #4299e1;
	color: #fff;
	padding: 0.75rem 1rem;
	border: none;
	border-radius: 0.375rem;
	text-decoration: none;
	transition: background-color 0.2s ease-in-out;
	margin-right: 0.5rem;
}

.btn:hover {
	background-color: #3182ce;
}
</style>
</head>
<body>

	<div class="container">
		<h4 class="error">${msg}</h4>
		<h1>Home Page</h1>

		<%
		List<Student> students = (List<Student>) request.getAttribute("students");
		%>

		<table class="table">
			<thead>
				<tr>
					<th scope="col">Name</th>
					<th scope="col">Email</th>
					<th scope="col">Phone</th>
					<th scope="col">Update</th>
					<th scope="col">Delete</th>
				</tr>
			</thead>
			<tbody>
				<%
				for (Student student : students) {
				%>
				<tr>
					<td><%=student.getName()%></td>
					<td><%=student.getEmail()%></td>
					<td><%=student.getPhone()%></td>
					<td><a
						href="<%=request.getContextPath()%>/update?sid=<%=student.getSid()%>">Update</a></td>
					<td><a
						href="<%=request.getContextPath()%>/delete?sid=<%=student.getSid()%>">Delete</a></td>

				</tr>
				<%
				}
				%>
			</tbody>
		</table>
		<a href="email" class="btn btn-primary">Send Email</a>
		 <a href="add"
			class="btn btn-primary">Add</a>

	</div>

</body>
</html>
