package com.thedeveloperworldisyours.dagger2retrofitmvpbutterknif;

import android.app.Application;
import android.content.Context;

import com.thedeveloperworldisyours.dagger2retrofitmvpbutterknif.di.AnalyticsManager;
import com.thedeveloperworldisyours.dagger2retrofitmvpbutterknif.di.AppComponent;
import com.thedeveloperworldisyours.dagger2retrofitmvpbutterknif.di.AppModule;
import com.thedeveloperworldisyours.dagger2retrofitmvpbutterknif.di.DaggerAppComponent;

import javax.inject.Inject;

/**
 * Created by javierg on 05/07/16.
 */
public class App extends Application {

    private AppComponent component;

    @Inject
    AnalyticsManager analyticsManager;

    @Override public void onCreate() {
        super.onCreate();
        setupGraph();
        analyticsManager.registerAppEnter();
    }

    private void setupGraph() {
        component = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
        component.inject(this);
    }

    public AppComponent component() {
        return component;
    }

    public static App get(Context context) {
        return (App) context.getApplicationContext();
    }
}
