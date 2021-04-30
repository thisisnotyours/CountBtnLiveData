package com.example.livedata_viewmodel_databinding.mvvm1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;

import com.example.livedata_viewmodel_databinding.databinding.ActivityMainBinding;
import com.example.livedata_viewmodel_databinding.mvvm2.StringActivity;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    //private int counter= 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.setLifecycleOwner(this);

        //TODO: 문제는.. "액티비티의 라이프사이클" 때문에 화면을 가로로 돌리면 "초기화"됨..
        //TODO: viewModel 을 이용하여 초기화되지 않도록 해야함.
        //TODO: CounterViewModel 클래스를 생성하고 MainActivity 에서 호출!
        CounterViewModel viewModel= new ViewModelProvider(this).get(CounterViewModel.class);

        binding.setViewModel(viewModel);


        /*binding.fabAdd.setOnClickListener(v -> {
            viewModel.increase();
        });

        binding.fabRemove.setOnClickListener(v -> {
            viewModel.decrease();
        });*/



        //TODO: viewModel 의 변경된 값 관찰하기!!!!
        /*viewModel.counter.observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {    //counter 의 값이 변경되었을때 그 값이 integer 로 넘어옴!!!!!
                // UI 업데이트
                binding.countTextView.setText(integer+"");    //integer == viewModel.counter.getValue()
            }
        });*/

        binding.main2Btn.setOnClickListener(v -> {
            Intent intent= new Intent(this, MainActivity2.class);
            startActivity(intent);
        });



        binding.shareBtn.setOnClickListener(v -> {
            Intent intent= new Intent(this, VmShareActivity.class);
            startActivity(intent);
        });


        binding.stringActBtn.setOnClickListener(v -> {
            Intent intent= new Intent(this, StringActivity.class);
            startActivity(intent);
        });

    }//onCreate
}