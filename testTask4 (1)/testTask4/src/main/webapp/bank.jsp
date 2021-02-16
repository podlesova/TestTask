<%@ page contentType="text/html;charset=utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<body>


  <div>
       <form method="post" action="/banks/${bank.id}" >
      <table>
        <tr>
          <td align="right">Клиент:</td>
          <td align="left"><select name="id_client">
                           <c:forEach items="${clients}" var="client">
                           <c:choose>
                             <c:when test="${client.id == bank.id_client.id}">
                               <option selected  value="${client.id}"><c:out value="${client.name}" /></option>
                             </c:when>
                             <c:otherwise>
                               <option  value="${client.id}"><c:out value="${client.name}" /></option>
                             </c:otherwise>
                           </c:choose>
                           </c:forEach>
                           </select>
          </td>
          </tr>
          <tr>
          <td align="right">Кредит:</td>
          <td align="left"><select name="id_credit">
                           <c:forEach items="${credits}" var="credit">
                           <c:choose>
                             <c:when test="${credit.id == bank.id_credit.id}">
                              <option selected value="${credit.id}"><c:out value="${credit.limit}"/> - <c:out value="${credit.percent}"/></option>
                             </c:when>
                             <c:otherwise>
                               <option value="${credit.id}"><c:out value="${credit.limit}"/> - <c:out value="${credit.percent}"/></option>
                             </c:otherwise>
                           </c:choose>
                           </c:forEach>
                           </select>
          </td>
        </tr>
      </table>
      <input type="submit" value="Изменить">
      </form>
      </div>
  <br><br>
  <a href="/">На главную</a>
</body>
</html>