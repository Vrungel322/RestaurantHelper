package com.nanddgroup.restauranthelper;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;

public class TaxiCallActivity extends AppCompatActivity {
    @Bind(R.id.tvPlace_taxiActivity) TextView tvPlace_taxiActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_taxi_call);
        ButterKnife.bind(this);
        Intent intent = getIntent();
        tvPlace_taxiActivity.setText(intent.getExtras().getString(Information.PLACE));
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
