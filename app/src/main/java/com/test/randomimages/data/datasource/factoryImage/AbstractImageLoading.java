package com.test.randomimages.data.datasource.factoryImage;

import android.graphics.Bitmap;

import io.reactivex.Observable;

/**
 * Created by dzhafar on 17.04.18.
 */

public abstract class AbstractImageLoading {
    public abstract Observable<Bitmap> loadImage(String url);
}
