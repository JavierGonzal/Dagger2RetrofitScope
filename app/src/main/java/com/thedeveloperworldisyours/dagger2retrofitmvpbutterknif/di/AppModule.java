package com.thedeveloperworldisyours.dagger2retrofitmvpbutterknif.di;

import android.app.Application;

import com.thedeveloperworldisyours.dagger2retrofitmvpbutterknif.App;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by javierg on 05/07/16.
 */
@Module
public class AppModule {
    private App app;

    public AppModule(App app) {
        this.app = app;
    }

    @Provides
    @Singleton
    public Application provideApplication() {
        return app;
    }
}

