package com.cvProjects.ExpenseTracker.services.stats;

import com.cvProjects.ExpenseTracker.dto.GraphDTO;
import com.cvProjects.ExpenseTracker.dto.StatsDTO;

public interface StatsService {
    GraphDTO getChartData();

    StatsDTO getStats();
}
