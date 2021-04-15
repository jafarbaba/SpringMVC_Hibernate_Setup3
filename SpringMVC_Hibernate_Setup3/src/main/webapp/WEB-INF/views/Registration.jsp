<html>
	<head>
		<title>
		fer-Registration
		</title>
		<script> 
			function validateForm()
			{
				var form=document.RegistrationForm;
				var errorMessages="";
				
				if(form.firstname.value.trim()=="")
					{
					 	errorMessages+="Pease Enter firstname<BR>";
					}
				if(form.lastname.value.trim()=="")
					{
						errorMessages+="Please Enter lastname<BR>";
					}
			   if(form.email.value.trim()=="")
				   {
				   		errorMessages+="please enter email<BR>";
				   }
			   if(form.username.value.trim()=="")
				   {
				   		errorMessages+="Please enter username<BR>";
				   }
			   if(form.password.value.trim()=="")
			   {
			   		errorMessages+="Please enter password<BR>";
			   }
			   if(form.mobile.value.trim()== "")
				   {
				    errorMessages+="please enter mobile<BR>";
				   }
			   if(errorMessages!="")
				   {
				    	alert(errorMessages);
				    var errorTdId=document.getElementById('errorTdId');
				    errorTdId.innerHTML=errorMessages;
				    
				    var errorTrId=document.getElementById('errorTrId');
				    errorTrId.style.display="";
				   }
			   else
				   {
				  	 form.submit('login');
				   }
			
			} 
			
			function validateEmail(email){
				var xhttp = new XMLHttpRequest();
				var url = "FER_AJAX.jsp?email="+email;
				
				xhttp.onreadystatechange = function(){
					if(this.readyState == 4 && this.status == 200){
						alert("..."+this.responseText+"...");
						
						var emailTrId = document.getElementByid('emailTrId');
						var emailTdId = document.getElementByid('emailTdId');
						if(this.responseText.trim()== 'Y'){
							
							emailTdId.innerHTML = 'Email is available';
							emailTdId.style.color ='green';
							
						}else{
							emailTdId.innerHTML = 'Email is  not available';
							emailTdId.style.color ='red';
						}
						emailTrId.style.display='';
					}
				};
				xhttp.open("GET",url,true);
				xhttp.send();
			}
		</script>
		
	</head>
	<body>
		<form action='registration' method='post' name='RegistrationForm'>
			<table border='1' align='center'>
				<tr>
					
					<td colspan='2' align='center'>
					Registration
					</td>
				</tr>
				
				<tr id='errorTrId' style='display:none;'>
				<td colspan='2' align="left" id='errorTdId' style='color:red;'></td>
				
				</tr>
				<tr>
					<td>
					FirstName<font color='red'>*</font>
					</td>
					<td>
					
					<input type='text' name='firstName' value="<%=request.getParameter("firstName")%>">
					</td>
				</tr>
				<tr>
					<td>
					MiddleName
					</td>
					<td>
					<input type='text' name='middleName'>
					</td>
				</tr>
				<tr>
					<td>
					LastName<font color='red'>*</font>
					</td>
					<td>
					<input type='text' name='lastName'>
					</td>
				</tr>
				<tr>
					<td>
					Email<font color='red'>*</font>
					</td>
					<td>
					<input type='text' name='email' onchange="javascript: validateEmail(this.value)">
					</td>
				</tr>
				
				<tr id='emailTrId' style='display:none;'>
				<td colspan='2' align="left" id='emailTdId'></td>
				
				</tr>
				
				<tr>
					<td>
					UserName<font color='red'>*</font>
					</td>
					<td>
					<input type='text' name='username'>
					</td>
				</tr>
				<tr>
					<td>
					Password<font color='red'>*</font>
					</td>
					<td>
					<input type='password' name='password'>
					</td>
				</tr>
				<tr>
					<td>
					Mobile<font color='red'>*</font>
					</td>
					<td>
					<input type='text' name='mobile'>
					</td>
				</tr>
				<tr>
					
					<td colspan='2' align='center'>
					<input type='submit' value='Register' onclick="javascript:validateForm()"/>
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>