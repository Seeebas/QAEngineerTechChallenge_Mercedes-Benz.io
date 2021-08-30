package com.helpers.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class StringUtils {

    public static String getDateAndTime(){
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        return df.format(LocalDateTime.now());
    }

    public static String concatenate(String... values){
        StringBuffer sb = new StringBuffer();

        for(String value : values){
            sb.append(value);
        }
        return sb.toString();
    }
}
