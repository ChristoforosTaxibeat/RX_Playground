package com.example.christoforoskolovos.cleanapp.presentation.screens;

import android.location.Location;

public interface MainScreen extends BaseScreen {

    void focusMapOnLocation(Location location);
}