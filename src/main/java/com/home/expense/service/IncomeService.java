package com.home.expense.service;

import com.home.expense.dto.Income;
import com.home.expense.repository.IncomeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class IncomeService {

    @Autowired
    IncomeRepository incomeRepository;

    public Long addIncome(Income income){
        var incomeEntity = new com.home.expense.entity.Income();
        incomeEntity.setTitle(income.getTitle());
        incomeEntity.setAmount(income.getPrice());
        incomeRepository.save(incomeEntity);
        return incomeEntity.getId();
    }

    public Income getIncomeById(Long id){
        var optIncomeEntity = incomeRepository.findById(id);
        var incomeEntity = optIncomeEntity.orElseGet(com.home.expense.entity.Income::new);
        var income = new Income();
        income.setTitle(incomeEntity.getTitle());
        income.setPrice(incomeEntity.getAmount());

        return income;
    }

    public Boolean removeIncomeById(Long id){
        incomeRepository.deleteById(id);
        return true;
    }

    public Boolean removeIncome(){
        incomeRepository.deleteAll();
        return true;
    }

    public List<Income> getAllIncome(){
        var expenseEntityList = incomeRepository.findAll();
        List<Income> incomes = new ArrayList<Income>();
        expenseEntityList.forEach(incomeEntity -> {
            var income = new Income();
            income.setTitle(incomeEntity.getTitle());
            income.setPrice(incomeEntity.getAmount());
            incomes.add(income);
        });

        return incomes;
    }
}
