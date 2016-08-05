<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>
<html>
<head>
  <title>Books Page</title>

  <style type="text/css">
    .tg {
      border-collapse: collapse;
      border-spacing: 0;
      border-color: #ccc;
    }

    .tg td {
      font-family: Arial, sans-serif;
      font-size: 14px;
      padding: 10px 5px;
      border-style: solid;
      border-width: 1px;
      overflow: hidden;
      word-break: normal;
      border-color: #ccc;
      color: #333;
      background-color: #fff;
    }

    .tg th {
      font-family: Arial, sans-serif;
      font-size: 14px;
      font-weight: normal;
      padding: 10px 5px;
      border-style: solid;
      border-width: 1px;
      overflow: hidden;
      word-break: normal;
      border-color: #ccc;
      color: #333;
      background-color: #f0f0f0;
    }

    .tg .tg-4eph {
      background-color: #f9f9f9
    }
  </style>
</head>
<body>
<br/>
<a href="../../index.jsp">Back to main menu</a>
<br/><br/>
<a href="user-get-name-form.html">Find user by name</a>
<br/>
<h2>List of users</h2>

<display:table id="user" name="listUsers" requestURI="/users" pagesize="4" class="tg" decorator="com.malikov.TableWrapper" >
  <display:column property="id" title="ID" sortable="false"/>
  <display:column property="name" title="Name" sortable="false"/>
  <display:column property="age" title="Age" sortable="false"/>
  <display:column property="admin" title="is Admin" sortable="false"/>
  <display:column property="createDate" title="Date" sortable="false"/>
  <display:column property="linkEdit" title="Edit" />
  <display:column property="linkDelete" title="Delete" />
</display:table>

<h2>Add/Edit a user</h2>

<c:url var="addAction" value="/users/add"/>
<form:form action="${addAction}" commandName="user">
  <table>
    <c:if test="${!empty user.name}">
      <tr>
        <td>
          <form:label path="id">
            <spring:message text="ID"/>
          </form:label>
        </td>
        <td>
          <form:input path="id" readonly="true" size="8" disabled="true"/>
          <form:hidden path="id"/>
        </td>
      </tr>
    </c:if>
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
      <td>
        <form:label path="age">
          <spring:message text="Age"/>
        </form:label>
      </td>
      <td>
        <form:input path="age"/>
      </td>
    </tr>
    <tr>
      <td>
        <form:label path="isAdmin">
          <spring:message text="isAdmin"/>
        </form:label>
      </td>
      <td>
        <form:input path="isAdmin"/>
      </td>
    </tr>
    <tr>
      <td colspan="2">
        <input type="submit" value="<spring:message text="Submit"/>"/>
      </td>
    </tr>
  </table>
</form:form>

</body>
</html>
<br/>
</body>
</html>
