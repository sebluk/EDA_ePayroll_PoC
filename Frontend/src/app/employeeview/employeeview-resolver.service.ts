import {Resolve, ActivatedRouteSnapshot, RouterStateSnapshot} from '@angular/router';
import { Observable } from 'rxjs';
import { Injectable } from '@angular/core';
import { EmployeeService } from './employeeview.service';

@Injectable()
export class EmployeeResolver implements Resolve<any>{

    constructor( private employeeService: EmployeeService){}
    
    resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<any> {
        return this.employeeService.getEmployeesAPI();
    }
}