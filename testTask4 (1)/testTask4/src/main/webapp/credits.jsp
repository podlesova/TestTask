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
    <th>Кредитный лимит</th>
    <th>Процент</th>
    <th></th>
  </tr>
<c:forEach items="${credits}" var="credit">
  <tr>
   <td><a href="update/${credit.id}">Изменить запись</a></td>
   <td><c:out value="${credit.limit}" /></td>
   <td><c:out value="${credit.percent}" /></td>
   <td><a href="${credit.id}">Удалить запись</a></td>
  </tr>
 </c:forEach>
 </table>
 <br><br>
   <div>
    <form method="post" action="/credits/" >
   <table>
     <tr>
       <td align="right">Кредитный лимит:</td>
       <td align="left"><input type="text" name="limit"></td>
       <td align="right">Процент:</td>
       <td align="left"><input type="text" name="percent"></td>
     </tr>
   </table>
   <input type="button" value="Добавить"
          onClick="if (isNum(document.forms[0].limit.value) && isNum(document.forms[0].percent.value)) {document.forms[0].submit();} else {window.alert('Значения лимита и процента должны быть числовыми!');}">

   </form>
   </div>
  <br><br>
  <a href="/">На главную</a>
</body>
</html>