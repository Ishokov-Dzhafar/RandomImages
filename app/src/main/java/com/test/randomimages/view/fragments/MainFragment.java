package com.test.randomimages.view.fragments;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.test.randomimages.MainApplication;
import com.test.randomimages.R;
import com.test.randomimages.presenter.MainFragmentPresenter;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by dzhafar on 15.04.18.
 */

public class MainFragment extends Fragment implements MainFragmentPresenter.View {

    @Inject
    MainFragmentPresenter presenter;
    @BindView(R.id.progress)
    protected LinearLayout progress;
    @BindView(R.id.textTV)
    protected TextView textTV;


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
        presenter.getRandomImage();
        return view;
    }

    private void initializePresenter() {
        presenter.setView(this);
    }

    private void initializeDagger() {
        MainApplication app = (MainApplication) getActivity().getApplication();
        app.getMainFragmentComponent().inject(this);
    }

    @Override
    public void showLoading() {
        progress.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        progress.setVisibility(View.GONE);
    }

    @Override
    public void onSuccessImage(Drawable drawable) {

    }
}
