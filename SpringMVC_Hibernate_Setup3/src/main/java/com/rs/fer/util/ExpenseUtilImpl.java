package com.rs.fer.util;

import org.springframework.stereotype.Component;

import com.rs.fer.entity.Expense;
import com.rs.fer.vo.AddExpenseVo;
import com.rs.fer.vo.EditExpenseVo;
@Component
public class ExpenseUtilImpl implements ExpenseUtil {

	@Override
	public Expense getExpense(AddExpenseVo addExpenseVo) {

		Expense expense= new Expense();
		
		expense.setType(addExpenseVo.getType());
		expense.setDate(addExpenseVo.getDate());
		expense.setPrice(addExpenseVo.getPrice());
		expense.setNumberOfItems(addExpenseVo.getNumberOfItems());
		expense.setTotal(addExpenseVo.getTotal());
		expense.setByWhom(addExpenseVo.getByWhom());
		
		expense.setCreated(DateUtil.getCurrentDate());
		
		return expense;
	}

	@Override
	public EditExpenseVo getEDitExpenseVo(Expense expense) {

		EditExpenseVo editExpenseVo= new EditExpenseVo();
		
		editExpenseVo.setType(expense.getType());
		editExpenseVo.setDate(expense.getDate());
		editExpenseVo.setPrice(expense.getPrice());
		editExpenseVo.setNumberOfItems(expense.getNumberOfItems());
		editExpenseVo.setTotal(expense.getTotal());
		editExpenseVo.setByWhom(expense.getByWhom());
		
		return editExpenseVo;
	}



	@Override
	public Expense getExpense(EditExpenseVo editExpenseVo, Expense expense) {
		
		expense.setType(editExpenseVo.getType());
		expense.setDate(editExpenseVo.getDate());
		expense.setPrice(editExpenseVo.getPrice());
		expense.setNumberOfItems(editExpenseVo.getNumberOfItems());
		expense.setTotal(editExpenseVo.getTotal());
		expense.setByWhom(editExpenseVo.getByWhom());
		
		expense.setUpdated(DateUtil.getCurrentDate());
		
		
		return expense;
	}
	
	
}
