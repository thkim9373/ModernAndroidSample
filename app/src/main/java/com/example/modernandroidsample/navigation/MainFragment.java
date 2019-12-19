package com.example.modernandroidsample.navigation;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.modernandroidsample.R;
import com.example.modernandroidsample.databinding.FragmentMainBinding;


/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {


    public MainFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        FragmentMainBinding binding = DataBindingUtil.bind(view);
        binding.btGoSecondFragment.setOnClickListener(button -> {
            Navigation.findNavController(button).navigate(R.id.action_mainFragment_to_secondFragment);
        });
    }
}
