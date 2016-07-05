package com.thedeveloperworldisyours.dagger2retrofitmvpbutterknif.ui;

/**
 * Created by javierg on 05/07/16.
 */
public interface LoginPresenter {
    void validateCredentials(String username, String password);

    void onDestroy();
}
