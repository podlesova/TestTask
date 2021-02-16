<%@ page contentType="text/html;charset=utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<body>

  <div>
   <form method="post" name="form2" action="/clients/${client.id}" >
  <table>
    <tr>
      <td align="right">Имя:</td>
      <td align="left"><input type="text" name="name" value="${client.name}"></td>
    </tr>
    <tr>
      <td align="right">Электронный адрес:</td>
      <td align="left"><input type="text" name="email" value="${client.email}"></td>
    </tr>
    <tr>
      <td align="right">Пасспорт:</td>
      <td align="left"><input type="text" name="passport" value="${client.passport}"></td>
    </tr>
    <tr>
      <td align="right">Телефон:</td>
      <td align="left"><input type="text" name="phone" value="${client.phone}"></td>
    </tr>
  </table>
  <input type="button" value="Изменить"
         onClick="if ((document.form2.name.value == '')||(document.form2.passport.value == '')||(document.form2.phone.value == ''))  {window.alert('Имя, пасспорт и телефон должны быть заполнены!');} else {document.form2.submit();}">

  </form>
  </div>
  <br><br>
  <a href="/">На главную</a>
</body>
</html>