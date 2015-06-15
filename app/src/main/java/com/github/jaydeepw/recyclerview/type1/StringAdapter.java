package com.github.jaydeepw.recyclerview.type1;


import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class StringAdapter extends RecyclerView.Adapter<StringAdapter.ViewHolder> {

    public ArrayList<String> data;

    public StringAdapter(ArrayList<String> data) {
        this.data = data;
    }

    @Override
    public StringAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.scanned_card_plank, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(StringAdapter.ViewHolder holder, int position) {
        String value = data.get(position);

        // show note for the card if available.
        if (value != null) {
            if (!TextUtils.isEmpty(value)) {
                holder.cardNote.setText(value);
            }
        }
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public void remove(int position) {
        data.remove(position);
        notifyItemRemoved(position);
    }

    public void clear() {
        int size = data.size();
        data.clear();
        notifyItemRangeRemoved(0, size);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView cardNote;

        public ViewHolder(View itemView) {
            super(itemView);
            cardNote = (TextView) itemView.findViewById(R.id.textview_card_note);
        }
    }
}
