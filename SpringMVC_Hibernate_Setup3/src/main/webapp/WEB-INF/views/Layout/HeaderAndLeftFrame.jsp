  <html>
	<head>
		<title>fer-Dashboard</title>
		
		<script>
		
			function submitForm(nextPath)
			{
				var form = document.DashboardForm;
				form.action =nextPath;
				
				form.submit();
			}
		</script>
		
	</head>
	<body>
		<form name='DashboardForm' method="post">
			<table border='1' align='center' height='600px' width='800px'>
				<tr height='100px'>
					<td colspan='2' align='center'>
					FAMILY MAINTENANCE REPORT USER:${username}
					
					</td>
				</tr>
				<tr>
					<td width='150px'>
						<br>
						<a href="javascript: submitForm('displayAddExpense')">Add Expense</a>
						<br><br>
						<a href="javascript: submitForm('editExpenseOptions')">Edit Expense</a>
						<br><br>
						<a href="javascript: submitForm('deleteExpenseOptions')">Delete Expense</a>
						<br><br>
						<a href="javascript: submitForm('expenseReportSelection')">Expense Report</a>
						<br><br>
						<a href="javascript: submitForm('displayResetPassword')">Reset Password</a>
						<br><br>
						<a href="javascript: submitForm('nameInfo')">Update Profile</a>
					</td>
					<td align='center'>