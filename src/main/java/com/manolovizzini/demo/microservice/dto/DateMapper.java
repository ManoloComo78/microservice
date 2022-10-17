package com.manolovizzini.demo.microservice.dto;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author mviz - 17/10/2022
 * @version 1.0-SNAPSHOT
 */
public class DateMapper {

    public final static String pattern = "dd/MM/yyyy";

    public String asString(LocalDateTime date) {
        return date != null ? DateTimeFormatter.ofPattern(pattern).format(date) : null;
    }

    public LocalDateTime asDate(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        return date != null ? LocalDateTime.parse(date, formatter) : null;
    }
}
