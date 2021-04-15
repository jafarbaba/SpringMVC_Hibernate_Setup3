package com.rs.fer.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.rs.fer.entity.Expense;
import com.rs.fer.service.ExpenseService;
import com.rs.fer.vo.AddExpenseVo;
import com.rs.fer.vo.EditExpenseVo;
import com.rs.fer.vo.ExpenseReportSelectionVo;

@Controller
public class ExpenseController {

	@Autowired
	private ExpenseService expenseService;

	@RequestMapping(value = { "/displayAddExpense" }, method = RequestMethod.POST)
	public ModelAndView displayAddExpense() throws IOException {
		
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("AddExpense");
		
		return mv;
	}
	
	@RequestMapping(value = "/saveExpense", method = RequestMethod.POST)
	public ModelAndView saveExpense(@ModelAttribute AddExpenseVo addExpenseVo, HttpServletRequest request) {
		
		ModelAndView mv = new ModelAndView();
		
		HttpSession session= request.getSession();
		
		boolean isAdded=expenseService.addExpense(addExpenseVo,session);

		if(isAdded) {
			
		mv.addObject("status", "Expense added succefully");
		
		
		}else {
			mv.addObject("status", "Expense add failed ");
		}
		mv.setViewName("Status");
		
		return mv;
	}

	@RequestMapping(value = "/editExpenseOptions", method = RequestMethod.POST)
	public ModelAndView editExpenseOptions(HttpServletRequest request) {
		
		ModelAndView mv = new ModelAndView();
		
		HttpSession session= request.getSession();
		
		List<Expense> expenses=expenseService.getExpenses(session);

		if(CollectionUtils.isEmpty(expenses)) {
			
		mv.addObject("status", "Expense not found");
		
		}else {
			mv.addObject("expenses", expenses);
		}
		mv.setViewName("EditExpenseOptions");
		
		return mv;
	}
	
	@RequestMapping(value = "/dispalyEditExpense", method = RequestMethod.POST)
	public ModelAndView dispalyEditExpense(@RequestParam int expenseId,HttpServletRequest request) {
		
		ModelAndView mv = new ModelAndView();
		
		HttpSession session= request.getSession();
		
		EditExpenseVo editExpenseVo= expenseService.getExpense(expenseId);

		mv.addObject("editExpenseVo", editExpenseVo);
		
		session.setAttribute("editExpenseVo", editExpenseVo);
		
		session.setAttribute("expenseId", expenseId);
		
		mv.setViewName("EditExpense");
		
		return mv;
	}

	@RequestMapping(value = "/editExpense", method = RequestMethod.POST)
	public ModelAndView editExpense(@ModelAttribute EditExpenseVo editExpenseVo, HttpServletRequest request) {
		
		ModelAndView mv = new ModelAndView();
		
		HttpSession session= request.getSession();
		
		boolean isEdited=expenseService.editExpense(editExpenseVo,session);

		if(isEdited) {
			
		mv.addObject("status", "Expense updated succefully");
		
		
		}else {
			mv.addObject("status", "Expense updated failed ");
		}
		mv.setViewName("Status");
		
		return mv;
	}
	
	@RequestMapping(value = { "/expenseReportSelection" }, method = RequestMethod.POST)
	public ModelAndView expenseReportSelection() throws IOException {
		
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("ExpenseReportSelection");
		
		return mv;
	}
	
	@RequestMapping(value = "/expenseReport", method = RequestMethod.POST)
	public ModelAndView expenseReport(ExpenseReportSelectionVo expenseReportSelectionVo, HttpServletRequest request) {
		
		ModelAndView mv = new ModelAndView();
		
		HttpSession session= request.getSession();
		
		List<Expense> expenses=expenseService.getExpenseReport(expenseReportSelectionVo, session);

		if(CollectionUtils.isEmpty(expenses)) {
			
		mv.addObject("status", "Expense not found");
		
		}else {
			mv.addObject("expenses", expenses);
		}
		mv.setViewName("ExpenseReport");
		
		return mv;
	}

	@RequestMapping(value = "/deleteExpenseOptions", method = RequestMethod.POST)
	public ModelAndView deleteExpenseOptions(HttpServletRequest request) {
		
		ModelAndView mv = new ModelAndView();
		
		HttpSession session= request.getSession();
		
		List<Expense> expenses=expenseService.getExpenses(session);

		if(CollectionUtils.isEmpty(expenses)) {
			
		mv.addObject("status", "Expense not found");
		
		}else {
			mv.addObject("expenses", expenses);
		}
		mv.setViewName("DeleteExpenseOptions");
		
		return mv;
	}
	

	@RequestMapping(value = "/deleteExpense", method = RequestMethod.POST)
	public ModelAndView deleteExpense(@RequestParam int expenseId,HttpServletRequest request) {
		
		ModelAndView mv = new ModelAndView();
		
		HttpSession session= request.getSession();
		
		boolean isDeleted=expenseService.deleteExpense(expenseId);

		if(isDeleted) {
			
		mv.addObject("status", "Expense Deleted succefully");
		
		}else {
			mv.addObject("status", "Expense Not Deleted ");
		}
		mv.setViewName("Status");
		
		return mv;
	}

}
