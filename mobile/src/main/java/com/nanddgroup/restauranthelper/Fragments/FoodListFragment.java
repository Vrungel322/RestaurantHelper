package com.nanddgroup.restauranthelper.Fragments;

import android.app.ListFragment;
import android.os.Bundle;

import com.nanddgroup.restauranthelper.Adapters.AdapterFoodItem;
import com.nanddgroup.restauranthelper.Data.FoodItem;
import com.nanddgroup.restauranthelper.R;

import java.util.List;

/**
 * Created by Nikita on 18.03.2016.
 */
public class FoodListFragment extends ListFragment {
    private List<FoodItem> foodData;
    private AdapterFoodItem afiAdapter;


    public FoodListFragment() {
        foodData = FoodItem.getData();
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        afiAdapter = new AdapterFoodItem(getActivity(), R.layout.fragment_fooditem, foodData);
        setListAdapter(afiAdapter);
    }
}
