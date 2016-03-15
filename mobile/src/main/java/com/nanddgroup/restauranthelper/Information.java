package com.nanddgroup.restauranthelper;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by Nikita on 15.03.2016.
 */
public class Information {
    protected String sTime;
    protected String sPlace;
    protected String sCode;

    public Information(String sTime, String sPlace, String sCode) {
        this.sCode = sCode;
        this.sPlace = sPlace;
        this.sTime = sTime;
    }

    public static List<Information> getData(){
        List<Information> data = new ArrayList<>();
        for (int i = 0; i < 10; i++){
            data.add(new Information(String.valueOf(new SimpleDateFormat("MM-dd \nHH:mm:ss.SSS")
                    .format(Calendar.getInstance().getTimeInMillis())), "16A", "Taxi_Code"));
        }
        return data;
    }
}
