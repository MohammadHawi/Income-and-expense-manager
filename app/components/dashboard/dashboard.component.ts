import { Component, ElementRef, ViewChild } from '@angular/core';
import { StatsService } from '../../services/stats/stats.service';
import Chart from 'chart.js/auto';
import { CategoryScale } from 'chart.js';

Chart.register(CategoryScale);

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrl: './dashboard.component.scss'
})
export class DashboardComponent {

  stats:any;

  expenses:any;
  incomes:any;

  gridStyle = {
    width: '25%',
    textAlign: 'center'
  };

  @ViewChild('myChart') chartRef:ElementRef; 

  constructor(private statsService: StatsService){
    this.getStats();
    this.getChartData();
  }

  createLineChart(){
    const ctx = (this.chartRef.nativeElement).getContext('2d');

    new Chart(ctx, {
      type: 'bar',
      data: {
        labels: ['Red', 'Blue', 'Yellow', 'Green', 'Purple', 'Orange'],
        datasets: [{
          label: '# of Votes',
          data: [12, 19, 3, 5, 2, 3],
          borderWidth: 1
        }]
      },
      options: {
        scales: {
          y: {
            beginAtZero: true
          }
        }
      }
    });
  }

  getStats(){
    this.statsService.getStats().subscribe(res=>{
      console.log(res);
      this.stats = res;
    })
  }

  getChartData(){
    this.statsService.getChart().subscribe(res=>{
      if(res.expenseList != null && res.incomeList !=null){
        this.incomes = res.incomeList;
        this.expenses = res.expenseList;
        console.log(res);

        this.createLineChart();
      }
    })
  }

}
