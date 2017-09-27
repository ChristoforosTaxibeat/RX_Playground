package com.example.christoforoskolovos.cleanapp.presentation.components.activities;

import android.support.v7.app.AppCompatActivity;

import com.example.christoforoskolovos.cleanapp.presentation.presenters.Presenter;

/**
 * Created by christoforoskolovos on 09/08/2017.
 */

public abstract class BaseActivity extends AppCompatActivity {

    protected abstract Presenter getCurrentPresenter();

}
