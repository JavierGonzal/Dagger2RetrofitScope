package com.thedeveloperworldisyours.dagger2retrofitmvpbutterknif.Interact;

/**
 * Created by javierg on 04/07/16.
 */
public interface LoginInteract {
    interface OnLoginFinishedListener {
        void onUsernameError();

        void onPasswordError();

        void onSuccess();

        void onFail();
    }

    void login(String username, String password, OnLoginFinishedListener listener);

}