package com.nanddgroup.restauranthelper.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

import com.nanddgroup.restauranthelper.Data.Information;
import com.nanddgroup.restauranthelper.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CashPayActivity extends AppCompatActivity {
    @Bind(R.id.tvPlace_cashActivity)
    TextView tvPlace_cashActivity;
    @Bind(R.id.tvTimeCheque)
    TextView tvTimeCheque;
    @Bind(R.id.bCashPay)
    Button bCashPay;
    private String pleceOfOrder;
    private int positionToDelete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cash_pay);
        ButterKnife.bind(this);
        Intent intent = getIntent();
        positionToDelete = intent.getIntExtra("POSITION", 100);
        pleceOfOrder = intent.getExtras().getString(Information.PLACE);
        tvPlace_cashActivity.setText(pleceOfOrder);
        tvTimeCheque.setText(String.valueOf(new SimpleDateFormat(" MM-dd \n HH:mm")
                .format(Calendar.getInstance().getTimeInMillis())));
    }

    @OnClick(R.id.bCashPay)
    public void bCashPay() {

        if (bCashPay.getText().equals("Done")) {
            Intent intent = new Intent();
            intent.putExtra("to_Delete", positionToDelete);
            setResult(RESULT_OK, intent);
            finish();
        }

        //Send on printer by WIFI request for printing cheque
        bCashPay.setText("Done");
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent();
        intent.putExtra("to_Delete", positionToDelete);
        setResult(RESULT_CANCELED, intent);
        finish();
    }
}
