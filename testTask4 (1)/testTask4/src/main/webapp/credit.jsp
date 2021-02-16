<%@ page contentType="text/html;charset=utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<body>
<script type="text/javascript">
   function isNum(input) {
      return (input - 0) == input && (''+input).trim().length > 0;
   }
</script>
  <div>
   <form method="post" name="form2" action="/credits/${credit.id}" >
  <table>
    <tr>
      <td align="right">Кредитный лимит:</td>
      <td align="left"><input type="text" name="limit" value="${credit.limit}"></td>
    </tr>
    <tr>
      <td align="right">Процентная ставка:</td>
      <td align="left"><input type="text" name="percent" value="${credit.percent}"></td>
    </tr>
  </table>
 <input type="button" value="Изменить"
           onClick="if (isNum(document.forms[0].limit.value) && isNum(document.forms[0].percent.value)) {document.forms[0].submit();} else {window.alert('Значения лимита и процента должны быть числовыми!');}">

  </form>
  </div>
  <br><br>
  <a href="/">На главную</a>
</body>
</html>