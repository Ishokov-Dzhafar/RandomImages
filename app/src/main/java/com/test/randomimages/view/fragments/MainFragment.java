package com.test.randomimages.view.fragments;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.test.randomimages.MainApplication;
import com.test.randomimages.R;
import com.test.randomimages.presenter.MainFragmentPresenter;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by dzhafar on 15.04.18.
 */

public class MainFragment extends Fragment implements MainFragmentPresenter.View {

    @Inject
    MainFragmentPresenter presenter;
    @BindView(R.id.progress)
    protected LinearLayout progress;
    @BindView(R.id.image)
    protected ImageView imageView;
    @BindView(R.id.loadNewBtn)
    protected Button loadNewBtn;
    @BindView(R.id.mainLayout)
    protected LinearLayout mainLayout;

    enum SavedState {IMAGE_STATE};


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
        initializeDagger();
        initializePresenter();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.main_fragment, container, false);
        ButterKnife.bind(this, view);
        if (savedInstanceState == null) presenter.getRandomImage();
        else {
            Bitmap bitmap = (Bitmap) savedInstanceState.getParcelable(SavedState.IMAGE_STATE.name());
            imageView.setImageBitmap(bitmap);
        }
        return view;
    }

    @Override
    public void onSaveInstanceState( Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelable(SavedState.IMAGE_STATE.name(), ((BitmapDrawable)imageView.getDrawable()).getBitmap());
    }

    private void initializePresenter() {
        presenter.setView(this);
    }

    private void initializeDagger() {
        MainApplication app = (MainApplication) getActivity().getApplication();
        app.getMainFragmentComponent().inject(this);
    }

    @OnClick(R.id.loadNewBtn)
    protected void loadNewBtnClick(View view) {
        presenter.getRandomImage();
    }

    @Override
    public void showLoading() {
        mainLayout.setVisibility(View.GONE);
        progress.setVisibility(View.VISIBLE);

    }

    @Override
    public void hideLoading() {
        progress.setVisibility(View.GONE);
        mainLayout.setVisibility(View.VISIBLE);
    }

    @Override
    public void onSuccessImage(Bitmap bitmap) {
        Log.d("Fragment","onSuccessImage");
        imageView.setImageBitmap(bitmap);
    }
}
