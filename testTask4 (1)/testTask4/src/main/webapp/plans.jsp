<%@ page contentType="text/html;charset=utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<body>
<table border="1">
  <tr>
    <th>Дата платежа</th>
    <th>Сумма платежа</th>
    <th>Сумма гашения тела кредита</th>
    <th>Сумма гашения процентов</th>
  </tr>
<c:forEach items="${plans}" var="plan">
  <tr>
   <td align="center"><c:out value="${plan.date.toString().substring(0,10)}" /></td>
   <td align="center"><c:out value="${plan.totalSum}" /></td>
   <td align="center"><c:out value="${plan.creditBodySum}" /></td>
   <td align="center"><c:out value="${plan.percentBodySum}" /></td>
  </tr>
 </c:forEach>
  <tr>
    <td align="center"></td>
    <td align="center"><b><c:out value="${totalSum}" /></b></td>
    <td align="center"><b><c:out value="${bodySum}" /></b></td>
    <td align="center"><b><c:out value="${percentSum}" /></b></td>
   </tr>
 </table>
  <br><br>
  <a href="/">На главную</a>
</body>
</html>