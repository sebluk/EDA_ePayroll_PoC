import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { EmployeeService } from './employeeview.service';

@Component({
  templateUrl: './employeedetailedview.component.html',
  styleUrls: ['./employeedetailedview.component.css'],
})
export class EmployeeDetailedViewComponent implements OnInit {
  employee!: any;

  constructor(
    private employeeService: EmployeeService,
    private activatedRoute: ActivatedRoute
  ) {}

  ngOnInit(): void {
    this.employee = this.employeeService.getEmployeeRecord(
      this.activatedRoute.snapshot.params['id']
    );

    this.employee.pay_start = this.employee.pay_start.substring(0, 10);
    this.employee.pay_end = this.employee.pay_end.substring(0, 10);
  }
}
