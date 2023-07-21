package com.unisoft.mvp_app.View;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.unisoft.mvp_app.Presenter.ILoginPresenter;
import com.unisoft.mvp_app.Presenter.LoginPresenterImpl;
import com.unisoft.mvp_app.R;

public class MainActivity extends AppCompatActivity implements ILoginView {

    private ProgressBar progressBar;
    private EditText email, password;
    private Button loginBtn;
    private ILoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        loginBtn = findViewById(R.id.loginBtn);
        progressBar = findViewById(R.id.progressBar);

        loginPresenter = new LoginPresenterImpl(this);

        loginPresenter.setProgressBarVisibility(View.INVISIBLE);

        loginBtn.setOnClickListener(v -> {

            loginPresenter.setProgressBarVisibility(View.VISIBLE);
            loginPresenter.doLogin(email.getText().toString().trim(), password.getText().toString().trim());

        });


    }

    @Override
    public void onLoginSuccess(String msg) {
        loginPresenter.setProgressBarVisibility(View.INVISIBLE);
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onLoginError(String msg) {

        loginPresenter.setProgressBarVisibility(View.INVISIBLE);
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onSetProgressBarVisibility(int visibility) {
        progressBar.setVisibility(visibility);
    }
}