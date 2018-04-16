package com.test.randomimages.di.module;

import com.test.randomimages.data.repository.ImagesRepository;
import com.test.randomimages.data.repository.Repository;
import com.test.randomimages.model.MainFragmentModelImpl;
import com.test.randomimages.presenter.MainFragmentPresenter;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by dzhafar on 15.04.18.
 */

@Module
public class MainFragmentModule {

    public MainFragmentModule() {
    }

    @Provides
    @Singleton
    public Repository provideRepository(ImagesRepository imagesRepository) {
        return imagesRepository;
    }

    @Provides
    @Named("executor_thread")
    Scheduler provideRepositoryThread() {
        return Schedulers.io();
    }

    @Provides
    @Named("ui_thread")
    Scheduler provideUiThread() {
        return AndroidSchedulers.mainThread();
    }

}
