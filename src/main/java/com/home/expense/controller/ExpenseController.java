package com.home.expense.controller;

import com.home.expense.dto.Expense;
import com.home.expense.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/expense")
public class ExpenseController {

    @Autowired
    ExpenseService expenseService;

    @PostMapping
    public ResponseEntity<Long> addExpense(@RequestBody Expense expense){
        return ResponseEntity.ok().body(expenseService.addExpense(expense));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Expense> getExpenseById(@PathVariable Long id){
        return ResponseEntity.ok().body(expenseService.getExpenseById(id));
    }

    @PostMapping("/{id}")
    public ResponseEntity<Boolean> removeExpenseById(@PathVariable Long id){
        return ResponseEntity.ok().body(expenseService.removeExpenseById(id));
    }

    @PostMapping("/remove")
    public ResponseEntity<Boolean> removeExpense(){
        return ResponseEntity.ok().body(expenseService.removeExpense());
    }

    @GetMapping
    public ResponseEntity<List<Expense>> getAllExpenses(){
        return ResponseEntity.ok().body(expenseService.getAllExpenses());
    }
}
