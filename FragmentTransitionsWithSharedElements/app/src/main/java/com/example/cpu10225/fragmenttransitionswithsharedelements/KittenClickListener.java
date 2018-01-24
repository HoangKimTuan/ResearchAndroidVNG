package com.example.cpu10225.fragmenttransitionswithsharedelements;

/**
 * Created by cpu10225 on 24/01/2018.
 */

public interface KittenClickListener {
    /**
     * Called when a kitten is clicked
     * @param holder The ViewHolder for the clicked kitten
     * @param position The position in the grid of the kitten that was clicked
     */
    void onKittenClicked(KittenViewHolder holder, int position);
}
