package com.test.randomimages.data.datasource.factoryImage;


import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import io.reactivex.Observable;

/**
 * Created by dzhafar on 17.04.18.
 */

public class ISImageLoading extends AbstractImageLoading {
    @Override
    public Observable<Bitmap> loadImage(String url) {
        return Observable.create(emitter -> {
            Bitmap bitmap = null;
            try {
                final InputStream inputStream = new URL(url).openStream();
                bitmap = BitmapFactory.decodeStream(inputStream);
            } catch (final MalformedURLException malformedUrlException) {
                emitter.onError(malformedUrlException);
                // Handle error
            } catch (final IOException ioException) {
                emitter.onError(ioException);
                // Handle error
            }
            emitter.onNext(bitmap);
            emitter.onComplete();
        });
    }
}
