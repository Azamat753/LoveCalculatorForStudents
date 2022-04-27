package com.example.lovecalculator03.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lovecalculator03.databinding.ItemHistoryBinding;
import com.example.lovecalculator03.model.HistoryModel;

import java.util.ArrayList;

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.HistoryViewHolder> {

    ArrayList<HistoryModel> list;

    public HistoryAdapter(ArrayList<HistoryModel> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public HistoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemHistoryBinding binding = ItemHistoryBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new HistoryViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull HistoryViewHolder holder, int position) {
        holder.onBind(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class HistoryViewHolder extends RecyclerView.ViewHolder {
        ItemHistoryBinding binding;

        public HistoryViewHolder(ItemHistoryBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void onBind(HistoryModel historyModel) {
            binding.firstName.setText(historyModel.getFirstName());
            binding.secondName.setText(historyModel.getSecondName());
            binding.percentageName.setText(historyModel.getPercentage());
            binding.resultName.setText(historyModel.getResult());
        }
    }
}
