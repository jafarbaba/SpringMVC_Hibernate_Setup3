<%@page import="com.rs.fer.entity.Expense"%>
<%@ page import="java.util.List" %>
<%@ page import ="java.io.IOException"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<jsp:include page="Layout/HeaderAndLeftFrame.jsp"/>

<%
		List<Expense> expenses = (List<Expense>) session.getAttribute("expenses");
		
		 if(expenses==null || expenses.isEmpty())
		 {
			 out.println("No Expenses Found");
		 }
 %>
 
 <table border="1">
 <tr>
 <td>Expense Id</td>
 <td>Expense Type</td>
 <td>Date</td>
 <td>Price</td>
 <td>Number of Items</td>
 <td>Total</td>
 <td>ByWhom</td>
 </tr>
 <c:forEach var="expense" items="${expenses}">
 <tr>
 <td>${expense.expenseId}</td>
 <td>${expense.type}</td>
 <td>${expense.date}</td>
 <td>${expense.price}</td>
 <td>${expense.numberOfItems}</td>
 <td>${expense.total}</td>
  <td>${expense.byWhom}</td>
</tr>
</c:forEach> 
 </table>
 
<jsp:include page="Layout/Footer.jsp"/>
