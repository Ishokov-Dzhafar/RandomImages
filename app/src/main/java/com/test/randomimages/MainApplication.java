package com.test.randomimages;

import android.app.Application;
import android.content.Context;

import com.test.randomimages.di.component.DaggerMainFragmentComponent;
import com.test.randomimages.di.component.MainFragmentComponent;
import com.test.randomimages.di.module.MainFragmentModule;


/**
 * Created by dzhafar on 15.04.18.
 */

public class MainApplication extends Application {
    private MainFragmentComponent mainFragmentComponent;
    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        MainApplication.context = getApplicationContext();
        createMainFragmentComponent();
    }

    public MainFragmentComponent getMainFragmentComponent() {
        return mainFragmentComponent;
    }

    public static Context getAppContext() {
        return MainApplication.context;
    }

    private void createMainFragmentComponent() {
        mainFragmentComponent = DaggerMainFragmentComponent.builder().mainFragmentModule(new MainFragmentModule()).build();
    }
}
