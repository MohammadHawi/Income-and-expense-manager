package com.cvProjects.ExpenseTracker.services.income;

import com.cvProjects.ExpenseTracker.dto.IncomeDTO;
import com.cvProjects.ExpenseTracker.entity.Income;
import com.cvProjects.ExpenseTracker.repository.IncomeRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class IncomeServiceImpl implements IncomeService {

    private final IncomeRepository incomeRepository;

    public Income postIncome(IncomeDTO incomeDTO) {
        return saveOrUpdateIncome(new Income(), incomeDTO);
    }

    private Income saveOrUpdateIncome(Income income, IncomeDTO incomeDTO) {
        income.setTitle(incomeDTO.getTitle());
        income.setDescription(incomeDTO.getDescription());
        income.setDate(incomeDTO.getDate());
        income.setCategory(incomeDTO.getCategory());
        income.setAmount(incomeDTO.getAmount());
        return incomeRepository.save(income);

    }

    public Income updateIncome(Long id,IncomeDTO incomeDTO) {
        Optional<Income> OptionalIncome = incomeRepository.findById(id);
        if(OptionalIncome.isPresent()) {
            return saveOrUpdateIncome(OptionalIncome.get(), incomeDTO);
        } else {
            throw new EntityNotFoundException("Income Not Found with id: "+id);
        }
    }

    public List<IncomeDTO> getAllIncomes() {
        return incomeRepository.findAll().stream()
                .sorted(Comparator.comparing(Income::getDate).reversed())
                .map(Income::getIncomeDto)
                .collect(Collectors.toList());
    }

    public IncomeDTO getIncomeById(Long id) {
        Optional<Income> OptionalIncome = incomeRepository.findById(id);
        if(OptionalIncome.isPresent()) {
            return OptionalIncome.get().getIncomeDto();
        } else{
            throw new EntityNotFoundException("Income Not Found with id: "+id);
        }
    }

    public void deleteIncome(Long id) {
        Optional<Income> OptionalIncome = incomeRepository.findById(id);
        if(OptionalIncome.isPresent()) {
            incomeRepository.deleteById(id);
        } else{
            throw new EntityNotFoundException("Income Not Found with id: "+id);
        }
    }
}
