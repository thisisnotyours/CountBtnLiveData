package com.example.livedata_viewmodel_databinding.mvvm1;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class VmShareViewModel extends ViewModel {
    public MutableLiveData<Integer> progress= new MutableLiveData<>();
}
