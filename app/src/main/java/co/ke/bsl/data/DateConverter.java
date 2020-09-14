package co.ke.bsl.data;


import androidx.room.TypeConverter;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateConverter {

    @TypeConverter
    public static Date toDate(long dateLong) {
        return new Date(dateLong);
    }

    @TypeConverter
    public static long fromDateToLong(Date date) {
        return date.getTime();
    }

    public static Date toDate(String dateString) {
        String PATTERN_1 = "yyyy-MM-dd";
        String PATTERN_2 = "yyyy-MM-dd HH:mm:ss";
        Date myDate;
        DateFormat formatter = new SimpleDateFormat(PATTERN_1);
        try{
            myDate = formatter.parse(dateString);
            return myDate;
        } catch(Exception e){
            try{
                formatter = new SimpleDateFormat(PATTERN_2);
                myDate = formatter.parse(dateString);
                return myDate;
            } catch(Exception ex){
                System.out.println("Error is : " + ex.getMessage());
                ex.printStackTrace();
                return null;
            }
        }

    }

    public static String fromDateToString(Date date){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        String endingDate = cal.get(Calendar.DAY_OF_MONTH) + "-" + (cal.get(Calendar.MONTH)+1) + "-" + cal.get(Calendar.YEAR);

        return endingDate;
    }
}