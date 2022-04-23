<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
  
<h1>product List</h1>  
<table border="2" width="70%" cellpadding="2">  
<tr><th>Id</th><th>Name</th><th>Salary</th><th>Date</th><th>Edit</th></tr>  
   <c:forEach var="product" items="${list}">   
   <tr>  
   <td>${product.id}</td>  
   <td>${product.name}</td>  
   <td>${product.price}</td>  
   <td>${product.date}</td>  
   <td><a href="editproduct/${product.id}">Edit</a></td>  
   </tr>  
   </c:forEach>  
   </table>  
   <br/>  
   <a href="productform">Add New product</a>  