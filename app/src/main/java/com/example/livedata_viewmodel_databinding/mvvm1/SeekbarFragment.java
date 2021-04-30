package com.example.livedata_viewmodel_databinding.mvvm1;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;

import com.example.livedata_viewmodel_databinding.R;
import com.example.livedata_viewmodel_databinding.databinding.FragmentSeekbarBinding;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SeekbarFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SeekbarFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    FragmentSeekbarBinding binding;

    public SeekbarFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SeekbarFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SeekbarFragment newInstance(String param1, String param2) {
        SeekbarFragment fragment = new SeekbarFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_seekbar, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        VmShareViewModel viewModel= new ViewModelProvider(requireActivity()).get(VmShareViewModel.class);
        binding= DataBindingUtil.bind(view);

        binding.setLifecycleOwner(requireActivity());   //TODO: 액티비티쪽의 lifeCycle 을 따르겠다. -> 화면갱신작업 1)
        binding.setViewModel(viewModel);                //TODO: Observer..                        -> 화면갱신작업 2)

        binding.seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {     //TODO: 변경된 값이  progress 로 옴   //user 가 만졌는지 안만졌는지 - true/false
                viewModel.progress.setValue(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


        //TODO: xml 에서 android:progress="@{viewModel.progress}" 를 하면 아래처럼 observe 를 따로 쓰지 않아도됌
        /*viewModel.progress.observe(requireActivity(), new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                binding.seekbar.setProgress(integer);
            }
        });*/
    }
}