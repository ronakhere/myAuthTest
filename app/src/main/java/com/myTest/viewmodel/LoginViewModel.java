package com.myTest.viewmodel;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.myTest.DashBoard;
import com.myTest.decode.JWTUtils;
import com.myTest.remote.APIService;
import com.myTest.tokenmanager.TokenManager;
import com.myTest.remote.RetroClass;

import java.util.Observable;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by ronak.b on 17/5/2020.
 */

public class LoginViewModel extends Observable {
    private Context context ;
    TokenManager tokenManager;

    public LoginViewModel(Context context) {
        this.context = context;
        tokenManager = new TokenManager(context);
    }

    public void getRetroLoginData() {
        APIService apiService = RetroClass.getAPIService();
        Call<String> responsecall = apiService.userLogin("dev@ios.com","Password1");
        responsecall.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                 showToast(""+response.body().toString());
                 tokenManager.createLoginSession(response.body().toString(),"dev@ios.com");

                try {
                    JWTUtils.decodeJWT(response.body().toString());
                    startNewActivity();
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                showToast(""+t.getMessage());

            }
        });
    }

    private void startNewActivity() {
        Intent intent=new Intent(context, DashBoard.class);
        context.startActivity(intent);
    }

    void showToast(String msg)
    {
        Toast.makeText(context,msg,Toast.LENGTH_LONG).show();
    }
}
