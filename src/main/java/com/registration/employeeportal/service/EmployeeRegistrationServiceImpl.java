package com.registration.employeeportal.service;

import com.registration.employeeportal.repository.EmployeeRepository;
import com.registration.employeeportal.entity.EmployeeEntity;
import com.registration.employeeportal.model.EmployeeDto;
import com.registration.employeeportal.util.Constant;
import com.registration.employeeportal.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.*;

@Service
public class EmployeeRegistrationServiceImpl implements EmployeeRegistrationService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public String register(EmployeeDto employeeDto) {
        try {
            EmployeeEntity employeeEntity = new EmployeeEntity();
            employeeEntity.setId(employeeDto.getId());
            employeeEntity.setFirstName(employeeDto.getFirstName());
            employeeEntity.setLastName(employeeDto.getLastName());
            employeeEntity.setDepartment(employeeDto.getDepartment());
            employeeEntity.setDateOfBirth(employeeDto.getDateOfBirth());
            employeeEntity.setGender(employeeDto.getGender());
            employeeRepository.save(employeeEntity);
            return Constant.RES_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return Constant.RES_FAILURE;
        }
    }

    @Override
    public Map<String, Object> findAllRegisteredEmployees() {
        Map<String, Object> responseMap = new HashMap<>();
        List<EmployeeDto> employeeDtoList = new ArrayList<>();
        employeeRepository.findAll().forEach( employeeEntity ->  {
            System.out.println("ID.."+employeeEntity.getId());
            EmployeeDto employeeDto = new EmployeeDto();
            employeeDto.setId(employeeEntity.getId());
            employeeDto.setFirstName(employeeEntity.getFirstName());
            employeeDto.setLastName(employeeEntity.getLastName());
            employeeDto.setDepartment(employeeEntity.getDepartment());
            employeeDto.setDateOfBirth(employeeEntity.getDateOfBirth());
            employeeDtoList.add(employeeDto);
        });
        employeeDtoList.stream().sorted(new Comparator<EmployeeDto>() {
            @Override
            public int compare(EmployeeDto o1, EmployeeDto o2) {
                return o1.getFirstName().toLowerCase().compareTo(o2.getFirstName().toLowerCase());
            }
        });
        responseMap.put(ResponseMapKey.DATA.literal(), employeeDtoList);
        return responseMap;
    }
}
