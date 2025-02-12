<h2>Welcome In the Spirng</h2>

<%@ page import="com.nt.model.Employee" %>


<%
    // Assume the Employee object is provided in the request scope
    //Example: request.setAttribute("emp", employeeObject);
    Employee emp1 = (Employee) request.getAttribute("emp");
%>

<!-- java.util.List employees = (java.util.List) request.getAttribute("empReport");
 -->

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page isELIgnored="false"%>



 <title>Search Data Dynamically</title>
    <style>
        h1 {
            color: blue;
            text-align: center;
        }
        table {
            margin: 0 auto;
            background-color: cyan;
        }
    </style>
</head>
<body>
    <h1>Search Data Dynamically</h1>
    <!-- The form submits to a Servlet -->
    <form action="search" method="post">
        <table>
            <tr>
                <td>emp name ::</td>
                <td><input type="text" name="ename" value="<%= request.getParameter("ename") != null ? request.getParameter("ename") : "" %>" /></td>
            </tr>
            <tr>
                <td>emp job ::</td>
                <td><input type="text" name="job" value="<%= request.getParameter("job") != null ? request.getParameter("job") : "" %>" /></td>
            </tr>
            <tr>
                <td>emp salary ::</td>
                <td><input type="text" name="sal" value="<%= request.getParameter("sal") != null ? request.getParameter("sal") : "" %>" /></td>
            </tr>
            <tr>
                <td>emp dept no ::</td>
                <td>
                
             <select name="deptno" multiple>
                        <option value="">--select dept--</option>
                        <option value="10" <%= "10".equals(request.getParameter("deptno")) ? "selected" : "" %>>10</option>
                        <option value="20" <%= "20".equals(request.getParameter("deptno")) ? "selected" : "" %>>20</option>
                        <option value="30" <%= "30".equals(request.getParameter("deptno")) ? "selected" : "" %>>30</option>
                    </select>  
                
                
<%-- <select name="deptno[]" multiple>
    <option value="">--select dept--</option>
    <option value="10" <%= "10".equals(request.getParameter("deptno")) ? "selected" : "" %>>10</option>
    <option value="20" <%= "20".equals(request.getParameter("deptno")) ? "selected" : "" %>>20</option>
    <option value="30" <%= "30".equals(request.getParameter("deptno")) ? "selected" : "" %>>30</option>
</select>
 --%>
<%--                 
<    <select name="deptno[]" multiple>
    <option value="">--select dept--</option>
    <option value="10" <%= request.getParameterValues("deptno") != null && Arrays.asList(request.getParameterValues("deptno")).contains("10") ? "selected" : "" %>>10</option>
    <option value="20" <%= request.getParameterValues("deptno") != null && Arrays.asList(request.getParameterValues("deptno")).contains("20") ? "selected" : "" %>>20</option>
    <option value="30" <%= request.getParameterValues("deptno") != null && Arrays.asList(request.getParameterValues("deptno")).contains("30") ? "selected" : "" %>>30</option>
</select>  --%>

                
                </td>
            </tr>
            <tr>
                <td colspan="2" style="text-align: center;">
                    <input type="submit" value="Search with Data" />
                    <input type="reset" value="Cancel" />
                </td>
            </tr>
        </table>
    </form>
    <hr><hr><br>
<br><br>


<h1 style="color: gray;">Employee</h1>

<%
    // Assuming `empReport` is passed as a request attribute
    java.util.List employees = (java.util.List) request.getAttribute("empReport");
%>

<% if (employees != null && !employees.isEmpty()) { %>
    <h1 style="color:red;text-align: center;">Employees Report</h1>
    <table border="1" align="center" bgcolor="cyan">
        <tr style="color: red">
            <th>empno</th>
            <th>ename</th>
            <th>job</th>
            <th>salary</th>
            <th>deptno</th>
        </tr>
        <%
            for (Object obj : employees) {
                // Assuming each employee is a bean with getters like getEmpno(), getEname(), etc.
                Employee emp = (Employee) obj;
        %>
        <tr style="color: blue">
            <td><%= emp.getEmpno() %></td>
            <td><%= emp.getEname() %></td>
            <td><%= emp.getJob() %></td>
            <td><%= emp.getSal() %></td>
            <td><%= emp.getDeptno() %></td>
            
            <td>
            
      <%--   <%
    // Assume emp is set as a request attribute earlier in the code
    // Example: request.setAttribute("emp", emp);
    Employee emp = (Employee) request.getAttribute("emp");
%> --%>

<a href="edit?no=<%= emp.getEmpno() %>">Edit</a>
<a href="delete?no=<%= emp.getEmpno() %>" onclick="return confirm('Do you wnat delete the Employee')">Delete</a>


            </td>
        </tr>
        <% } %>
    </table>
<% } else { %>
    <h1 style="color: blue;text-align: center;">Employee Not Found</h1>
<% } %>

<h1 style="color: green; text-align: center">${resultMsg}</h1>

<h2 style="color: fuchsia;"> <a href="./">home</a></h2>
<h2 style="color: blue;"> <a href="./register">add Employee</a></h2>

