package com.cvProjects.ExpenseTracker.entity;

import com.cvProjects.ExpenseTracker.dto.IncomeDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDate;
import java.util.SplittableRandom;

@Entity
@Data
public class Income {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;
    private String title;
    private Integer amount;
    private LocalDate date;
    private String category;

    public IncomeDTO getIncomeDto(){
        IncomeDTO incomeDTO = new IncomeDTO();
        incomeDTO.setId(id);
        incomeDTO.setDescription(description);
        incomeDTO.setTitle(title);
        incomeDTO.setAmount(amount);
        incomeDTO.setDate(date);
        incomeDTO.setCategory(category);
        return incomeDTO;
    }
}
