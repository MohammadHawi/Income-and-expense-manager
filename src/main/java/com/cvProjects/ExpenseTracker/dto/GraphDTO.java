package com.cvProjects.ExpenseTracker.dto;

import com.cvProjects.ExpenseTracker.entity.Expense;
import com.cvProjects.ExpenseTracker.entity.Income;
import lombok.Data;

import java.util.List;

@Data
public class GraphDTO {

    private List<Expense> expenseList;

    private List<Income> incomeList;

}
