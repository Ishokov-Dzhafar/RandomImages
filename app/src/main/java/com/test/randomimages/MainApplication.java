package com.test.randomimages;

import android.app.Application;

import com.test.randomimages.di.component.DaggerMainFragmentComponent;
import com.test.randomimages.di.component.MainFragmentComponent;


/**
 * Created by dzhafar on 15.04.18.
 */

public class MainApplication extends Application {
    private MainFragmentComponent mainFragmentComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        createMainFragmentComponent();
    }

    public MainFragmentComponent getMainFragmentComponent() {
        return mainFragmentComponent;
    }

    private void createMainFragmentComponent() {
        mainFragmentComponent = DaggerMainFragmentComponent.builder().build();
    }
}
