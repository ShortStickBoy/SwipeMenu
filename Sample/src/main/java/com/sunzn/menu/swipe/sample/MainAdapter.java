package com.sunzn.menu.swipe.sample;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {

    private ArrayList<ModelBean> mDataSet;

    public MainAdapter(ArrayList<ModelBean> dataSet) {
        this.mDataSet = dataSet;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.pattern_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ModelBean bean = mDataSet.get(position);
        holder.getMainTextView().setText(bean.getMainText());
        holder.getSubsTextView().setText(bean.getSubsText());
    }

    @Override
    public int getItemCount() {
        return mDataSet == null ? 0 : mDataSet.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView mainTextView;
        private final TextView subsTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            mainTextView = itemView.findViewById(R.id.mainText);
            subsTextView = itemView.findViewById(R.id.subsText);
        }

        public TextView getMainTextView() {
            return mainTextView;
        }

        public TextView getSubsTextView() {
            return subsTextView;
        }

    }

}
