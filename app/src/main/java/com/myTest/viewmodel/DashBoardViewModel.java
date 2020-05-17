package com.myTest.viewmodel;

import android.content.Context;

import com.myTest.tokenmanager.TokenManager;

import java.util.Observable;

public class DashBoardViewModel extends Observable {
    private Context context ;

    public DashBoardViewModel(Context context) {
        this.context = context;
    }
}
