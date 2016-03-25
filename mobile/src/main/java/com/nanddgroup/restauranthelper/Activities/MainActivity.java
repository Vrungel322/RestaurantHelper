package com.nanddgroup.restauranthelper.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.nanddgroup.restauranthelper.Adapters.AdapterMainLv;
import com.nanddgroup.restauranthelper.Data.Information;
import com.nanddgroup.restauranthelper.R;
import com.nanddgroup.restauranthelper.Utils.AnimationUtils;
import com.nanddgroup.restauranthelper.Utils.ListHelper;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @Bind(R.id.lvNotifications)
    ListView lvNotifications;
    @Bind(R.id.iv)
    ImageView iv;
    private AdapterMainLv adapterMainLv;
    public static List<Information> dataList;
    private ListHelper listHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


        AnimationUtils animU = new AnimationUtils(iv);
        animU.init();


        listHelper = new ListHelper(lvNotifications, dataList, adapterMainLv,
                getApplicationContext());
        listHelper.init();
        listHelper.getLvNotifications().setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, final View view, final int position, long id) {
                ScaleAnimation sc = new ScaleAnimation(1.0f, 1.1f, 1.0f, 1.1f, 1, 0.5f, 1, 0.5f);
                sc.setDuration(100);
                sc.setRepeatCount(1);
                sc.setRepeatMode(2);
                sc.setAnimationListener(new Animation.AnimationListener() {
                    public void onAnimationStart(Animation animation) {
                    }

                    public void onAnimationEnd(Animation animation) {
                        filterOnEachItem(view, position);
                    }

                    public void onAnimationRepeat(Animation animation) {
                    }
                });
                view.startAnimation(sc);
            }
        });

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Snackbar.make(view, "Notification Added", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
                listHelper.addItem();
            }
        });
    }

    private void filterOnEachItem(View view, int position) {
        if (view.getTag().equals("Taxi_Code")) {
            Intent intent = new Intent(getApplicationContext(), TaxiCallActivity.class);
            intent.putExtra(Information.POSITION, position);
            String sp = ((TextView) view.findViewById(R.id.tvPlace)).getText().toString();
            intent.putExtra(Information.PLACE, sp);
            startActivityForResult(intent, Information.TAXI_CODE);
        }
        if (view.getTag().equals("Cutlery_Code")) {
            Intent intent = new Intent(getApplicationContext(), CutleryActivity.class);
            intent.putExtra(Information.POSITION, position);
            String sp = ((TextView) view.findViewById(R.id.tvPlace)).getText().toString();
            intent.putExtra(Information.PLACE, sp);
            startActivityForResult(intent, Information.CUTLERY_CODE);
        }
        if (view.getTag().equals("PAY_CARD_CODE")) {
            Intent intent = new Intent(getApplicationContext(), PayByCardActivity.class);
            intent.putExtra(Information.POSITION, position);
            String sp = ((TextView) view.findViewById(R.id.tvPlace)).getText().toString();
            intent.putExtra(Information.PLACE, sp);
            startActivityForResult(intent, Information.PAY_CARD_CODE);
        }
        if (view.getTag().equals("REDUCT_ORDER")) {
            Intent intent = new Intent(getApplicationContext(), ReductOrderActivity.class);
            intent.putExtra(Information.POSITION, position);
            String sp = ((TextView) view.findViewById(R.id.tvPlace)).getText().toString();
            intent.putExtra(Information.PLACE, sp);
            startActivityForResult(intent, Information.REDUCT_ORDER);
        }
        if (view.getTag().equals("CASH_PAY")) {
            Intent intent = new Intent(getApplicationContext(), CashPayActivity.class);
            intent.putExtra(Information.POSITION, position);
            String sp = ((TextView) view.findViewById(R.id.tvPlace)).getText().toString();
            intent.putExtra(Information.PLACE, sp);
            startActivityForResult(intent, Information.CASH_PAY);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Bundle bundle = data.getExtras();
        int pos = bundle.getInt("to_Delete");
        if (requestCode == Information.TAXI_CODE && resultCode == RESULT_OK) {
            listHelper.deleteItem(pos);
        }
        if (requestCode == Information.CUTLERY_CODE && resultCode == RESULT_OK) {
            listHelper.deleteItem(pos);
        }
        if (requestCode == Information.PAY_CARD_CODE && resultCode == RESULT_OK) {
            listHelper.deleteItem(pos);
        }
        if (requestCode == Information.REDUCT_ORDER && resultCode == RESULT_OK) {
            listHelper.deleteItem(pos);
        }
        if (requestCode == Information.CASH_PAY && resultCode == RESULT_OK) {
            listHelper.deleteItem(pos);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
