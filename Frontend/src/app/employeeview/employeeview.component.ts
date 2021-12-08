import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  templateUrl: './employeeview.component.html',
  styleUrls: ['./employeeview.component.css'],
})
export class EmployeeViewComponent implements OnInit {
  employees!: any[];
  searchSIN: any;
  constructor(private route: ActivatedRoute) {}

  ngOnInit(): void {
    this.employees = this.route.snapshot.data['employees'];

    this.employees.forEach((employee) => {
      employee.pay_start = employee.pay_start.substring(0, 10);
      employee.pay_end = employee.pay_end.substring(0, 10);
    });
  }
}
