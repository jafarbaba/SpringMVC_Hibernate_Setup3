<%@page import="com.rs.fer.vo.EditExpenseVo"%>
<%@page import="java.util.List"%>
<%@page import="java.io.IOException" %>
  
  <%
   EditExpenseVo expense= (EditExpenseVo)session.getAttribute("editExpenseVo"); 
  %>
  
	<jsp:include page="Layout/HeaderAndLeftFrame.jsp"/>
	
		<script> 
			
			function validateForm()
			{
				var form=document.DashboardForm;
				var errorMessages="";
				
				if(form.expenseType.value.trim()=="")
					{
					 	errorMessages+="Pease Enter expensetype<BR>";
					}
				if(form.Date.value.trim()=="")
					{
						errorMessages+="Please Enter date<BR>";
					}	   
				if(form.Price.value.trim()=="")
				{
					errorMessages+="Please Enter Price<BR>";
				}	   
				if(form.NoOfItems.value.trim()=="")
				{
					errorMessages+="Please Enter noOfItems<BR>";
				}	   
				if(form.Total.value.trim()=="")
				{
					errorMessages+="Please Enter total<BR>";
				}	   
				if(form.ByWhom.value.trim()=="")
				{
					errorMessages+="Please Enter byWhom<BR>";
				}	   
				if(errorMessages!="")
				   {
					    //	alert(errorMessages);
					    var errorTdId=document.getElementById('errorTdId');
					    errorTdId.innerHTML=errorMessages;
					    
					    var errorTrId=document.getElementById('errorTrId');
					    errorTrId.style.display="";
				   }
			   else
				   {
				   submitForm('editExpense');
				   }
			} 
			
		</script>
		
	<% 		
		int expenseId=Integer.parseInt(request.getParameter("expenseId"));
		
		if(expense==null)
		{
			out.println("Expense not found");
		}else {

			session.setAttribute("expenseId", expenseId);

			out.println("<table align='center' border='1'>");
			out.println("<tr>");
			out.println("  <td colspan=2'  align='center'>");
			out.println("EditExpense");
			out.println("  </td>");
			out.println("</tr>");
			
			out.println("<tr id='errorTrId' style='display:none;'>");
			out.println("<td colspan='2' align='left' id='errorTdId' style='color:red;'>");
			out.println("</td>");
			out.println("</tr>");
			
			
			out.println("<tr>");
			out.println("   <td>");
			out.println("Expense Type");
			out.println("<font color='red'>");
			out.println("*");
			out.println("</font>");
			out.println("   </td>");
			out.println("   <td>");
			out.println("<input type='text' name='expenseType' value='" + expense.getType() + "'>");
			out.println("   </td>");
			out.println("</tr>");

			
			out.println("<tr>");
			out.println("   <td>");
			out.println("Date");
			out.println("<font color='red'>");
			out.println("*");
			out.println("</font>");
			out.println("   </td>");
			out.println("   <td>");
			out.println("<input type='text' name='Date' value='" + expense.getDate() + "'>");
			out.println("   </td>");
			out.println("</tr>");

			out.println("<tr>");
			out.println("   <td>");
			out.println("Price");
			out.println("<font color='red'>");
			out.println("*");
			out.println("</font>");
			out.println("   </td>");
			out.println("   <td>");
			out.println("<input type='text' name='Price' value='" + expense.getPrice() + "'>");
			out.println("   </td>");
			out.println("</tr>");

			out.println("<tr>");
			out.println("   <td>");
			out.println("NumberOfitems");
			out.println("<font color='red'>");
			out.println("*");
			out.println("</font>");
			out.println("   </td>");
			out.println("   <td>");
			out.println("<input type='text' name='NoOfItems' value='" + expense.getNumberOfItems() + "'>");
			out.println("   </td>");
			out.println("</tr>");

			out.println("<tr>");
			out.println("   <td>");
			out.println("Total");
			out.println("<font color='red'>");
			out.println("*");
			out.println("</font>");
			out.println("   </td>");
			out.println("   <td>");
			out.println("<input type='text' name='Total' value='" + expense.getTotal() + "'>");
			out.println("   </td>");
			out.println("</tr>");

			out.println("<tr>");
			out.println("   <td>");
			out.println("Bywhom");
			out.println("<font color='red'>");
			out.println("*");
			out.println("</font>");
			out.println("   </td>");
			out.println("   <td>");
			out.println("<input type='text' name='ByWhom' value='" + expense.getByWhom() + "'>");
			out.println("   </td>");
			out.println("</tr>");
			//out.println("<tr>");

			out.println("<tr>");
			out.println("   <td colspan='2' align='center'>");
			out.println("<input type='button' value='Edit Expense' onclick=\"javascript:validateForm();\">");
			out.println("   </td>");
			out.println("</tr>");

			out.println("</table>");
		}
%>
<jsp:include page="Layout/Footer.jsp"/>
