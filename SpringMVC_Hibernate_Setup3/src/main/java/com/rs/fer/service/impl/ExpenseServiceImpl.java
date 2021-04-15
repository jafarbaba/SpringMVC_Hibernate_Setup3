package com.rs.fer.service.impl;


import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rs.fer.entity.Expense;
import com.rs.fer.repository.ExpenseRepository;
import com.rs.fer.service.ExpenseService;
import com.rs.fer.util.ExpenseUtil;
import com.rs.fer.util.FERUtil;
import com.rs.fer.vo.AddExpenseVo;
import com.rs.fer.vo.EditExpenseVo;
import com.rs.fer.vo.ExpenseReportSelectionVo;


@Service

public class ExpenseServiceImpl implements ExpenseService {

	    @Autowired
		 ExpenseRepository expenseRepository;

	    @Autowired
		 ExpenseUtil expenseUtil;

	
	@Override
	public boolean addExpense(AddExpenseVo  addExpenseVo, HttpSession session) {
             
		boolean isAddExpense= false;

             Expense  expense = expenseUtil.getExpense(addExpenseVo);
        
             expense.setUserId(FERUtil.getUserId(session));

		try {
			expenseRepository.save(expense);
			
			
			isAddExpense =true;
	
		}catch(Exception ex) {
		
			isAddExpense= false ;
		}

		return isAddExpense;
	}


	@Override
	public List<Expense> getExpenses(HttpSession session) {

		List<Expense> expenses= null;
		
		expenses= expenseRepository.findByUserId(FERUtil.getUserId(session));
		
		session.setAttribute("expenses", expenses);
		
		return expenses;
	}


	@Override
	public EditExpenseVo getExpense(int expenseId) {

		EditExpenseVo  editExpenseVo = new EditExpenseVo();
		
		Expense expense= expenseRepository.findById(expenseId).get();
		
		editExpenseVo = expenseUtil.getEDitExpenseVo(expense);
		
		return editExpenseVo;
	}


	@Override
	public boolean editExpense(EditExpenseVo editExpenseVo, HttpSession session) {

		boolean isEditExpense= false;
       int expenseId =FERUtil.getExpenseId(session);
        Expense  expense = expenseRepository.findById(expenseId).get();
        expense = expenseUtil.getExpense(editExpenseVo, expense);
   

	try {
		expenseRepository.save(expense);
		
		
		isEditExpense =true;

	}catch(Exception ex) {
	
		isEditExpense= false ;
	}

	return isEditExpense;
		
	
	}


	@Override
	public List<Expense> getExpenseReport(ExpenseReportSelectionVo expenseReportSelectionVo, HttpSession session) {
		
          List<Expense> expenses= null;
		
		expenses= expenseRepository.findByUserIdAndTypeAndDateBetween(FERUtil.getUserId(session),expenseReportSelectionVo.getType(),expenseReportSelectionVo.getFromDate(),expenseReportSelectionVo.getToDate());
		
		return expenses;
	}
	
	
	@Override
	public boolean deleteExpense(int expenseId) {

		boolean isDeletedExpense= false;
		
		Expense expense= expenseRepository.findById(expenseId).get();
		
		try {
			expenseRepository.delete(expense);
			
			
			isDeletedExpense =true;

		}catch(Exception ex) {
		
			isDeletedExpense= false ;
		}

		return isDeletedExpense;
		
	}
	}


