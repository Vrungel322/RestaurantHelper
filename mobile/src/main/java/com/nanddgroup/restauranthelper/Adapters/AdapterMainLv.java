package com.nanddgroup.restauranthelper.Adapters;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.nanddgroup.restauranthelper.Data.Information;
import com.nanddgroup.restauranthelper.R;

import java.util.Collections;
import java.util.List;

/**
 * Created by Nikita on 15.03.2016.
 */
public class AdapterMainLv extends ArrayAdapter<Information> {
    private List<Information> data = Collections.emptyList();
    private Context context;

    public AdapterMainLv(Context context, int resource, List<Information> data) {
        super(context, resource, data);
        this.context = context;
        this.data = data;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View rootView = null;
        if (convertView == null) {
            LayoutInflater inflater =
                    (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            rootView = inflater.inflate(R.layout.custom_row, parent, false);
        } else {
            rootView = convertView;
        }
//        //
//        LinearLayout ll0 = (LinearLayout) rootView.findViewById(R.id.linearLayout0);
//        LinearLayout ll1 = (LinearLayout) rootView.findViewById(R.id.linearLayout1);
//        LinearLayout ll2 = (LinearLayout) rootView.findViewById(R.id.linearLayout2);
//        //

        TextView tvTime = (TextView) rootView.findViewById(R.id.tvTime);
        tvTime.setText(data.get(position).getsTime());
        TextView tvPlace = (TextView) rootView.findViewById(R.id.tvPlace);
        tvPlace.setText(data.get(position).getsPlace());
        TextView tvCode = (TextView) rootView.findViewById(R.id.tvCode);
        tvCode.setText(data.get(position).getTag());
        ImageView ivLogo = (ImageView) rootView.findViewById(R.id.ivLogo);
        ivLogo.setImageResource(data.get(position).getsCode());
        CardView cardView = (CardView) rootView.findViewById(R.id.card_view);
        if (tvCode.getText().toString().equals("Taxi_Code")) {
            rootView.setTag(String.valueOf(data.get(position).getTag()));
        }
        if (tvCode.getText().toString().equals("Cutlery_Code")) {
            rootView.setTag(String.valueOf(data.get(position).getTag()));
        }
        if (tvCode.getText().toString().equals("PAY_CARD_CODE")) {
            rootView.setTag(String.valueOf(data.get(position).getTag()));
        }
        if (tvCode.getText().toString().equals("REDUCT_ORDER")) {
            rootView.setTag(String.valueOf(data.get(position).getTag()));
        }
        if (tvCode.getText().toString().equals("CASH_PAY")) {
            rootView.setTag(String.valueOf(data.get(position).getTag()));
        }
        Animation animation = AnimationUtils.loadAnimation(getContext(), R.anim.slide_top_to_bottom);
        rootView.startAnimation(animation);
        return rootView;
    }

    public List<Information> getData() {
        return data;
    }
}
