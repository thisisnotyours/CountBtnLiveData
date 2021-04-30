package com.example.livedata_viewmodel_databinding.mvvm1;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;


//TODO: viewModel 의 장점!!
//TODO: viewModel 을 이용하면 데이터가 날아가지 않음...  ===> view 의 어디가 변경이 되었는지 관찰가능!

// TODO: 1) MutableLiveData : 수정,변경이 가능한 데이터
// TODO: 2) LiveData        : 데이터를 set 할 필요없는 데이터



public class CounterViewModel extends ViewModel {
    //public int counter= 0;
    //변경이 있는 데이터니 MutableLiceData 사용..
    //TODO: TextView
    public MutableLiveData<Integer> counter = new MutableLiveData<>();  // count_text_view 텍스트뷰에 셋할 숫자. counter


    //처음 화면을 켰을 때 null 이 나오지 않도록 "생성자"를 이용해 "초기화"를 해줌..
    public CounterViewModel(){
        counter.setValue(0);
    }


    //TODO: 더하기 빼기 세팅..
    public void increase(){
        counter.setValue(counter.getValue() + 1);
    }
    public void decrease(){
        counter.setValue(counter.getValue() - 1);
    }
}
