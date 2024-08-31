package com.cvProjects.ExpenseTracker.repository;

import com.cvProjects.ExpenseTracker.entity.Expense;
import com.cvProjects.ExpenseTracker.entity.Income;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface IncomeRepository extends JpaRepository<Income, Long> {

    List<Income> findByDateBetween(LocalDate startDate, LocalDate endDate);

    @Query("select sum(i.amount) from Income i")
    Double sumAllAmounts();

    Optional<Income> findFirstByOrderByDateDesc();

}
