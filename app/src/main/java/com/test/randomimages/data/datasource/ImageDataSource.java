package com.test.randomimages.data.datasource;


import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;

import com.test.randomimages.data.datasource.factoryImage.ImageLoadingMethod;

import javax.inject.Inject;

import io.reactivex.Observable;


/**
 * Created by dzhafar on 16.04.18.
 */

public class ImageDataSource implements DataSource {

    private ImageLoadingMethod imageLoadingMethod;
    private final String imageAPI = "https://picsum.photos/600/800/?random";


    @Inject ImageDataSource(ImageLoadingMethod imageLoadingMethod) {
        this.imageLoadingMethod = imageLoadingMethod;
    }

    @Override
    public Observable<Bitmap> getImage() {
        return this.imageLoadingMethod.getImage(ImageLoadingMethod.ImageType.OKHTTP).loadImage(imageAPI);
    }
}
