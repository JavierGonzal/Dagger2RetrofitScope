package com.thedeveloperworldisyours.dagger2retrofitmvpbutterknif.Interact;

import android.text.TextUtils;


import com.thedeveloperworldisyours.dagger2retrofitmvpbutterknif.model.Example;
import com.thedeveloperworldisyours.dagger2retrofitmvpbutterknif.service.ApiService;

import javax.inject.Inject;

import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

/**
 * Created by javierg on 04/07/16.
 */
public class LoginInteractImpl implements LoginInteract {

    @Inject
    ApiService mApiService;

    @Inject
    public LoginInteractImpl(ApiService getApi) {
        this.mApiService = getApi;
    }

    @Override
    public void login(String userName, String password, final OnLoginFinishedListener listener) {

        final boolean[] error = {false};
        if (TextUtils.isEmpty(userName)) {
            listener.onUsernameError();
            error[0] = true;
        }

        if (TextUtils.isEmpty(password)) {
            listener.onPasswordError();
            error[0] = true;
        }

        if (!TextUtils.isEmpty(password) && !TextUtils.isEmpty(userName)) {
            mApiService.getExampleCall().enqueue(new Callback<Example>() {
                @Override
                public void onResponse(Response<Example> response, Retrofit retrofit) {
                    listener.onSuccess();
                }

                @Override
                public void onFailure(Throwable t) {
                    listener.onFail();
                }
            });
        }

    }

}
