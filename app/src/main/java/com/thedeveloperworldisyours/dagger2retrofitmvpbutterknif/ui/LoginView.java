package com.thedeveloperworldisyours.dagger2retrofitmvpbutterknif.ui;

/**
 * Created by javierg on 05/07/16.
 */
public interface LoginView {

    void showProgress();

    void hideProgress();

    void setUsernameError();

    void setPasswordError();

    void navigateToHome();

    void setErrorServer();
}
