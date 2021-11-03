import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";

@Injectable()
export class ErrorsService{

  errors!:any[];

  constructor(private http: HttpClient){}
    
  getError(errorNumber:number){
    return this.errors.find(errors => errors.errorNumber == errorNumber);
  }

  getErrorsAPI(){
    const headers = {
      'Access-Control-Allow-Origin': '*'
    };
    this.http.get<any>('http://epayroll-data-eda-epayroll-poc.apps.ocp4.omega.dce-eir.net/errors', {headers}).subscribe(data => {
      this.errors = data;
    });
    return this.http.get<any>('http://epayroll-data-eda-epayroll-poc.apps.ocp4.omega.dce-eir.net/errors', {headers});
    
  }
  
}