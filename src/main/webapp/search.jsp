<%--<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>--%>
<%--<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>--%>
<%--<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>--%>
<%--<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>--%>
<%--<%@ page session="false" %>--%>

<%--<html>--%>
<%--<head>--%>
    <%--<title>Search</title>--%>

    <%--<style type="text/css">--%>
        <%--.tg {--%>
            <%--border-collapse: collapse;--%>
            <%--border-spacing: 0;--%>
            <%--border-color: #ccc;--%>
        <%--}--%>

        <%--.tg td {--%>
            <%--font-family: Arial, sans-serif;--%>
            <%--font-size: 14px;--%>
            <%--padding: 10px 5px;--%>
            <%--border-style: solid;--%>
            <%--border-width: 1px;--%>
            <%--overflow: hidden;--%>
            <%--word-break: normal;--%>
            <%--border-color: #ccc;--%>
            <%--color: #333;--%>
            <%--background-color: #fff;--%>
        <%--}--%>

        <%--.tg th {--%>
            <%--font-family: Arial, sans-serif;--%>
            <%--font-size: 14px;--%>
            <%--font-weight: normal;--%>
            <%--padding: 10px 5px;--%>
            <%--border-style: solid;--%>
            <%--border-width: 1px;--%>
            <%--overflow: hidden;--%>
            <%--word-break: normal;--%>
            <%--border-color: #ccc;--%>
            <%--color: #333;--%>
            <%--background-color: #f0f0f0;--%>
        <%--}--%>

        <%--.tg .tg-4eph {--%>
            <%--background-color: #f9f9f9--%>
        <%--}--%>
    <%--</style>--%>
<%--</head>--%>
<%--<body>--%>
<%--<a href="index.jsp">Back to main menu</a>--%>

<%--<br/>--%>
<%--<br/>--%>

<%--<h1>Search</h1>--%>


<form:form  commandName="userModel" method="POST" action="/find">
    <table>
         <tr>
            <td>
                <form:label path="name">
                    <spring:message text="Name"/>
                </form:label>
            </td>
            <td>
                <form:input path="name"/>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="<spring:message text="Search User"/>"/>
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <title>Spring MVC Form Handling</title>
</head>
<body>

<h2>Student Information</h2>
<form:form method="POST" action="/find">
    <table>
        <tr>
            <td><form:label path="name">Name</form:label></td>
            <td><form:input path="name" /></td>
        </tr>

        <tr>
            <td colspan="2">
                <input type="submit" value="Submit"/>
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>
