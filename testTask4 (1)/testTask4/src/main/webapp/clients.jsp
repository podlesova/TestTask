<%@ page contentType="text/html;charset=utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<body>

<table>
  <tr>
    <th></th>
    <th>Имя</th>
    <th>Электронная почта</th>
    <th>Паспорт</th>
    <th>Телефон</th>
    <th></th>
  </tr>
<c:forEach items="${clients}" var="client">
  <tr>
  <td><a href="update/${client.id}">Изменить запись</a></td>
   <td><c:out value="${client.name}" /></td>
   <td><c:out value="${client.email}" /></td>
   <td><c:out value="${client.passport}" /></td>
   <td><c:out value="${client.phone}" /></td>
   <td><a href="${client.id}">Удалить запись</a></td>
  </tr>
 </c:forEach>
 </table>

  <br><br>
  <div>
   <form method="post" name="form2" action="/clients/" >
  <table>
    <tr>
      <td align="right">Имя:</td>
      <td align="left"><input type="text" name="name"></td>
      <td align="right">Электронный адрес:</td>
      <td align="left"><input type="text" name="email"></td>
    </tr>
    <tr>
      <td align="right">Пасспорт:</td>
      <td align="left"><input type="text" name="passport"></td>
      <td align="right">Телефон:</td>
      <td align="left"><input type="text" name="phone"></td>
    </tr>
  </table>
  <input type="button" value="Добавить"
         onClick="if ((document.form2.name.value == '')||(document.form2.passport.value == '')||(document.form2.phone.value == ''))  {window.alert('Имя, пасспорт и телефон должны быть заполнены!');} else {document.form2.submit();}">

  </form>
  </div>
  <br><br>
  <a href="/">На главную</a>
</body>
</html>