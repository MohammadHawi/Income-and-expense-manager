package com.cvProjects.ExpenseTracker.repository;

import com.cvProjects.ExpenseTracker.entity.Expense;
import com.cvProjects.ExpenseTracker.entity.Income;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long> {

    List<Expense> findByDateBetween(LocalDate startDate, LocalDate endDate);

    @Query("select sum(e.amount) from Expense e")
    Double sumAllAmounts();

    Optional<Expense> findFirstByOrderByDateDesc();

}
