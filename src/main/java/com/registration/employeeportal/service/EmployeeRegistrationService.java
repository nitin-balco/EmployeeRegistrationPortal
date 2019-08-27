package com.registration.employeeportal.service;

import com.registration.employeeportal.entity.EmployeeEntity;
import com.registration.employeeportal.model.EmployeeDto;

import java.util.List;
import java.util.Map;

public interface EmployeeRegistrationService {

    String register(EmployeeDto employeeDto);

    Map<String, Object> findAllRegisteredEmployees();

}
