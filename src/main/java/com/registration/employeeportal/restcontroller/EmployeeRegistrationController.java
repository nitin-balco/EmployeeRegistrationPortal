package com.registration.employeeportal.restcontroller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.registration.employeeportal.model.EmployeeDto;
import com.registration.employeeportal.model.EmployeeEntityBO;
import com.registration.employeeportal.service.EmployeeRegistrationService;
import com.registration.employeeportal.service.ResponseMapKey;
import com.registration.employeeportal.util.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@RestController
public class EmployeeRegistrationController {

    @Autowired
    private EmployeeRegistrationService employeeRegistrationService;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private JsonUtil jsonUtil;

    @RequestMapping(value = "/getAllRegisteredEmployees", method = RequestMethod.GET, headers = "Accept=application/json")
    private @ResponseBody String getAllRegisteredEmployees() {
        String json = null;
        Map<String, Object> responseMap = employeeRegistrationService.findAllRegisteredEmployees();
        if(responseMap.get("data")==null) {
            json = "";
        } else {
            json = new JsonUtil().convertStringToJson(responseMap.get("data"));
        }
        System.out.println("Json string in getAllRegisteredEmployees()..."+json);
        return json;
    }

    @RequestMapping(value = "/registerEmployee", method = RequestMethod.POST, headers = "Accept=application/json")
    private @ResponseBody String registerEmployee(@RequestBody String employeeRegJson) {
        System.out.println("Printing employeeRegJson ===" + employeeRegJson);
        Map<String, String> responseMap = new HashMap<>();
        try {
            EmployeeDto employeeDto = objectMapper.readValue(employeeRegJson, EmployeeDto.class);
            responseMap.put(ResponseMapKey.DATA.literal(), employeeRegistrationService.register(objectMapper.readValue(employeeRegJson, EmployeeDto.class)));
        } catch (Exception e ) {
            return "";
        }
        return jsonUtil.convertStringToJson(responseMap.get("data"));
    }
}
