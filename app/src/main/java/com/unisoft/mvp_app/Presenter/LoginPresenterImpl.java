package com.unisoft.mvp_app.Presenter;

import android.os.Handler;
import android.os.Looper;

import com.unisoft.mvp_app.Model.IUser;
import com.unisoft.mvp_app.Model.UserImpl;
import com.unisoft.mvp_app.View.ILoginView;

public class LoginPresenterImpl implements ILoginPresenter {

    private ILoginView loginView;

    public LoginPresenterImpl(ILoginView loginView) {
        this.loginView = loginView;
    }

    @Override
    public void doLogin(String email, String pass) {

        IUser user = new UserImpl(email, pass);
        int login_code = user.checkUserValidity();

        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                if (login_code == 0) {
                    loginView.onLoginError("Please Enter Your Email");
                } else if (login_code == 1) {
                    loginView.onLoginError("Please Enter Valid Email");

                } else if (login_code == 2) {
                    loginView.onLoginError("Please Enter Your Password");

                } else if (login_code == 3) {
                    loginView.onLoginError("Please Enter a Password that should be more then 6 character");
                } else {
                    loginView.onLoginSuccess("Login in Successful");
                }
            }
        }, 2000);


    }

    @Override
    public void setProgressBarVisibility(int visibility) {

        loginView.onSetProgressBarVisibility(visibility);
    }
}
