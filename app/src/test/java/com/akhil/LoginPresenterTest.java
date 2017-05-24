package com.akhil;

/**
 * Created by Akhil on 25-05-2017.
 */

import com.akhil.model.LoginService;
import com.akhil.presenter.LoginPresenter;
import com.akhil.view.LoginView;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;


import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by vivekjain on 5/31/15.
 */
@RunWith(MockitoJUnitRunner.class)
public class LoginPresenterTest {
    @Mock
    private LoginView view;
    @Mock
    private LoginService service;
    private LoginPresenter presenter;

    @Before
    public void setUp() throws Exception {
        presenter = new LoginPresenter(view, service);
    }

    @Test
    public void shouldShowErrorMessageWhenUsernameIsEmpty() throws Exception {
        when(view.getUserName()).thenReturn("");
        presenter.onLoginClicked();

        verify(view).setUserNameError(R.string.username_error);
    }

    @Test
    public void shouldShowErrorMessageWhenPasswordIsEmpty() throws Exception {
        when(view.getUserName()).thenReturn("james");
        when(view.getPassword()).thenReturn("");
        presenter.onLoginClicked();

        verify(view).setPasswordError(R.string.password_error);
    }

    @Test
    public void shouldStartMainActivityWhenUsernameAndPasswordAreCorrect() throws Exception {
        when(view.getUserName()).thenReturn("james");
        when(view.getPassword()).thenReturn("bond");
        when(service.login("james", "bond")).thenReturn(true);
        presenter.onLoginClicked();

        verify(view).startActivity();
    }

    @Test
    public void shouldShowLoginErrorWhenUsernameAndPasswordAreInvalid() throws Exception {
        when(view.getUserName()).thenReturn("james");
        when(view.getPassword()).thenReturn("bond");
        when(service.login("james", "bond")).thenReturn(false);
        presenter.onLoginClicked();

        verify(view).setLoginError(R.string.login_error);
    }
}
