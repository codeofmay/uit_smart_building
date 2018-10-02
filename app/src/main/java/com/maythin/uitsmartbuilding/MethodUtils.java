package com.maythin.uitsmartbuilding;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by mt on 10/2/18.
 */

public class MethodUtils {

    public static String getCurrentDate(){
        Date c = new Date();
        SimpleDateFormat df = new SimpleDateFormat("dd/MMM/yyyy");
        String formattedDate = df.format(c);
        return formattedDate;
    }
}
