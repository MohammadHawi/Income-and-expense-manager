import { Component } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, NonNullableFormBuilder, Validators } from '@angular/forms';
import { title } from 'process';
import { ExpenseService } from '../../services/expense/expense.service';
import { NzMessageComponent, NzMessageService } from 'ng-zorro-antd/message';
import { error } from 'console';
import { Router } from '@angular/router';


@Component({
  selector: 'app-expense',
  templateUrl: './expense.component.html',
  styleUrl: './expense.component.scss'
})
export class ExpenseComponent {

  expenseForm!: FormGroup;

  listOfCategory: any[] =[
      "Groceries",
      "Health",
      "Shopping",
      "Other"
    ];
  
  expenses:any;

  constructor(private fb: FormBuilder,
    private expenseService:ExpenseService,
    private message: NzMessageService,
    private router: Router
  ){}

  ngOnInit(){
    this.getAllExpenses();
    this.expenseForm = this.fb.group({
      title:[null,Validators.required],
      amount:[null,Validators.required],
      date:[null,Validators.required],
      category:[null,Validators.required],
      description:[null,Validators.required],
    })
  }

  submitForm(){
this.expenseService.postExpense(this.expenseForm.value).subscribe(res=>{
  this.message.success("Expense posted successfully",{nzDuration:5000});
}, error=>{
  this.message.error("Error while posting expnese",{nzDuration:5000});
})
  }

  


  getAllExpenses(){
    this.expenseService.getAllExpenses().subscribe(res=>{
      this.expenses = res;
      console.log(this.expenses)
    })
  }

  updateExpense(id:number){
    this.router.navigateByUrl(`/expense/${id}/edit`); 
  }

  deleteExpense(id:number){
    this.expenseService.deleteExpense(id).subscribe(res=>{
      this.message.success("Expense deleted successfully",{nzDuration:5000});
      this.getAllExpenses();
    },error=>{
      this.message.error("Error while deleting expnese with id: "+id,{nzDuration:5000});
    })
  }
}
