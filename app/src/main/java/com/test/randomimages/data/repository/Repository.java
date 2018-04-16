package com.test.randomimages.data.repository;

import android.graphics.drawable.Drawable;

import io.reactivex.Observable;

/**
 * Created by dzhafar on 16.04.18.
 */

public interface Repository {
    Observable<Drawable> getImage();
}
