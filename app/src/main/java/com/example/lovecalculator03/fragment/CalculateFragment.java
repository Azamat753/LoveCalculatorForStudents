package com.example.lovecalculator03.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.example.lovecalculator03.App;
import com.example.lovecalculator03.LoveViewModel;
import com.example.lovecalculator03.R;
import com.example.lovecalculator03.base.BaseFragment;
import com.example.lovecalculator03.databinding.FragmentCalculateBinding;
import com.example.lovecalculator03.model.HistoryModel;
import com.example.lovecalculator03.model.LoveModel;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class CalculateFragment extends BaseFragment<FragmentCalculateBinding> {
    LoveViewModel viewModel;

    @Override
    public FragmentCalculateBinding getBinding() {
        return FragmentCalculateBinding.inflate(getLayoutInflater());
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initClickers();
        viewModel = new ViewModelProvider(this).get(LoveViewModel.class);
    }

    private void initClickers() {
        binding.calculateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String male = binding.maleName.getText().toString();
                String female = binding.femaleName.getText().toString();

                viewModel.getLoveModelLiveData(male, female).observe(getViewLifecycleOwner(), data -> {
                    if (data != null) {
                        HistoryModel historyModel = new HistoryModel(data.getFirstName(),
                                data.getSecondName(), data.getPercentage(), data.getResult());
                        App.appDataBase.historyDao().insert(historyModel);
                    }
                });
            }
        });
        binding.historyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(requireView()).navigate(R.id.historyFragment);
            }
        });
    }
}