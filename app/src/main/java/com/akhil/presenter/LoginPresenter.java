package com.akhil.presenter;

import com.akhil.R;
import com.akhil.model.LoginService;
import com.akhil.view.LoginView;

/**
 * Created by e on 05-05-2017.
 */

public class LoginPresenter {
    private LoginView view;
    private LoginService service;

   public LoginPresenter(LoginView view, LoginService loginService) {
        this.view = view;
        this.service = loginService;
    }

    public void onLoginClicked()
    {
        String username = view.getUserName();
        if (username.isEmpty()) {
            view.setUserNameError(R.string.username_error);
            return;
        }

        String password =view.getPassword();
        if(password.isEmpty())
        {
            view.setPasswordError(R.string.password_error);
            return;
        }

       boolean isLoginSuccess = service.login(username,password);
        if (isLoginSuccess)
        {
            view.startActivity();
            return;
        }

        view.setLoginError(R.string.login_error);

    }

}
