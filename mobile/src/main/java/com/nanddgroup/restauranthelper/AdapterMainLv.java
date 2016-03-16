package com.nanddgroup.restauranthelper;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

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
        if (convertView == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            rootView = inflater.inflate(R.layout.custom_row, parent, false);
        }
        else {
            rootView = convertView;
        }
        rootView.setTag(String.valueOf(data.get(position).sCode));

        TextView tvTime = (TextView) rootView.findViewById(R.id.tvTime);
        tvTime.setText(data.get(position).sTime);
        TextView tvPlace = (TextView) rootView.findViewById(R.id.tvPlace);
        tvPlace.setText(data.get(position).sPlace);
        final TextView tvCode = (TextView) rootView.findViewById(R.id.tvCode);
        tvCode.setText(data.get(position).sCode);
        CardView cardView = (CardView) rootView.findViewById(R.id.card_view);
        return rootView;
    }

    public List<Information> getData() {
        return data;
    }
}
