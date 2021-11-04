import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { Observable, throwError } from 'rxjs';
import { catchError, retry } from 'rxjs/operators';

@Injectable()
export class EmployerService{

    employers!: any[];

    constructor(private http: HttpClient){}
    

    getEmployerRecord(recordID:number){
      return this.employers.find(employers => employers.recordID == recordID);
    }

    getEmployersAPI(){
      const headers = {
        'Access-Control-Allow-Origin': '*'
      };

      this.http.get<any>('https://mocki.io/v1/0d564c37-a578-4eab-aaf9-9400f01f379e', {headers}).subscribe({
        next: data => {
          this.employers = data;
        },
        error: error => {
          console.error("Error here: ", error);
        }
      });

      return this.http.get<any>('https://mocki.io/v1/0d564c37-a578-4eab-aaf9-9400f01f379e', {headers});
    }
}
