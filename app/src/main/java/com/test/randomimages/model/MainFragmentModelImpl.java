package com.test.randomimages.model;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;

import com.test.randomimages.data.repository.Repository;

import javax.inject.Inject;
import javax.inject.Named;

import io.reactivex.Observable;
import io.reactivex.Scheduler;


/**
 * Created by dzhafar on 15.04.18.
 */

public class MainFragmentModelImpl extends UseCase<Bitmap> {

    private final Repository repository;

    @Inject
    public MainFragmentModelImpl(@Named("executor_thread") Scheduler executorThread,
                                 @Named("ui_thread") Scheduler uiThread, Repository repository) {
        super(executorThread, uiThread);
        this.repository = repository;
    }

    @Override
    protected Observable<Bitmap> createObservableUseCase() {
        return this.repository.getImage();
    }
}
