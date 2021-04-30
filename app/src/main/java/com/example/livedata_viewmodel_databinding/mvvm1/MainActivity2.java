package com.example.livedata_viewmodel_databinding.mvvm1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.livedata_viewmodel_databinding.databinding.ActivityMain2Binding;
import com.example.livedata_viewmodel_databinding.mvvm1.CounterViewModel2;

public class MainActivity2 extends AppCompatActivity {

    ActivityMain2Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivityMain2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.setLifecycleOwner(this);    //TODO: 1) 화면에서 Text 에 viewModel.counter -> refresh 역할

        CounterViewModel2 viewModel= new CounterViewModel2();
        binding.setViewModel2(viewModel);   //TODO: 2) viewModel 을 binding 에 꽂아줌

    }
}





