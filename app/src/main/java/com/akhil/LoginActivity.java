package com.akhil;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.akhil.model.LoginService;
import com.akhil.presenter.LoginPresenter;
import com.akhil.view.LoginView;

public class LoginActivity extends AppCompatActivity implements LoginView
{
    private EditText mEdtUserName;
    private EditText mEdtPassword;
    private LoginPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
        presenter = new LoginPresenter(this, new LoginService());
    }

    private void initView() {
        mEdtUserName = (EditText) findViewById(R.id.txt_username);
        mEdtPassword = (EditText) findViewById(R.id.txt_password);

        findViewById(R.id.btn_login).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onLoginClicked();
            }
        });
    }

    @Override
    public String getUserName() {
        return mEdtUserName.getText().toString();
    }

    @Override
    public String getPassword() {
        return mEdtPassword.getText().toString();
    }

    @Override
    public void setUserNameError(int resId) {
        mEdtUserName.setError(getString(resId));
    }

    @Override
    public void setPasswordError(int resId) {
        mEdtPassword.setError(getString(resId));
    }

    @Override
    public void onLoginClicked() {
        presenter.onLoginClicked();
    }

    @Override
    public void startActivity() {
       startActivity(new Intent(this,WelcomeActivity.class));
    }

    @Override
    public void setLoginError(int redId) {
        Toast.makeText(this,getString(redId),Toast.LENGTH_SHORT).show();
    }
}
