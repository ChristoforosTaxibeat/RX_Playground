package com.example.christoforoskolovos.cleanapp.presentation.screens;

import android.content.Context;

public interface BaseScreen {
    Context getAppContext();

    Context getScreenContext();

    void showLoading();

    void hideLoading();

    void showError();
}
