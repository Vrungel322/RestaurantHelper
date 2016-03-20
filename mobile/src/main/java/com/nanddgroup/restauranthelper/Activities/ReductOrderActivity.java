package com.nanddgroup.restauranthelper.Activities;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

import com.nanddgroup.restauranthelper.Data.FoodItem;
import com.nanddgroup.restauranthelper.Data.Information;
import com.nanddgroup.restauranthelper.Fragments.FoodListFragment;
import com.nanddgroup.restauranthelper.Fragments.PaymentFragment;
import com.nanddgroup.restauranthelper.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ReductOrderActivity extends AppCompatActivity {
    @Bind(R.id.tvPlace_reductOrderActivity)
    TextView tvPlace_redactOrderActivity;
    @Bind(R.id.tvExactlyPrice)
    TextView tvExactlyPrice;
    @Bind(R.id.bRelease)
    Button bRelease;
    private int positionToDelete;
    private String pleceOfOrder;
    private FoodListFragment lfFood;
    private PaymentFragment paymentFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reduct_order);
        ButterKnife.bind(this);
        Intent intent = getIntent();
        positionToDelete = intent.getIntExtra("POSITION", 100);
        pleceOfOrder = intent.getExtras().getString(Information.PLACE);
        tvPlace_redactOrderActivity.setText(pleceOfOrder);
        lfFood = new FoodListFragment();
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.flTypeOfFood, lfFood);
        fragmentTransaction.commit();
        tvExactlyPrice.setText(String.valueOf(FoodItem.getTotalPrice()));

    }

    @OnClick(R.id.bRelease)
    public void bReleaceClicked() {

        if (paymentFragment != null && getFragmentManager().findFragmentByTag("paymentFragment").isVisible()) {
            Intent intent = new Intent();
            intent.putExtra("to_Delete", positionToDelete);
            setResult(RESULT_OK, intent);
            finish();
        }
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        paymentFragment = new PaymentFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("positionToDelete", positionToDelete);
        bundle.putString("pleceOfOrder", pleceOfOrder);
        paymentFragment.setArguments(bundle);
        fragmentTransaction.replace(R.id.flTypeOfFood, paymentFragment, "paymentFragment");
        fragmentTransaction.commit();
        bRelease.setText("Checkout");
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent();
        intent.putExtra("to_Delete", positionToDelete);
        setResult(RESULT_CANCELED, intent);
        finish();
    }
}
