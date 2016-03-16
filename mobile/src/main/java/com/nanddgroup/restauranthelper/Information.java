package com.nanddgroup.restauranthelper;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by Nikita on 15.03.2016.
 */
public class Information {
    public static final String sCODE = "CODE";
    public static final int iCODE_taxi = 24;
    public static final String PLACE = "PLACE";
    public static final int TAXI_CODE = 1;
    public static final int DONE = 1;
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
        for (int i = 0; i < 5; i++){
            data.add(new Information(String.valueOf(new SimpleDateFormat("MM-dd \nHH:mm:ss")
                    .format(Calendar.getInstance().getTimeInMillis())), "16A", "Taxi_Code"));
        }
        return data;
    }

    public String getsTime() {
        return sTime;
    }

    public String getsCode() {
        return sCode;
    }

    public String getsPlace() {
        return sPlace;
    }
}
