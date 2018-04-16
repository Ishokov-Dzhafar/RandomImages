package com.test.randomimages.presenter;

import android.graphics.drawable.Drawable;

import com.test.randomimages.model.MainFragmentModelImpl;

import javax.inject.Inject;

import io.reactivex.observers.DisposableObserver;

/**
 * Created by dzhafar on 15.04.18.
 */

public class MainFragmentPresenter extends Presenter<MainFragmentPresenter.View>  {


    private MainFragmentModelImpl model;

    @Inject
    public MainFragmentPresenter(MainFragmentModelImpl model) {
        this.model = model;
    }

    @Override
    public void initialize() {
        super.initialize();
        getRandomImage();
    }

    public void getRandomImage() {
        getView().showLoading();
        model.execute(new DisposableObserver<Drawable>() {
            @Override
            public void onNext(Drawable drawable) {
                getView().onSuccessImage(drawable);
            }

            @Override
            public void onError(Throwable e) {
                getView().hideLoading();
            }

            @Override
            public void onComplete() {
                getView().hideLoading();
            }
        });

        //getRandomImage().onSuccessImage(model.getImage());

    }

    public interface View extends Presenter.View {
        void onSuccessImage(Drawable drawable);
    }
}
