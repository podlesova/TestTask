<%@ page contentType="text/html;charset=utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<body>
<table>
<tr>
<th></th>
  <th>Клиент</th>
  <th>Лимит по кредиту</th>
  <th>Процентная ставка</th>
  <th></th>
  </tr>
<c:forEach items="${banks}" var="bank">
  <tr>
  <td><a href="update/${bank.id}">Изменить запись</a></td>
   <td><c:out value="${bank.id_client.name}" /></td>
   <td><c:out value="${bank.id_credit.limit}" /></td>
   <td><c:out value="${bank.id_credit.percent}" /></td>
   <td><a href="${bank.id}">Удалить запись</a></td>
  </tr>
 </c:forEach>
 </table>
 <br><br>
    <div>
     <form method="post" action="/banks/" >
    <table>
      <tr>
        <td align="right">Клиент:</td>
        <td align="left"><select name="id_client">
                         <c:forEach items="${clients}" var="client">
                           <option selected value="${client.id}"><c:out value="${client.name}" /></option>
                         </c:forEach>
                         </select>
        </td>
        <td align="right">Кредит:</td>
        <td align="left"><select name="id_credit">
                         <c:forEach items="${credits}" var="credit">
                           <option selected value="${credit.id}"><c:out value="${credit.limit}"/> - <c:out value="${credit.percent}"/></option>
                         </c:forEach>
                         </select>
        </td>
      </tr>
    </table>
    <input type="submit" value="Добавить">
    </form>
    </div>
 <br><br>
 <a href="/">На главную</a>
</body>
</html>