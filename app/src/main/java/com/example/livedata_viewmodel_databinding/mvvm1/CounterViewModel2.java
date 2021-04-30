package com.example.livedata_viewmodel_databinding.mvvm1;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class CounterViewModel2 extends ViewModel {
    //public int counter= 0;
    public MutableLiveData<Integer> counter= new MutableLiveData<>();   //TODO: MutableLiveData - 수정가능한 데이터


    public CounterViewModel2(){     //TODO: 생성자 이용 - 0으로 초기화
        counter.setValue(0);
    }

    public void increase(){
       counter.setValue(counter.getValue() +1);
    }

    public void decrease(){
        counter.setValue(counter.getValue() -1);
    }

}





