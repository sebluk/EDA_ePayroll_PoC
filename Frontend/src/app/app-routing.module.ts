import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ErrorDetailedViewComponent } from './errorview/errordetailedview.component';
import { ErrorViewComponent } from './errorview/errorview.component';
import { EmployerviewComponent } from './employerview/employerview.component';
import { EmployeeViewComponent } from './employeeview/employeeview.component';
import { EmployerDetailedViewComponent } from './employerview/employerdetailedview.component';
import { ErrorsResolver } from './errorview/errorview-resolver.service';
import { EmployerResolver } from './employerview/employerview-resolver.service';
import { EmployeeResolver } from './employeeview/employeeview-resolver.service';

const routes: Routes = [
  { 
    path: 'errorview', 
    component: ErrorViewComponent,
    resolve: {errors: ErrorsResolver}
  },
  { 
    path: 'employeeview', 
    component: EmployeeViewComponent,
    resolve: {employees: EmployeeResolver}
  },
  { 
    path: 'employerview', 
    component: EmployerviewComponent,
    resolve: {employers: EmployerResolver}
  },
  { path: 'errorview/:errorNumber', component: ErrorDetailedViewComponent},
  { path: 'employerview/:recordID', component: EmployerDetailedViewComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
