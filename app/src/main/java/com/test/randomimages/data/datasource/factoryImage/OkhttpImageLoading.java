package com.test.randomimages.data.datasource.factoryImage;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.IOException;
import java.io.InputStream;

import io.reactivex.Observable;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class OkhttpImageLoading extends AbstractImageLoading {


    @Override
    public Observable<Bitmap> loadImage(String url) {
        return Observable.create(emitter -> {
            final OkHttpClient client = new OkHttpClient();
            try {
                Request request = new Request.Builder()
                        .url(url)
                        .build();
                Response response = client.newCall(request).execute();
                InputStream inputStream = response.body().byteStream();
                Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
                emitter.onNext(bitmap);
                emitter.onComplete();

            } catch (IOException e) {
                emitter.onError(e);
            }
        });


    }
}
