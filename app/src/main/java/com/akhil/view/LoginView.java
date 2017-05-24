package com.akhil.view;

/**
 * Created by e on 05-05-2017.
 */

public interface LoginView {


     String getUserName();

     String getPassword();

    void setUserNameError(int resId);

    void setPasswordError(int resId);

    void onLoginClicked();

    void startActivity();

    void setLoginError(int redId);
}
