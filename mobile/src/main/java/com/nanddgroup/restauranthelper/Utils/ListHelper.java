package com.nanddgroup.restauranthelper.Utils;

import android.content.Context;
import android.widget.ListView;

import com.nanddgroup.restauranthelper.Adapters.AdapterMainLv;
import com.nanddgroup.restauranthelper.Data.Information;
import com.nanddgroup.restauranthelper.R;

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
    private NotificationHelper notificationHelper;
    private int arrayLogo[] = {R.drawable.cutlery_logo,
            R.drawable.taxi_logo,
            R.drawable.pay_card,
            R.drawable.man_logo,
            R.drawable.cash_logo};
    private String arrayCode[] = {Information.sCUTLERY_CODE,
            Information.sTAXI_CODE,
            Information.sPAY_CARD_CODE,
            Information.sREDUCT_ORDER,
            Information.sCASH_PAY};


    public ListHelper(ListView lvNotifications, List<Information> dataList,
                      AdapterMainLv adapterMainLv, Context context) {
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

    public void deleteItem(int pos) {
        dataList.remove(pos);
        adapterMainLv.notifyDataSetChanged();
    }

    public void addItem() {
        int currentLogo = (int) (Math.random() * arrayLogo.length);
        //Notification Stuff
        notificationHelper = new NotificationHelper(context, arrayLogo[currentLogo]);
        notificationHelper.show();

        dataList.add(0, new Information(String.valueOf(new SimpleDateFormat(" MM-dd \n HH:mm")
                .format(Calendar.getInstance().getTimeInMillis())),
                "24B", arrayCode[currentLogo], arrayLogo[currentLogo]));
        adapterMainLv.notifyDataSetChanged();
    }

    public ListView getLvNotifications() {
        return lvNotifications;
    }
}
