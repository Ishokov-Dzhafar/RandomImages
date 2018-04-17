package com.test.randomimages.data.datasource;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;

import io.reactivex.Observable;


/**
 * Created by dzhafar on 16.04.18.
 */

public interface DataSource {
    Observable<Bitmap> getImage();
}
