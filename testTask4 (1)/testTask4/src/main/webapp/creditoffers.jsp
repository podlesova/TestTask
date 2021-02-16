<%@ page contentType="text/html;charset=utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<body>
<script type="text/javascript">
   function isNum(input) {
      return (input - 0) == input && (''+input).trim().length > 0;
   }

</script>
<table>
  <tr>
    <th></th>
    <th>Имя клиента</th>
    <th>Кредитный лимит</th>
    <th>Процент</th>
    <th>Сумма кредита</th>
    <th></th>
  </tr>
<c:forEach items="${creditoffers}" var="creditoffer">
  <tr>
   <td><a href="/plans/${creditoffer.id}">График платежей</a></td>
   <td><c:out value="${creditoffer.client.name}" /></td>
   <td><c:out value="${creditoffer.credit.limit}" /></td>
   <td><c:out value="${creditoffer.credit.percent}" /></td>
   <td><c:out value="${creditoffer.creditSum}" /></td>
   <td ><a href="${creditoffer.id}">Удалить запись</a></td>
  </tr>
 </c:forEach>
 </table>
 <br><br>
     <div>
     <font color="red"><c:out value="${error}" /></font>
     <form method="post" action="/creditoffers/" >
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
         <td align="right">Сумма:</td>
         <td align="left"><input type="text" name="sum"></td>
         <td align="right">Срок погашения (месяцев):</td>
         <td align="left"><input type="text" name="months"></td>
       </tr>
     </table>
     <input type="button" value="Добавить"
       onClick="if (isNum(document.forms[0].sum.value) && isNum(document.forms[0].months.value)) {document.forms[0].submit();} else {window.alert('Значения суммы и срока должны быть числовыми!');}">

     </form>
     </div>
  <br><br>
  <a href="/">На главную</a>
</body>
</html>