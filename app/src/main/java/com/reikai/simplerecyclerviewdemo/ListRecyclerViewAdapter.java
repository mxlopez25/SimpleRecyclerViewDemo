package com.reikai.simplerecyclerviewdemo;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class ListRecyclerViewAdapter extends RecyclerView.Adapter<ListRecyclerViewAdapter.ViewHolder> {

    private List<String> mData;
    private LayoutInflater mInflater;
    private ItemClickListener itemClickListener;


    /**
     * Data is passed to the constructor
     * @param context       The context is required so the inflater can inflate the
     *                      view in the activity is called upon.
     * @param data          Data that will be inserted into the list.
     * */
    public ListRecyclerViewAdapter(Context context, List<String> data) {
        this.mInflater = LayoutInflater.from(context);
        this.mData = data;
    }

    /**
     * Inflates the roy layout from xml when needed.
     * */
    @NonNull
    @Override
    public ListRecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = mInflater.inflate(R.layout.recyclerview_layout, viewGroup, false);
        return new ViewHolder(view);
    }

    /**
     * Binds the data to the components in the row layout.
     * */
    @Override
    public void onBindViewHolder(@NonNull ListRecyclerViewAdapter.ViewHolder viewHolder, int i) {
        String item = mData.get(i);
        viewHolder.myTextView.setText(item);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    /**
     * Store and recycles views as it scrolls down.
     * */
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView myTextView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            myTextView = itemView.findViewById(R.id.tvListItemText);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (itemClickListener != null) itemClickListener.OnItemClick(v, getAdapterPosition());
        }
    }

    /**
     * Convenience method used to get specific item from data list at click position.
     * */
    String getItem(int id) {
        return mData.get(id);
    }

    /**
     * Method that allows events to be caught.
     * */
    void setClickLister(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    /**
     * Parent activity needs to implements interface for callbacks.
     * */
    public interface ItemClickListener {
        void OnItemClick(View view, int position);
    }
}
