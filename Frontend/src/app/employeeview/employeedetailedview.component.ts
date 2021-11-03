import { Component, OnInit } from "@angular/core";
import { ActivatedRoute } from "@angular/router";
import { EmployeeService } from "./employeeview.service";


@Component({
    templateUrl: './employeedetailedview.component.html',
})

export class EmployeeDetailedViewComponent implements OnInit {

    employee!: any;

    constructor(private employeeService: EmployeeService, private activatedRoute: ActivatedRoute) {
        
    }

    ngOnInit(): void{
        this.employee = this.employeeService.getEmployeeRecord(this.activatedRoute.snapshot.params['recordID']);
    }
}