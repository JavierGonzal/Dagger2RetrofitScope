package com.thedeveloperworldisyours.dagger2retrofitmvpbutterknif.di;

import com.thedeveloperworldisyours.dagger2retrofitmvpbutterknif.App;
import com.thedeveloperworldisyours.dagger2retrofitmvpbutterknif.Interact.LoginInteract;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by javierg on 05/07/16.
 */
@Singleton
@Component(
        modules = {
                AppModule.class,
                DomainModule.class,
                LoginInteractModule.class
        }
)
public interface AppComponent {
    void inject(App app);

    AnalyticsManager getAnalyticsManager();
    LoginInteract getFindItemsInteractor();
}
