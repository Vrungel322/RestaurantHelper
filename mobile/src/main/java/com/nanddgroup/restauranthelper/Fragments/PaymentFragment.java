package com.nanddgroup.restauranthelper.Fragments;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.nanddgroup.restauranthelper.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class PaymentFragment extends Fragment {
    private int positionToDelete;
    private String pleceOfOrder;


    public PaymentFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_payment, container, false);
        positionToDelete = getArguments().getInt("positionToDelete");
        pleceOfOrder = getArguments().getString("pleceOfOrder");

        final EditText input_card_number_fragment = (EditText) rootView
                .findViewById(R.id.input_card_number_fragment);
        input_card_number_fragment.setVisibility(View.GONE);

        final TextView tvGiveCheck = (TextView) rootView.findViewById(R.id.tvGiveCheck);
        tvGiveCheck.setVisibility(View.GONE);

        final Button bCreditCard = (Button) rootView.findViewById(R.id.bCreditCard);
        bCreditCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bCreditCard.setVisibility(View.GONE);
                input_card_number_fragment.setVisibility(View.VISIBLE);
            }
        });
        final Button bCash = (Button) rootView.findViewById(R.id.bCash);
        bCash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bCreditCard.setVisibility(View.VISIBLE);
                bCash.setVisibility(View.GONE);
                tvGiveCheck.setVisibility(View.VISIBLE);
                input_card_number_fragment.setVisibility(View.GONE);
            }
        });
        tvGiveCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bCash.setVisibility(View.VISIBLE);
                tvGiveCheck.setVisibility(View.GONE);

            }
        });
        return rootView;
    }
}
