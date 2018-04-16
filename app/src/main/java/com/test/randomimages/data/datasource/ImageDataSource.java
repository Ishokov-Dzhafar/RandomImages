package com.test.randomimages.data.datasource;


import android.graphics.drawable.Drawable;

import javax.inject.Inject;

import io.reactivex.Observable;


/**
 * Created by dzhafar on 16.04.18.
 */

public class ImageDataSource implements DataSource {

    @Inject ImageDataSource() {
    }

    @Override
    public Observable<Drawable> getImage() {
        return Observable.create(emitter -> {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    emitter.onError(new Throwable("Nado dodelat"));
                }
            }).start();
        });
    }
}
