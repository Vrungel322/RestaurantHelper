package com.nanddgroup.restauranthelper;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TaxiCallActivity extends AppCompatActivity {
    @Bind(R.id.tvPlace_taxiActivity)TextView tvPlace_taxiActivity;
    @Bind(R.id.ivCall) ImageView ivCall;
    @Bind(R.id.bDone) Button bDone;
    public static int positionToDelete;
    private ListHelper listHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_taxi_call);
        ButterKnife.bind(this);
        Intent intent = getIntent();
        positionToDelete = intent.getIntExtra("POSITION", 100);
        tvPlace_taxiActivity.setText(intent.getExtras().getString(Information.PLACE));
    }

    @OnClick({R.id.ivCall, R.id.ivCall1, R.id.ivCall2,
            R.id.ivCall3, R.id.ivCall4, R.id.ivCall5, R.id.ivCall6})
    public void CallTaxiNumber() {
        Intent intent = new Intent(Intent.ACTION_CALL);

        intent.setData(Uri.parse("tel:" + "123"));
        if (ActivityCompat.checkSelfPermission(this,
                Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        startActivity(intent);
    }

    @OnClick(R.id.bDone)
    public void onDone(){
        Toast.makeText(getApplicationContext(),
                "onItem Clicked: " + positionToDelete, Toast.LENGTH_SHORT).show();
        Intent intent = new Intent();
        intent.putExtra("to_Delete", positionToDelete);
        setResult(RESULT_OK, intent);
        finish();
    }
}
