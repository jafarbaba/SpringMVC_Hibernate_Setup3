package com.rs.fer.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.rs.fer.entity.Expense;
import com.rs.fer.vo.AddExpenseVo;
import com.rs.fer.vo.EditExpenseVo;
import com.rs.fer.vo.ExpenseReportSelectionVo;

public interface ExpenseService {


	 boolean addExpense(AddExpenseVo addExpenseVo,HttpSession session);
	 
	 List<Expense> getExpenses(HttpSession session);
	 
	 EditExpenseVo getExpense(int expenseId);
	 
	 boolean deleteExpense(int expenseId);
	 
	 boolean editExpense(EditExpenseVo editExpenseVo,HttpSession session);

	 List<Expense> getExpenseReport(ExpenseReportSelectionVo expenseReportSelectionVo,HttpSession session);
}