import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { NavigationComponent } from './components/navigation/navigation.component';
import { EmployeeListViewComponent } from './components/employeeListView/employeeListView.component';
import { EmployeeRegistrationComponent } from './components/employeeRegistration/employeeRegistration.component';
import { RouterModule, Routes} from "@angular/router";
import { MaterialModule} from "./core/material.module";
import { ReactiveFormsModule } from '@angular/forms';
import { EmployeeRegistrationService } from './services/employeeRegistration.service';
import { HttpModule } from '@angular/http';


const appRoutes: Routes = [
  { path: '', component: EmployeeRegistrationComponent, data: { title: 'Employee Registration Component' } },
  { path: 'first', component: EmployeeRegistrationComponent, data: { title: 'Employee Registration' } },
  { path: 'second', component: EmployeeListViewComponent, data: { title: 'Employee List View' } }
];
@NgModule({
  declarations: [
    AppComponent,
    NavigationComponent,
    EmployeeListViewComponent,
    EmployeeRegistrationComponent
  ],
  imports: [
    BrowserModule,
    HttpModule,
    BrowserAnimationsModule,
    ReactiveFormsModule,
    RouterModule.forRoot(
      appRoutes,
      { useHash: true } // <-- debugging purposes only
    ),
    MaterialModule
  ],
  providers: [EmployeeRegistrationService],
  bootstrap: [AppComponent]
})
export class AppModule { }
