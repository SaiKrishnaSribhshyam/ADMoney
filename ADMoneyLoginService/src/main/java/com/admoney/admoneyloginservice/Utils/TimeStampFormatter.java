package com.admoney.admoneyloginservice.Utils;

import com.admoney.admoneyloginservice.Models.UserOTP;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class TimeStampFormatter {
    private static SimpleDateFormat dateFormat=new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
    private static Logger logger= LoggerFactory.getLogger(UserOTP.class);

    public static String getCurrentTimeStamp(){
        return dateFormat.format(Calendar.getInstance().getTime());
    }
    public static long getTimeStampinMillis(String timeStamp){
        try {
            return dateFormat.parse(timeStamp).toInstant().toEpochMilli();
        }
        catch (ParseException e){
            logger.error("Date format conversion exception",e);
        }
        return 0l;
    }
}
