import { Component, OnInit } from '@angular/core';
import { ViewChild} from '@angular/core';
import {MatPaginator, MatSort, MatTableDataSource} from '@angular/material';
import { employee } from 'src/app/model/employee.model';
import { EmployeeRegistrationService } from 'src/app/services/employeeRegistration.service';

@Component({
  selector: 'app-second',
  templateUrl: './employeeListView.component.html',
  styleUrls: ['./employeeListView.component.css']
})
export class EmployeeListViewComponent implements OnInit {
  displayedColumns = ['First Name', 'Last Name', 'Gender', 'Date Of Birth', 'Department'];
  dataSource: MatTableDataSource<employee>;

  @ViewChild(MatPaginator) paginator: MatPaginator;
  @ViewChild(MatSort) sort: MatSort;

  constructor(private employeeRegistrationService : EmployeeRegistrationService ) { 
    this.employeeRegistrationService.getAllRegisteredEmployees().subscribe(
      data => {
        console.log('Printing registered employees list'+data);
    });
  }
  ngOnInit() {
   
  }

}
