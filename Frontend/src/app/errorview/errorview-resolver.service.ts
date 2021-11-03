import {Resolve, ActivatedRouteSnapshot, RouterStateSnapshot} from '@angular/router';
import { Observable } from 'rxjs';
import { ErrorsService } from './errorview.service';
import { Injectable } from '@angular/core';

@Injectable()
export class ErrorsResolver implements Resolve<any>{

    constructor( private errorsService: ErrorsService){}
    
    resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<any> {
        return this.errorsService.getErrorsAPI();
    }
}