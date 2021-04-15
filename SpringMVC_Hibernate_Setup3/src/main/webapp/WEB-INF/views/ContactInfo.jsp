<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Home</title>
<script> 
			
			function validateForm()
			{
				var form=document.DashboardForm;
				
				   submitForm('addressInfo');
			} 
			
		</script>
</head>
<body>

          <jsp:include page="Layout/HeaderAndLeftFrame.jsp"/>	
          
        <form:form method="POST" action="addressInfo" modelAttribute="updateProfileVo">
             <table>
                <tr>
                    <td colspan='2' align="center">ContactInfo</td>
                </tr>
         
                <tr>
                    <td><form:label path="email">Email</form:label></td>
                    <td><form:input path="email"/></td>
                </tr>
                <tr>
                    <td><form:label path="mobile">Mobile</form:label></td>
                    <td><form:input path="mobile"/></td>
                </tr>
                <tr>
                    <td align="center"><input type="submit" value="Next" onclick="javascript:validateForm()"/></td>
                </tr>
            </table>
        </form:form>
          <jsp:include page="Layout/Footer.jsp"/>
</body>
</html>