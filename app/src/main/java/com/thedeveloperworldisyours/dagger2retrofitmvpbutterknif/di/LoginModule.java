package com.thedeveloperworldisyours.dagger2retrofitmvpbutterknif.di;

import com.thedeveloperworldisyours.dagger2retrofitmvpbutterknif.Interact.LoginInteract;
import com.thedeveloperworldisyours.dagger2retrofitmvpbutterknif.ui.LoginPresenter;
import com.thedeveloperworldisyours.dagger2retrofitmvpbutterknif.ui.LoginPresenterImpl;
import com.thedeveloperworldisyours.dagger2retrofitmvpbutterknif.ui.LoginView;

import dagger.Module;
import dagger.Provides;

/**
 * Created by javierg on 05/07/16.
 */
@Module
public class LoginModule {
    private LoginView view;

    public LoginModule(LoginView view) {
        this.view = view;
    }

    @Provides
    public LoginView provideView() {
        return view;
    }

    @Provides
    public LoginPresenter providePresenter(LoginView loginView, LoginInteract loginInteract) {
        return new LoginPresenterImpl(loginView, loginInteract);
    }


}
