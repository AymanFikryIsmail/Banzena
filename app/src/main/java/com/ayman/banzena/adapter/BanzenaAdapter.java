package com.ayman.banzena.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ayman.banzena.R;
import com.ayman.banzena.activity.AddDataActivity;
import com.ayman.banzena.model.pojo.BanzenaPojo;

import java.util.ArrayList;
import java.util.List;

public class BanzenaAdapter extends RecyclerView.Adapter<BanzenaAdapter.MyViewHolder> {

    private Context context;
    private List<BanzenaPojo> banzenaPojos = new ArrayList<>();
    private List<BanzenaPojo> originList;

    public BanzenaAdapter(Context context, List<BanzenaPojo> banzenaPojos) {
        this.context = context;
        this.banzenaPojos = banzenaPojos;
        this.originList = new ArrayList<>();
        this.originList.addAll(banzenaPojos);

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.banzena_row, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.bind(banzenaPojos.get(position));

    }


    @Override
    public int getItemCount() {
        return banzenaPojos.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView banzenaName;

        public MyViewHolder(View itemView) {
            super(itemView);
            banzenaName = itemView.findViewById(R.id.material_name);

        }

        public void bind(final BanzenaPojo banzenaPojo) {

            banzenaName.setText(banzenaPojo.getBanzenaName());
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, AddDataActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(intent);
                }
            });


        }
    }

    public void filter(String searchWord) {

        searchWord = searchWord.toLowerCase();
        banzenaPojos.clear();

        if (searchWord.isEmpty()) {
            banzenaPojos.addAll(originList);
        } else {

            List<BanzenaPojo> filteredList = new ArrayList<>();
            for (BanzenaPojo banzenaPojo : originList) {

                if ((banzenaPojo.getBanzenaName().toLowerCase().contains(searchWord))) {
                    filteredList.add(banzenaPojo);
                }
            }

            banzenaPojos = filteredList;
            this.notifyDataSetChanged();
        }
    }
}
