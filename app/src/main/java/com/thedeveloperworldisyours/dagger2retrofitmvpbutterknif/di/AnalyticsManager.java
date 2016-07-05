package com.thedeveloperworldisyours.dagger2retrofitmvpbutterknif.di;

import android.app.Application;

/**
 * Created by javierg on 05/07/16.
 */
public class AnalyticsManager {
    private Application app;

    public AnalyticsManager(Application app) {
        this.app = app;
    }

    public void registerAppEnter() {
        //Do whatever you want when the app is started
    }
}
