package com.thedeveloperworldisyours.dagger2retrofitmvpbutterknif.di;

import com.thedeveloperworldisyours.dagger2retrofitmvpbutterknif.ActivityScope;
import com.thedeveloperworldisyours.dagger2retrofitmvpbutterknif.ui.LoginActivity;
import com.thedeveloperworldisyours.dagger2retrofitmvpbutterknif.ui.LoginPresenter;

import dagger.Component;

/**
 * Created by javierg on 05/07/16.
 */
@ActivityScope
@Component(
        dependencies = AppComponent.class,
        modules = LoginModule.class
)
public interface LoginComponent {
    void inject(LoginActivity activity);
    LoginPresenter getLoginPresenter();
}
