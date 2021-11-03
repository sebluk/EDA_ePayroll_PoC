import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { Observable, throwError } from 'rxjs';
import { catchError, retry } from 'rxjs/operators';

@Injectable()
export class EmployeeService{

    employees!: any[];

    constructor(private http: HttpClient){}
    

    getEmployeeRecord(recordID:number){
      return this.employees.find(employees => employees.recordID == recordID);
    }

    getEmployeesAPI(){
      const headers = {
        'Access-Control-Allow-Origin': '*'
      };

      this.http.get<any>('https://mocki.io/v1/ea7f92f3-46df-4011-9523-0b73e094009a', {headers}).subscribe({
        next: data => {
          this.employees = data;
        },
        error: error => {
          console.error("Error here: ", error);
        }
      });

      return this.http.get<any>('https://mocki.io/v1/ea7f92f3-46df-4011-9523-0b73e094009a', {headers});
    }
}
