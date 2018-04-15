package com.test.randomimages.view.interfaces;

import android.graphics.Bitmap;

/**
 * Created by dzhafar on 15.04.18.
 */

public interface MainFragmentView {

    void showProgress();
    void hideProgress();
    void onSuccessImage(Bitmap bitmap);
}
