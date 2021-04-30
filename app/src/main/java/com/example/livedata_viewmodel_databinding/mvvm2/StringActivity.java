package com.example.livedata_viewmodel_databinding.mvvm2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import com.example.livedata_viewmodel_databinding.R;
import com.example.livedata_viewmodel_databinding.databinding.ActivityStringBinding;

public class StringActivity extends AppCompatActivity {
    private ActivityStringBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivityStringBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.setLifecycleOwner(this);
        StringViewModel viewModel= new ViewModelProvider(this).get(StringViewModel.class);
        binding.setMViewModel(viewModel);



    }
}