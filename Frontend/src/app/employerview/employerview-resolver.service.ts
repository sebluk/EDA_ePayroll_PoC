import {Resolve, ActivatedRouteSnapshot, RouterStateSnapshot} from '@angular/router';
import { Observable } from 'rxjs';
import { Injectable } from '@angular/core';
import { EmployerService } from './employerview.service';

@Injectable()
export class EmployerResolver implements Resolve<any>{

    constructor( private employerService: EmployerService){}
    
    resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<any> {
        return this.employerService.getEmployersAPI();
    }
}