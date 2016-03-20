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

public class PayByCardActivity extends AppCompatActivity {
    @Bind(R.id.bDone)
    Button bDone;
    @Bind(R.id.tvPlace_payByCardActivity)
    TextView tvPlace_payByCardActivity;
    public int positionToDelete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay_by_card);
        ButterKnife.bind(this);
        Intent intent = getIntent();
        positionToDelete = intent.getIntExtra("POSITION", 100);
        tvPlace_payByCardActivity.setText(intent.getExtras().getString(Information.PLACE));
    }

    //TODO check if number of card is correct

    @OnClick(R.id.bDone)
    public void onDone() {
        //In app purchase
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
