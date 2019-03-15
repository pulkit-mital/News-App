package com.pulkit.newsapp.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class DateUtil {

    private static DateUtil dateUtil;

    public static DateUtil getInstance(){
        if(dateUtil == null){
            dateUtil = new DateUtil();
        }

        return dateUtil;
    }

    public String formatDate(String date){

        try {
            SimpleDateFormat oldFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
            Date formattedDate = oldFormat.parse(date);

            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd MMM, yyyy");
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("Asia/Kolkata"));
            return simpleDateFormat.format(formattedDate);

        }catch (ParseException ex){
            ex.printStackTrace();
        }
        return "";
    }
}
