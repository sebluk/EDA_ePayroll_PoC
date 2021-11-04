import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  templateUrl: './employeeview.component.html',
  styleUrls: ['./employeeview.component.css']
})

export class EmployeeViewComponent implements OnInit {

  employees!: any[]

  constructor(private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.employees = this.route.snapshot.data['employees'];
  }

}
