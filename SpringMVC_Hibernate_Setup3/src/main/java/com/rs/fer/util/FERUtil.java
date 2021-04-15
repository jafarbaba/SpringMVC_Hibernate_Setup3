package com.rs.fer.util;

import javax.servlet.http.HttpSession;

public class FERUtil {

	public static int getUserId(HttpSession session) {
		
		return Integer.parseInt(session.getAttribute("userId").toString());
	}
   public static int getExpenseId(HttpSession session) {
		
		return Integer.parseInt(session.getAttribute("expenseId").toString());
	}
	
}
