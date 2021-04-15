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
				
				   submitForm('review');
			} 
			
		</script>
					
</head>
<body>

          <jsp:include page="Layout/HeaderAndLeftFrame.jsp"/>	
          
        <form:form method="POST" action="review" modelAttribute="updateProfileVo">
             <table>
                <tr>
                    <td colspan='2' align="center">AddressInfo</td>
                </tr>
         
                <tr>
                    <td><form:label path="line1">Line1</form:label></td>
                    <td><form:input path="line1"/></td>
                </tr>
                <tr>
                    <td><form:label path="line2">Line2</form:label></td>
                    <td><form:input path="line2"/></td>
                </tr>
                <tr>
                    <td><form:label path="city">City</form:label></td>
                    <td><form:input path="city"/></td>
                </tr>
                <tr>
                <tr>
                    <td><form:label path="state">State</form:label></td>
                    <td><form:input path="state"/></td>
                </tr>
                <tr>
                    <td><form:label path="pinCode">PinCode</form:label></td>
                    <td><form:input path="pinCode"/></td>
                </tr>
                <tr>
                    <td><form:label path="country">Country</form:label></td>
                    <td><form:input path="country"/></td>
                </tr>
                <tr>
                    <td align="center"><input type="button" value="Review" onclick="javascript:validateForm()"/></td>
                </tr>
            </table>
        </form:form>
          <jsp:include page="Layout/Footer.jsp"/>
</body>
</html>