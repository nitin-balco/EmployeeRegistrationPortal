package com.registration.employeeportal.util;

import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class DateUtil {

    public static final String DD_MM_YYYY_FORMAT = "dd-MM-yyyy";

    public Date fromString(String dateAsString, String format) {
        SimpleDateFormat formatter = new SimpleDateFormat(format);
        if(dateAsString == null) {
            throw new NullPointerException("Date string is null");
        }
        if(format == null) {
            throw new NullPointerException("Format string is null");
        }
        try{
            return formatter.parse(dateAsString.trim());
        } catch (ParseException e) {
          throw new IllegalArgumentException(String.format("Invalid data string"));
        }
    }

    public String fromDate(Date date, String format) {
        if(date == null) {
            throw new NullPointerException("Date is null");
        }
        if(format == null) {
            throw new NullPointerException("Format is null");
        }
        SimpleDateFormat formatter = new SimpleDateFormat();
        return formatter.format(date);
    }
}
