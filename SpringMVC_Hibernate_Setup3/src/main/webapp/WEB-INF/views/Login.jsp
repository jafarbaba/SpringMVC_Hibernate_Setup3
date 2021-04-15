<html>
<head>

<title>FRE-Login</title>
<script> 
			function validateForm()
			{
				var form=document.LoginForm;
				var errorMessages="";
				
				if(form.username.value.trim()=="")
				{
				 	errorMessages+="Pease Enter username<BR>";
				}
			if(form.password.value.trim()=="")
				{
					errorMessages+="Please Enter password<BR>";
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
			  	 form.submit();
			   }
		
		} 
	</script>
				
</head>
<body>
	<form action='login' method='post' >
	${status} 
	
		<table border='1' align='center'>
			<tr>
				<td colspan='2' align='center'>Login</td>
			</tr>
			
			<tr id='errorTrId' style='display:none;'>
				<td colspan='2' align="left" id='errorTdId' style='color:red;'></td>
				
				</tr>
			<tr>
				<td>Username<font color='red'>*</font></td>
				<td><input type='text' name='username'></td>
			</tr>
			<tr>
				<td>Password<font color='red'>*</font></td>
				<td><input type='text' name='password'></td>
			</tr>
			<tr>
				<td colspan='2' align='center'><input type='submit'
					value='Login'>
					&nbsp; &nbsp; 
					<a href='registration'>Registration</a>
				</td>

			</tr>
		</table>
	</form>


</body>

</html>