package com.example.cpu10225.fragmenttransitionswithsharedelements;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by cpu10225 on 24/01/2018.
 */

public class KittenViewHolder extends RecyclerView.ViewHolder {
    ImageView image;
    TextView tv;

    public KittenViewHolder(View itemView) {
        super(itemView);
        image = itemView.findViewById(R.id.image);
        tv = itemView.findViewById(R.id.tv);
    }
}