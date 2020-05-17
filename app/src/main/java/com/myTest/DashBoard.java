package com.myTest;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.myTest.databinding.ActivityMainBinding;
import com.myTest.presenter.Presenter;
import com.myTest.viewmodel.DashBoardViewModel;

public class DashBoard  extends AppCompatActivity {
    private ActivityMainBinding activityMainBinding;
    private DashBoardViewModel dashBoardViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_dashboard);
        dashBoardViewModel = new DashBoardViewModel(this);
        activityMainBinding.setPresenter(new Presenter() {
            @Override
            public void logInRetro() {
                showToast("DashBoard Starts now...");
            }
        });
    }

    void showToast(String msg)
    {
        Toast.makeText(this,msg,Toast.LENGTH_LONG).show();
    }
}
