import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { EmployerService } from './employerview.service';

@Component({
  templateUrl: './employerdetailedview.component.html',
  styleUrls: ['./employerdetailedview.component.css'],
})
export class EmployerDetailedViewComponent implements OnInit {
  employer!: any;

  constructor(
    private employerService: EmployerService,
    private activatedRoute: ActivatedRoute
  ) {}

  ngOnInit(): void {
    this.employer = this.employerService.getEmployerRecord(
      this.activatedRoute.snapshot.params['id']
    );

    this.employer.pay_start = this.employer.pay_start.substring(0, 10);
    this.employer.pay_end = this.employer.pay_end.substring(0, 10);
  }
}
