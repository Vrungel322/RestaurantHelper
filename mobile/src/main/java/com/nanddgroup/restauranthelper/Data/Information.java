package com.nanddgroup.restauranthelper.Data;

import com.nanddgroup.restauranthelper.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


/**
 * Created by Nikita on 15.03.2016.
 */
public class Information {
    public static final String PLACE = "PLACE_OF_CALL";
    public static final int TAXI_CODE = 1;
    public static final int CUTLERY_CODE = 2;
    public static final int PAY_CARD_CODE = 3;
    public static final int REDUCT_ORDER = 4;
    public static final int CASH_PAY = 5;
    public static final String POSITION = "POSITION";
    public static final String sCUTLERY_CODE = "Cutlery_Code";
    public static final String sTAXI_CODE = "Taxi_Code";
    public static final String sPAY_CARD_CODE = "PAY_CARD_CODE";
    public static final String sREDUCT_ORDER = "REDUCT_ORDER";
    public static final String sCASH_PAY = "CASH_PAY";
    protected String sTime;
    protected String sPlace;
    protected String tag;
    protected int sCode;

    public Information(String sTime, String sPlace, String tag, int sCode) {
        this.sCode = sCode;
        this.sPlace = sPlace;
        this.sTime = sTime;
        this.tag = tag;

    }

    public static List<Information> getData() {
        List<Information> data = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            data.add(new Information(String.valueOf(new SimpleDateFormat(" MM-dd \n HH:mm")
                    .format(Calendar.getInstance().getTimeInMillis())),
                    "16A", "Taxi_Code", R.drawable.taxi_logo));
        }
        return data;
    }

    public String getsTime() {
        return sTime;
    }

    public int getsCode() {
        return sCode;
    }

    public String getsPlace() {
        return sPlace;
    }

    public String getTag() {
        return tag;
    }
}
