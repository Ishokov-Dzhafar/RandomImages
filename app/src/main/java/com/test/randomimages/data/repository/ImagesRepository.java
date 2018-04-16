package com.test.randomimages.data.repository;

import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;

import com.test.randomimages.data.datasource.DataSource;
import com.test.randomimages.data.datasource.ImageDataSource;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;

/**
 * Created by dzhafar on 16.04.18.
 */
@Singleton
public class ImagesRepository implements Repository {

    private final DataSource dataSource;

    @Inject
    ImagesRepository(@NonNull ImageDataSource dataSource) {
        this.dataSource = dataSource;
    }


    @Override
    public Observable<Drawable> getImage() {
        return dataSource.getImage();
    }
}
