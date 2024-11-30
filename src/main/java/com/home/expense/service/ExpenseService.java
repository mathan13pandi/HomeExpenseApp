package com.home.expense.service;

import com.home.expense.dto.Expense;
import com.home.expense.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ExpenseService {

    @Autowired
    ExpenseRepository expenseRepository;

    public Long addExpense(Expense expense){
        var expenseEntity = new com.home.expense.entity.Expense();
        expenseEntity.setTitle(expense.getTitle());
        expenseEntity.setAmount(expense.getPrice());
        expenseRepository.save(expenseEntity);
        return expenseEntity.getId();
    }

    public Expense getExpenseById(Long id){
        var optExpenseEntity = expenseRepository.findById(id);
        var expenseEntity = optExpenseEntity.orElseGet(com.home.expense.entity.Expense::new);
        var expense = new Expense();
        expense.setTitle(expenseEntity.getTitle());
        expense.setPrice(expenseEntity.getAmount());

        return expense;
    }

    public Boolean removeExpenseById(Long id){
        expenseRepository.deleteById(id);
        return true;
    }

    public Boolean removeExpense(){
        expenseRepository.deleteAll();
        return true;
    }

    public List<Expense> getAllExpenses(){
        var expenseEntityList = expenseRepository.findAll();
        List<Expense> expenses = new ArrayList<Expense>();
        expenseEntityList.forEach(expenseEntity -> {
            var expense = new Expense();
            expense.setTitle(expenseEntity.getTitle());
            expense.setPrice(expenseEntity.getAmount());
            expenses.add(expense);
        });

        return expenses;
    }
}
