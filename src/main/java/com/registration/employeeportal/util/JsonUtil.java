package com.registration.employeeportal.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class JsonUtil {

    @Autowired
    private ObjectMapper objectMapper;

    public String convertStringToJson(Object object) {
        String json = null;
        try {
            json = objectMapper.writeValueAsString(object);
        } catch (JsonProcessingException jpe) {
          jpe.printStackTrace();
        }
        return json;
    }
}
