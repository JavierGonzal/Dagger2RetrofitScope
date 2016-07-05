package com.thedeveloperworldisyours.dagger2retrofitmvpbutterknif.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.thedeveloperworldisyours.dagger2retrofitmvpbutterknif.App;
import com.thedeveloperworldisyours.dagger2retrofitmvpbutterknif.R;
import com.thedeveloperworldisyours.dagger2retrofitmvpbutterknif.di.AppComponent;
import com.thedeveloperworldisyours.dagger2retrofitmvpbutterknif.di.DaggerLoginComponent;
import com.thedeveloperworldisyours.dagger2retrofitmvpbutterknif.di.LoginModule;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;

public class LoginActivity extends BaseActivity implements LoginView, View.OnClickListener {

    @Bind(R.id.button)
    Button mButton;

    @Bind(R.id.progress)
    ProgressBar mProgressBar;

    @Bind(R.id.username)
    EditText mUserName;

    @Bind(R.id.password)
    EditText mPassword;

    @Inject
    LoginPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);



        ButterKnife.bind(this);

        mButton.setOnClickListener(this);

    }

    @Override
    protected void setupComponent(AppComponent appComponent) {
        DaggerLoginComponent.builder()
                .appComponent(appComponent)
                .loginModule(new LoginModule(this))
                .build()
                .inject(this);

    }

    @Override
    protected void onDestroy() {
        mPresenter.onDestroy();
        super.onDestroy();
    }

    @Override
    public void showProgress() {
        mProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        mProgressBar.setVisibility(View.GONE);
    }

    @Override
    public void setUsernameError() {
        mUserName.setError(getString(R.string.activity_login_username_error));
    }

    @Override
    public void setPasswordError() {
        mPassword.setError(getString(R.string.activity_login_password_error));
    }

    @Override
    public void navigateToHome() {
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }

    @Override
    public void setErrorServer() {
        Toast.makeText(this, getString(R.string.activity_login_server_error), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View v) {
        mPresenter.validateCredentials(mUserName.getText().toString(), mPassword.getText().toString());
    }
}

