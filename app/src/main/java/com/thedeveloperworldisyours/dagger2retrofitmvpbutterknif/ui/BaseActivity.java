package com.thedeveloperworldisyours.dagger2retrofitmvpbutterknif.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.thedeveloperworldisyours.dagger2retrofitmvpbutterknif.App;
import com.thedeveloperworldisyours.dagger2retrofitmvpbutterknif.di.AppComponent;

/**
 * Created by javierg on 05/07/16.
 */
public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupComponent((AppComponent) App.get(this).component());
    }


    protected abstract void setupComponent(AppComponent appComponent);
}
