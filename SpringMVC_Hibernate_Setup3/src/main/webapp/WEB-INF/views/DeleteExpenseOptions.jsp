<%@page import="com.rs.fer.entity.Expense"%>
<%@ page import="java.util.List" %>
<%@ page import ="java.io.IOException"%>


<jsp:include page="Layout/HeaderAndLeftFrame.jsp"/>

<script>
function validate(){
	if (document.getElementById("expenseId").vlaue==""){
		
		var errDivId = document.getElementById('errDivId');
		errDivId.innerHTML= 'please select value';
		err.DivId.style.display='';
		
	}else{
		submitForm('deleteExpense');
	}
}

</script>

<%
		
		List<Expense> expenses = (List<Expense>) session.getAttribute("expenses");
		
		 if(expenses==null || expenses.isEmpty())
		 {
			 out.println("No Expenses Found");
		 }else
		 {
			 	out.println("Expense ID:");
			 
			 	out.println("<select name='expenseId'>");
			
			 	out.println("<option value=''>Please select ExpenseID</option>");
			
			 	int value=0;
			 	
			 	String description=null;
			 
				for(Expense expense:expenses)
				{
					value=expense.getExpenseId();
					description=expense.getType()+","+expense.getDate()+","+expense.getTotal()+"and"+expense.getByWhom();
					
					out.println("<option value='" + value + "'>" + description + "</option>");
				}
				out.println("</select>");
				out.println("<input type='button' value='Delete' onclick=\"javascript: submitForm('deleteExpense')\">");
			} 
 %>
<jsp:include page="Layout/Footer.jsp"/>
