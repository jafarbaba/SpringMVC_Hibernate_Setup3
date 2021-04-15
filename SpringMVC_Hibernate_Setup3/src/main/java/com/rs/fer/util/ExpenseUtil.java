package com.rs.fer.util;

import org.springframework.stereotype.Component;

import com.rs.fer.entity.Expense;
import com.rs.fer.vo.AddExpenseVo;
import com.rs.fer.vo.EditExpenseVo;
@Component
public interface ExpenseUtil {

	Expense getExpense(AddExpenseVo  addExpenseVo);
	
	
	EditExpenseVo getEDitExpenseVo(Expense expense); 

	Expense getExpense(EditExpenseVo editExpenseVo, Expense expense);
	
	
	
}
