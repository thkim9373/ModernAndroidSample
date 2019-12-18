package com.example.modernandroidsample.room;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;

import com.example.modernandroidsample.R;
import com.example.modernandroidsample.databinding.ActivityRoomBinding;

public class RoomActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final ActivityRoomBinding binding = DataBindingUtil.setContentView(RoomActivity.this, R.layout.activity_room);
        binding.setLifecycleOwner(RoomActivity.this);

        MainViewModel viewModel = ViewModelProviders.of(RoomActivity.this).get(MainViewModel.class);
        binding.setViewModel(viewModel);
    }
}
