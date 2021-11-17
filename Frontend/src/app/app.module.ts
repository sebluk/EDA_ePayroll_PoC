import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavbarComponent } from './navbar/navbar.component';
import { ErrorViewComponent } from './errorview/errorview.component';
import { ErrorsService } from './errorview/errorview.service';
import { EmployeeViewComponent } from './employeeview/employeeview.component';
import { EmployerviewComponent } from './employerview/employerview.component';
import { EmployerDetailedViewComponent } from './employerview/employerdetailedview.component';
import { EmployerService } from './employerview/employerview.service';
import { EmployeeService } from './employeeview/employeeview.service';
import { HttpClientModule } from "@angular/common/http";
import { ErrorsResolver } from './errorview/errorview-resolver.service';
import { EmployerResolver } from './employerview/employerview-resolver.service';
import { EmployeeResolver } from './employeeview/employeeview-resolver.service';
import { FormsModule } from '@angular/forms';
import { MySearchPipe } from './pipe/mySearchPipe.module';
import { ErrorDetailedViewComponent } from './errorview/errordetailedview.component';
import { EmployeeDetailedViewComponent } from './employeeview/employeedetailedview.component';


@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    ErrorViewComponent,
    EmployeeViewComponent,
    EmployeeDetailedViewComponent,
    EmployerviewComponent,
    EmployerDetailedViewComponent,
    ErrorDetailedViewComponent,
    MySearchPipe
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [
      ErrorsService, 
      EmployerService, 
      EmployeeService,
      ErrorsResolver, 
      EmployerResolver, 
      EmployeeResolver,
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
