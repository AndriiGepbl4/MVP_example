package com.andrii.mvpexample.model;

import android.text.TextUtils;

import com.andrii.mvpexample.presenter.LoginPresenter;
import com.andrii.mvpexample.view.LoginView;

public class PresenterImpl implements LoginPresenter {

    LoginView mLoginView;

    public PresenterImpl (LoginView loginView){
        this.mLoginView = loginView;
    }

    @Override
    public void performLogin(String userName, String password) {
        if (TextUtils.isEmpty(userName) || TextUtils.isEmpty(password)){
            mLoginView.loginValidations();
        } else {
            if (userName.equals("AA") && password.equals("AA")){
                mLoginView.loginSuccess();
            } else {
                mLoginView.loginError();
            }

        }

    }
}
