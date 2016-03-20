package com.nanddgroup.restauranthelper.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

import com.nanddgroup.restauranthelper.Data.Information;
import com.nanddgroup.restauranthelper.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CutleryActivity extends AppCompatActivity {
    @Bind(R.id.bDone)
    Button bDone;
    @Bind(R.id.tvPlace_cutleryActivity)
    TextView tvPlace_cutleryActivity;
    public int positionToDelete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cutlery);
        ButterKnife.bind(this);
        Intent intent = getIntent();
        positionToDelete = intent.getIntExtra("POSITION", 100);
        tvPlace_cutleryActivity.setText(intent.getExtras().getString(Information.PLACE));
    }

    @OnClick(R.id.bDone)
    public void onDone() {
        ;
        Intent intent = new Intent();
        intent.putExtra("to_Delete", positionToDelete);
        setResult(RESULT_OK, intent);
        finish();
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent();
        intent.putExtra("to_Delete", positionToDelete);
        setResult(RESULT_CANCELED, intent);
        finish();
    }
}
