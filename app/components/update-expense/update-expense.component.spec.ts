import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdateExpenseComponent } from './update-expense.component';

describe('UpdateExpenseComponent', () => {
  let component: UpdateExpenseComponent;
  let fixture: ComponentFixture<UpdateExpenseComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [UpdateExpenseComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(UpdateExpenseComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
