package com.home.expense.repository;

import com.home.expense.entity.Expense;
import com.home.expense.entity.Income;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IncomeRepository extends JpaRepository<Income, Long> {
}
