package com.home.expense.controller;

import com.home.expense.dto.Income;
import com.home.expense.service.IncomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/income")
public class IncomeController {

    @Autowired
    IncomeService incomeService;

    @PostMapping
    public ResponseEntity<Long> addIncome(@RequestBody Income income){
        return ResponseEntity.ok().body(incomeService.addIncome(income));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Income> getIncomeById(@PathVariable Long id){
        return ResponseEntity.ok().body(incomeService.getIncomeById(id));
    }

    @PostMapping("/remove/{id}")
    public ResponseEntity<Boolean> removeIncomeById(@PathVariable Long id){
        return ResponseEntity.ok().body(incomeService.removeIncomeById(id));
    }

    @PostMapping("/remove")
    public ResponseEntity<Boolean> removeIncome(){
        return ResponseEntity.ok().body(incomeService.removeIncome());
    }

    @GetMapping
    public ResponseEntity<List<Income>> getAllIncome(){
        return ResponseEntity.ok().body(incomeService.getAllIncome());
    }
}
