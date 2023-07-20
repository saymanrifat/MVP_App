package com.unisoft.mvp_app.Presenter;

public interface ILoginPresenter {
    void doLogin(String email, String pass);
    void setProgressBarVisibility(int visibility);
}
