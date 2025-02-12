<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<h1 style="color: red; text-align: center">Register Employee</h1>

<form method="post">
    <table align="center" bgcolor="cyan">
        <tr>
            <td>Employee Name:</td>
            <td><input type="text" name="ename" required /></td>
        </tr>
<!-- deptno,ename,job,sal,empno
         --><tr>
            <td>Employee Job:</td>
            <td><input type="text" name="job" required /></td>
        </tr>

        <tr>
            <td>Employee Salary:</td>
            <td><input type="number" name="sal" required /></td>
        </tr>

        <tr>
            <td>Employee Dept No:</td>
            <td><input type="number" name="deptno" required /></td>
        </tr>

        <tr>
            <td colspan="2" style="text-align: center;">
                <input type="submit" value="Submit" />
                <input type="reset" value="Cancel" />
            </td>
        </tr>
    </table>
</form>

<h2><a href="report">Employee Report</a></h2>
