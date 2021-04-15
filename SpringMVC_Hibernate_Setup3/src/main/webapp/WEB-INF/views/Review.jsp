<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Spring</title>
<script> 
			
			function validateForm()
			{
				var form=document.DashboardForm;
				
				   submitForm('updateUser');
			} 
			
		</script>
					
</head>
<body>

          <jsp:include page="Layout/HeaderAndLeftFrame.jsp"/>	
          
        <form:form method="POST" action="updateUser" modelAttribute="updateProfileVo">
             <table>
                <tr>
                    <td colspan='2' align="center">Review</td>
                </tr>
                
                <tr>
                    <td><form:label path="firstName">FirstName</form:label></td>
                    <td><form:input path="firstName" disabled="true"/></td>
                </tr>
                <tr>
                    <td><form:label path="middleName">MiddleName</form:label></td>
                    <td><form:input path="middleName" disabled="true"/></td>
                </tr>
                <tr>
                    <td><form:label path="lastName">LastName</form:label></td>
                    <td><form:input path="lastName" disabled="true"/></td>
                </tr>
       
                 <tr>
                    <td><form:label path="email">Email</form:label></td>
                    <td><form:input path="email" disabled="true"/></td>
                </tr>
                <tr>
                    <td><form:label path="mobile">Mobile</form:label></td>
                    <td><form:input path="mobile" disabled="true"/></td>
                </tr>
                <tr>
         
                <tr>
                    <td><form:label path="line1">Line1</form:label></td>
                    <td><form:input path="line1" disabled="true"/></td>
                </tr>
                <tr>
                    <td><form:label path="line2">Line2</form:label></td>
                    <td><form:input path="line2" disabled="true"/></td>
                </tr>
                <tr>
                    <td><form:label path="city">City</form:label></td>
                    <td><form:input path="city" disabled="true"/></td>
                </tr>
                <tr>
                <tr>
                    <td><form:label path="state">State</form:label></td>
                    <td><form:input path="state" disabled="true"/></td>
                </tr>
                <tr>
                    <td><form:label path="pinCode">PinCode</form:label></td>
                    <td><form:input path="pinCode" disabled="true"/></td>
                </tr>
                <tr>
                    <td><form:label path="country">Country</form:label></td>
                    <td><form:input path="country" disabled="true"/></td>
                </tr>
                <tr>
                    <td align="center"><input type="button" value="update" onclick="javascript:validateForm()"/></td>
                </tr>
            </table>
        </form:form>
          <jsp:include page="Layout/Footer.jsp"/>
</body>
</html>