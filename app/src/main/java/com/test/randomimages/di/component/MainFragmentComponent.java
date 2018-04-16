package com.test.randomimages.di.component;

import com.test.randomimages.di.module.MainFragmentModule;
import com.test.randomimages.presenter.MainFragmentPresenter;
import com.test.randomimages.view.fragments.MainFragment;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by dzhafar on 15.04.18.
 */
@Singleton
@Component(modules = MainFragmentModule.class)
public interface MainFragmentComponent {

    void inject(MainFragment mainFragment);

}
