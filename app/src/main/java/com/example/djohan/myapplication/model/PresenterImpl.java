package com.example.djohan.myapplication.model;

import android.text.TextUtils;

import com.example.djohan.myapplication.presenter.LoginPresenter;
import com.example.djohan.myapplication.view.LoginView;

public class PresenterImpl implements LoginPresenter
{

    LoginView mloginview;

    public PresenterImpl(LoginView loginView)
    {
        this.mloginview=loginView;
    }

    @Override
    public void performLogin(String email, String password) {
        if(TextUtils.isEmpty(email)||TextUtils.isEmpty(password))
        {
            mloginview.loginValidations();
        }
        else
        {
            if(email.equals("djohan@gmail.com")&&password.equals("123"))
            {
                mloginview.loginSuccess();
            }
            else
            {
                mloginview.loginError();
            }
        }
    }
}
