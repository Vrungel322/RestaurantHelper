package com.nanddgroup.restauranthelper.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.nanddgroup.restauranthelper.Data.FoodItem;
import com.nanddgroup.restauranthelper.R;

import java.util.List;

public class AdapterFoodItem extends ArrayAdapter<FoodItem> {
    private Context context;
    private List<FoodItem> lFoodItem;

    public AdapterFoodItem(Context context, int resource, List<FoodItem> lFoodItem) {
        super(context, resource, lFoodItem);
        this.context = context;
        this.lFoodItem = lFoodItem;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View rootView = null;
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater)
                    context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            rootView = inflater.inflate(R.layout.fragment_fooditem, parent, false);
        } else {
            rootView = convertView;
        }
        ImageView ivFoodLogo = (ImageView) rootView.findViewById(R.id.ivFoodLogo);
        ivFoodLogo.setImageResource(lFoodItem.get(position).getFoodTypeRes());
        TextView tvNameOfItemInOrder = (TextView) rootView.findViewById(R.id.tvNameOfItemInOrder);
        tvNameOfItemInOrder.setText(lFoodItem.get(position).getOrderName());
        TextView tvPrice = (TextView) rootView.findViewById(R.id.tvPrice);
        tvPrice.setText(String.valueOf(lFoodItem.get(position).getPrice()));

        return rootView;
    }
}
