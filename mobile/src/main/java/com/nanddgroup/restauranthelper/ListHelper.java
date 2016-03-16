package com.nanddgroup.restauranthelper;

import android.content.Context;
import android.widget.ListView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

/**
 * Created by Nikita on 16.03.2016.
 */
public class ListHelper {
    private ListView lvNotifications;
    private AdapterMainLv adapterMainLv;
    private List<Information> dataList;
    private Context context;

    public ListHelper(ListView lvNotifications, List<Information> dataList, AdapterMainLv adapterMainLv, Context context) {
        this.lvNotifications = lvNotifications;
        this.dataList = dataList;
        this.adapterMainLv = adapterMainLv;
        this.context = context;
        lvNotifications.setDivider(null);
    }

    public void init() {
        dataList = Information.getData();
        adapterMainLv = new AdapterMainLv(context, R.layout.custom_row, dataList);
        lvNotifications.setAdapter(adapterMainLv);
    }

    public void deleteItem(int pos){
        dataList.remove(pos);
        adapterMainLv.notifyDataSetChanged();
    }

    public void addIem(){

        dataList.add(0, new Information(String.valueOf(new SimpleDateFormat("MM-dd \nHH:mm:ss.SSS")
                .format(Calendar.getInstance().getTimeInMillis())), "20A", "Cutlery_Code"));
        adapterMainLv.notifyDataSetChanged();
    }

    public ListView getLvNotifications() {
        return lvNotifications;
    }
}
