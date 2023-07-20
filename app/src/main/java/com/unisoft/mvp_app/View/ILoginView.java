package com.unisoft.mvp_app.View;

public interface ILoginView {
    void onLoginSuccess(String msg);
    void onLoginError(String msg);
    void onSetProgressBarVisibility(int visibility);
}
