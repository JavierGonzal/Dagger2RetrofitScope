package com.thedeveloperworldisyours.dagger2retrofitmvpbutterknif.di;

import com.thedeveloperworldisyours.dagger2retrofitmvpbutterknif.Interact.LoginInteract;
import com.thedeveloperworldisyours.dagger2retrofitmvpbutterknif.Interact.LoginInteractImpl;
import com.thedeveloperworldisyours.dagger2retrofitmvpbutterknif.service.ApiService;
import com.thedeveloperworldisyours.dagger2retrofitmvpbutterknif.service.RetrofitService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit.Retrofit;

/**
 * Created by javierg on 05/07/16.
 */
@Module
public class LoginInteractModule {

    @Provides
    public LoginInteract provideLoginInteract(ApiService myApi) {
        return new LoginInteractImpl(myApi);
    }

    @Provides
    @Singleton
    public RetrofitService providesRetrofitService() {
        return new RetrofitService();
    }

    @Provides
    @Singleton
    public ApiService providesApiService(RetrofitService retrofitService) {
        Retrofit retrofit = retrofitService.buildRedditRetrofit();
        return retrofit.create(ApiService.class);
    }

}
