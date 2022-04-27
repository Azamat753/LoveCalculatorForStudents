package com.example.lovecalculator03.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lovecalculator03.App;
import com.example.lovecalculator03.R;
import com.example.lovecalculator03.adapter.HistoryAdapter;
import com.example.lovecalculator03.base.BaseFragment;
import com.example.lovecalculator03.databinding.FragmentHistoryBinding;
import com.example.lovecalculator03.model.HistoryModel;

import java.util.ArrayList;


public class HistoryFragment extends BaseFragment<FragmentHistoryBinding> {
    HistoryAdapter adapter;

    @Override
    public FragmentHistoryBinding getBinding() {
        return FragmentHistoryBinding.inflate(getLayoutInflater());
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initAdapter();
    }

    private void initAdapter() {
        App.appDataBase.historyDao().getBatmanHistory("batman").observe(getViewLifecycleOwner(), listHistory -> {
            adapter = new HistoryAdapter((ArrayList<HistoryModel>) listHistory);
            binding.recycler.setAdapter(adapter);
        });
    }
}