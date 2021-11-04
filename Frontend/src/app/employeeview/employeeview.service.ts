import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";

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

      this.http.get<any>('https://mocki.io/v1/0d564c37-a578-4eab-aaf9-9400f01f379e', {headers}).subscribe({
        next: data => {
          this.employees = data;
        },
        error: error => {
          console.error("Error here: ", error);
        }
      });

      return this.http.get<any>('https://mocki.io/v1/0d564c37-a578-4eab-aaf9-9400f01f379e', {headers});
    }
}
