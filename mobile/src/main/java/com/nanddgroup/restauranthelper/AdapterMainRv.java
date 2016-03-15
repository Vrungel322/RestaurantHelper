package com.nanddgroup.restauranthelper;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Collections;
import java.util.List;

/**
 * Created by Nikita on 15.03.2016.
 */
public class AdapterMainRv extends RecyclerView.Adapter<AdapterMainRv.MainViewHolder> {
    private LayoutInflater layoutInflater;
    private List<Information> data = Collections.emptyList();
    private Context context;

    public AdapterMainRv(Context context, List<Information> data) {
        layoutInflater = layoutInflater.from(context);
        this.context = context;
        this.data = data;
    }

    @Override
    public MainViewHolder onCreateViewHolder(final ViewGroup parent, int viewType) {
        final View view = layoutInflater.inflate(R.layout.custom_row, parent, false);
        MainViewHolder holder = new MainViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(final MainViewHolder holder, int position) {
        Information currentInf = data.get(position);

        holder.tvTime.setText(currentInf.sTime);
        holder.tvPlace.setText(currentInf.sPlace);
        holder.tvCode.setText(currentInf.sCode);
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "" + holder.tvCode.getText(),
                        Toast.LENGTH_SHORT).show();
                if (holder.tvCode.getText().equals("Taxi_Code")){
                    Intent taxiIntent = new Intent(context, TaxiCallActivity.class);
                    taxiIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    //taxiIntent.putExtra(Information.CODE, holder.tvCode.getText());
                    taxiIntent.putExtra(Information.PLACE, holder.tvPlace.getText());
                    context.startActivity(taxiIntent);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class MainViewHolder extends RecyclerView.ViewHolder{
        private TextView tvTime;
        private TextView tvPlace;
        private TextView tvCode;
        private CardView cardView;

        public MainViewHolder(View itemView) {
            super(itemView);
            tvTime = (TextView) itemView.findViewById(R.id.tvTime);
            tvPlace = (TextView) itemView.findViewById(R.id.tvPlace);
            tvCode = (TextView) itemView.findViewById(R.id.tvCode);
            cardView = (CardView) itemView.getRootView();
        }
    }
}
