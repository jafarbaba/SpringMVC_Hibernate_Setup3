
<jsp:include page="Layout/HeaderAndLeftFrame.jsp"/>
					
					
		<script> 
			
			function validateForm()
			{
				var form=document.DashboardForm;
				var errorMessages="";
				
				if(form.expensetype.value.trim()=="")
					{
					 	errorMessages+="Pease Enter expensetype<BR>";
					}
				if(form.date.value.trim()=="")
					{
						errorMessages+="Please Enter date<BR>";
					}	   
				if(form.Price.value.trim()=="")
				{
					errorMessages+="Please Enter Price<BR>";
				}	   
				if(form.noOfItems.value.trim()=="")
				{
					errorMessages+="Please Enter noOfItems<BR>";
				}	   
				if(form.total.value.trim()=="")
				{
					errorMessages+="Please Enter total<BR>";
				}	   
				if(form.byWhom.value.trim()=="")
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
				   submitForm('saveExpense');
				   }
			
			} 
			
		</script>
					
					
					<table border='1' align='center'>
				<tr>
					
					<td colspan='2' align='center'>
					Add Expense
					</td>
				</tr>
				<tr id='errorTrId' style='display:none;'>
				<td colspan='2' align="left" id='errorTdId' style='color:red;'></td>
				
				</tr>
				<tr>
					<td>
					ExpenseType<font color='red'>*</font>
					</td>
					<td>
					<input type='text' name='type'>
					</td>
				</tr>
				<tr>
					<td>
					Date<font color='red'>*</font>
					</td>
					<td>
					<input type='text' name='date'>
					</td>
				</tr>
				<tr>
					<td>
					Price<font color='red'>*</font>
					</td>
					<td>
					<input type='text' name='price'>
					</td>
				</tr>
				<tr>
					<td>
					NoOfItems<font color='red'>*</font>
					</td>
					<td>
					<input type='text' name='numberOfItems'>
					</td>
				</tr>
				<tr>
					<td>
					Total<font color='red'>*</font>
					</td>
					<td>
					<input type='text' name='total'>
					</td>
				</tr>
				<tr>
					<td>
					ByWhom<font color='red'>*</font>
					</td>
					<td>
					<input type='text' name='byWhom'>
					</td>
				</tr>
				
				<tr>
					
					<td colspan='2' align='center'>
					<input type='button' value='Save Expenses' onclick="javascript:submitForm('saveExpense');">
					</td>
				</tr>
			</table>
			
		<jsp:include page="Layout/Footer.jsp"/>
