package com.thedeveloperworldisyours.dagger2retrofitmvpbutterknif.service;

import com.thedeveloperworldisyours.dagger2retrofitmvpbutterknif.model.Example;

import retrofit.Call;
import retrofit.http.GET;

/**
 * Created by javierg on 04/07/16.
 */
public interface ApiService {
    @GET("key/value/one/two")
    Call<Example> getExampleCall();
}
