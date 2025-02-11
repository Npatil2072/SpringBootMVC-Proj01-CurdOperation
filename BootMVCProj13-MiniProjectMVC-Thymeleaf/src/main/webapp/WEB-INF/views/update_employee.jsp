<%@ page import="com.nt.model.Employee" %>

<%
    // Assume the Employee object is provided in the request scope
    //Example: request.setAttribute("emp", employeeObject);
    Employee emp = (Employee) request.getAttribute("emp");
%>

<!DOCTYPE html>
<html>
<head>
    <title>Update Employee</title>
    <style>
        h1 {
            color: red;
            text-align: center;
        }
        table {
            margin: auto;
            background-color: cyan;
        }
    </style>
</head>
<body>
    <h1>Update Employee</h1>
    <form action="edit" method="post">
        <table>
            <tr>
                <td>Employee Number:</td>
                <td><input type="text" name="empno" value="<%= emp.getEmpno() %>" readonly="true"></td>
            </tr>
            <tr>
                <td>Employee Name:</td>
                <td><input type="text" name="ename" value="<%= emp.getEname() %>"></td>
            </tr>
            <tr>
                <td>Employee Designation:</td>
                <td><input type="text" name="job" value="<%= emp.getJob() %>"></td>
            </tr>
            <tr>
                <td>Employee Salary:</td>
                <td><input type="text" name="sal" value="<%= emp.getSal() %>"></td>
            </tr>
            <tr>
                <td>Department Number:</td>
                <td><input type="text" name="deptno" value="<%= emp.getDeptno() %>"></td>
            </tr>
            <tr>
                <td><input type="submit" value="submit"></td>
                <td><input type="reset" value="Cancel"></td>
            </tr>
        </table>
    </form>
</body>
</html>
