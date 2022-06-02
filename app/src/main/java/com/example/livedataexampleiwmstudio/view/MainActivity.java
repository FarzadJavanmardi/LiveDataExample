package com.example.livedataexampleiwmstudio.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;

import android.os.Bundle;
import android.util.Log;

import com.example.livedataexampleiwmstudio.R;
import com.example.livedataexampleiwmstudio.databinding.ActivityMainBinding;
import com.example.livedataexampleiwmstudio.viewmodels.UserViewModel;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity ";
    ActivityMainBinding activityMainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //   setContentView(R.layout.activity_main);

        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        UserViewModel userViewModel = new UserViewModel(this);
        activityMainBinding.setUserViewModel(userViewModel);


    }
}