<jsp:include page="Layout/HeaderAndLeftFrame.jsp"/>
					
					
					<script> 
			
			function validateForm()
			{
				var form=document.DashboardForm;
				
				   submitForm('resetPassword');
				   }
			
			} 
			
		</script>
					
					
					<table border='1' align='center'>
				<tr>
					
					<td colspan='2' align='center'>
					Reset Password
					</td>
				</tr>
				
				
				<tr id='errorTrId' style='display:none;'>
				<td colspan='2' align="left" id='errorTdId' style='color:red;'></td>
				
				</tr>
				
				
				<tr>
					<td>
					CurrentPassword<font color='red'>*</font>
					</td>
					<td>
					<input type='text' name='currentpassword'>
					</td>
				</tr>
				<tr>
					<td>
					New Password<font color='red'>*</font>
					</td>
					<td>
					<input type='text' name='newPassword'>
					</td>
				</tr>
				<tr>
					<td>
					Re-Enter New Password<font color='red'>*</font>
					</td>
					<td>
					<input type='text' name='reEnterNewPassword'>
					</td>
				</tr>
				
				
				<tr>
					
					<td colspan='2' align='center'>
					<input type='button' value='Save' onclick="javascript:submitForm('resetPassword')"/>
					</td>
				</tr>
			</table>
			<jsp:include page="Layout/Footer.jsp"/>
