package com.example.livedata_viewmodel_databinding.mvvm2;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class StringViewModel extends ViewModel {

    public MutableLiveData<String> editText;
    public MutableLiveData<String> textView= new MutableLiveData<>();


    private MutableLiveData<String> getEditText(){
        if (editText == null){
            editText= new MutableLiveData<>();
        }
        return editText;
    }

    public void clickSearch(){
        getEditText();
        Log.d("editText>>",editText+"");    //androidx.lifecycle.MutableLiveData@48f4dd7
        //textView.setValue(editText.getValue()+"");
        textView.setValue(getEditText().toString());
        Log.d("setText>>", editText.getValue()+"");   //null
    }

}



