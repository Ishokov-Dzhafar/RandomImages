package com.test.randomimages.view.activities;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.test.randomimages.R;
import com.test.randomimages.view.fragments.MainFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            Fragment fragment = new MainFragment();
            ft.replace(R.id.container, fragment);
            ft.commit();
        }
    }
}
