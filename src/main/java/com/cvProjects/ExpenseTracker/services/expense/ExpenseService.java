package com.cvProjects.ExpenseTracker.services.expense;

import com.cvProjects.ExpenseTracker.dto.ExpenseDTO;
import com.cvProjects.ExpenseTracker.entity.Expense;

import java.util.List;

public interface ExpenseService {

    Expense postExpense(ExpenseDTO expenseDTO);

    List<Expense> getAllExpenses();
    Expense getExpenseById(Long id);
    Expense updateExpense(Long id, ExpenseDTO expenseDTO);
    void deleteExpense(Long id);

}
