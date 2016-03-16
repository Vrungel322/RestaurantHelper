package com.nanddgroup.restauranthelper;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity  {
    @Bind(R.id.lvNotifications)ListView lvNotifications;
    private AdapterMainLv adapterMainLv;
    public static List<Information> dataList;
    private ListHelper listHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
        listHelper = new ListHelper(lvNotifications, dataList, adapterMainLv, getApplicationContext());
        listHelper.init();
        listHelper.getLvNotifications().setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (view.getTag().equals("Taxi_Code")) {
                    Intent intent = new Intent(getApplicationContext(), TaxiCallActivity.class);
                    intent.putExtra("POSITION", position);
                    startActivityForResult(intent, Information.TAXI_CODE);
                }
            }
        });

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Notification Added", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                listHelper.addIem();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Bundle bundle = data.getExtras();
        int pos = bundle.getInt("to_Delete");
        Toast.makeText(getApplicationContext(), "come : " + pos, Toast.LENGTH_SHORT).show();
        if (requestCode == Information.TAXI_CODE){
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
