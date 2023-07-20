package com.unisoft.mvp_app.Model;

import android.text.TextUtils;
import android.util.Patterns;

public class UserImpl implements IUser {
    private String email, passWord;

    public UserImpl(String email, String password) {
        this.email = email;
        this.passWord = password;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public String getPassWord() {
        return passWord;
    }

    @Override
    public int checkUserValidity() {

        if (TextUtils.isEmpty(getEmail())) {
            return 0;
        } else if (!Patterns.EMAIL_ADDRESS.matcher(getEmail()).matches()) {
            return 1;
        } else if (TextUtils.isEmpty(getPassWord())) {
            return 2;

        } else if (getPassWord().length() < 6) {

            return 3;

        } else return -1;


    }
}
