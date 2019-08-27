import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, FormControl, Validators } from '@angular/forms';
import { employee } from 'src/app/model/employee.model';
import { EmployeeRegistrationService } from 'src/app/services/employeeRegistration.service';

@Component({
  selector: 'app-first',
  templateUrl: './employeeRegistration.component.html',
  styleUrls: ['./employeeRegistration.component.css']
})
export class EmployeeRegistrationComponent implements OnInit {
  formGroup: FormGroup;
  firstName: string;
  lastName: string;
  gender: string;
  dateOfBirth: string;
  department: string;
  constructor(private formBuilder: FormBuilder, private employeeRegistrationService: EmployeeRegistrationService) {
    this.initializeForm();
   }

  ngOnInit() {
  }

  initializeForm() {
    this.formGroup = this.formBuilder.group({
      'firstName': [null],
      'lastName': [null],
      'gender': [null],
      'dateOfBirth': [null],
      'department': [null]
    });
  }

  reset() {
    this.initializeForm();
  }

  submit() {
    this.firstName = this.formGroup.controls['firstName'].value;
    this.lastName = this.formGroup.controls['lastName'].value;
    this.dateOfBirth = this.formGroup.controls['dateOfBirth'].value;
    this.department = this.formGroup.controls['department'].value;
    this.gender = this.formGroup.controls['gender'].value;

    console.log('..firstName..' + this.firstName);
    console.log('..lastName..' + this.lastName);
    console.log('..dateOfBirth..' + this.dateOfBirth);
    console.log('..department..' + this.department);
    console.log('..gender..' + this.gender);

    const params : employee = {
      firstName: this.firstName,
      lastName: this.lastName,
      dateOfBirth: this.dateOfBirth,
      department: this.department,
      gender: this.gender
    }

    this.employeeRegistrationService.registerEmployee(params).subscribe(data => {
      console.log("Printing data.." + data);
    });

  }
}
