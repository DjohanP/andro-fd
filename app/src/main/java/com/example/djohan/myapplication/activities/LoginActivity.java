package com.example.djohan.myapplication.activities;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.djohan.myapplication.R;
import com.example.djohan.myapplication.model.PresenterImpl;
import com.example.djohan.myapplication.presenter.LoginPresenter;
import com.example.djohan.myapplication.view.LoginView;

public class LoginActivity extends Activity implements View.OnClickListener,LoginView
{
    EditText etemail,etpassword;
    TextView tvlogin;

    LoginPresenter mloginpresenter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        etemail=findViewById(R.id.emailusr);
        etpassword=findViewById(R.id.passusr);

        tvlogin=findViewById(R.id.psnlgn);
        tvlogin.setOnClickListener(this);

        mloginpresenter=new PresenterImpl(LoginActivity.this);
    }

    @Override
    public void onClick(View view) {
        String email=etemail.getText().toString();
        String password=etpassword.getText().toString();

        mloginpresenter.performLogin(email,password);
    }

    @Override
    public void loginValidations() {
        Toast.makeText(getApplicationContext(),"Please Enter Email And Password",Toast.LENGTH_LONG).show();
    }

    @Override
    public void loginSuccess() {
        Toast.makeText(getApplicationContext(),"Berhasil Login",Toast.LENGTH_LONG).show();
    }

    @Override
    public void loginError() {
        Toast.makeText(getApplicationContext(),"Email atau Password salah",Toast.LENGTH_LONG).show();
    }
}
