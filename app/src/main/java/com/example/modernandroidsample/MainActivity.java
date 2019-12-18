package com.example.modernandroidsample;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.modernandroidsample.databinding.ActivityMainBinding;
import com.example.modernandroidsample.navigation.NavigationActivity;
import com.example.modernandroidsample.room.RoomActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final ActivityMainBinding binding = DataBindingUtil.setContentView(MainActivity.this, R.layout.activity_main);
        binding.setLifecycleOwner(MainActivity.this);

        binding.btGoRoomActivity.setOnClickListener(MainActivity.this);
        binding.btGoNavActivity.setOnClickListener(MainActivity.this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bt_go_room_activity:
                goActivity(RoomActivity.class);
                break;
            case R.id.bt_go_nav_activity:
                goActivity(NavigationActivity.class);
                break;
        }
    }

    private void goActivity(Class target) {
        Intent intent = new Intent(MainActivity.this, target);
        startActivity(intent);
    }
}
