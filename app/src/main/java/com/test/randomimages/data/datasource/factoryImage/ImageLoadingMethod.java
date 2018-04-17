package com.test.randomimages.data.datasource.factoryImage;

import javax.inject.Inject;

/**
 * Created by dzhafar on 17.04.18.
 */

public class ImageLoadingMethod {
    public enum ImageType {INPUT_STREAM, OKHTTP}

    @Inject
    ImageLoadingMethod() {}


    public AbstractImageLoading getImage(ImageType type) throws RuntimeException {
        switch (type) {
            case INPUT_STREAM:
                return new ISImageLoading();
            case OKHTTP:
                return new OkhttpImageLoading();
            default:
                throw new RuntimeException("Loading ImageType not exist");
        }
    }
}
