package com.andrii.mvpexample.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.andrii.mvpexample.R;
import com.andrii.mvpexample.model.PresenterImpl;
import com.andrii.mvpexample.presenter.LoginPresenter;
import com.andrii.mvpexample.view.LoginView;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener, LoginView {

    EditText etUserName, etPassword;
    TextView tvLogin;

    LoginPresenter mLoginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etUserName = findViewById(R.id.etUserName);
        etPassword = findViewById(R.id.etPassword);
        tvLogin = findViewById(R.id.tvLogin);
        tvLogin.setOnClickListener(this);

        mLoginPresenter = new PresenterImpl(LoginActivity.this);
    }

    @Override
    public void onClick(View v) {
        String userName = etUserName.getText().toString();
        String password = etPassword.getText().toString();

        mLoginPresenter.performLogin(userName, password);
    }

    @Override
    public void loginValidations() {
        Toast.makeText(getApplicationContext(), "Please enter userName and password", Toast.LENGTH_LONG ).show();
    }

    @Override
    public void loginSuccess() {
        Toast.makeText(getApplicationContext(), "Login successful", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void loginError() {
        Toast.makeText(getApplicationContext(), "Login failure", Toast.LENGTH_SHORT).show();
    }
}
