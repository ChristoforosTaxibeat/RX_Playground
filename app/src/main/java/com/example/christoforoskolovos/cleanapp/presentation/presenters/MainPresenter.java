package com.example.christoforoskolovos.cleanapp.presentation.presenters;

import android.location.Location;

import com.example.christoforoskolovos.cleanapp.data.repository.FoursquareRepository;
import com.example.christoforoskolovos.cleanapp.domain.interactors.FoursquareNearbyVenuesUseCase;
import com.example.christoforoskolovos.cleanapp.domain.repository.FoursquareDataSource;
import com.example.christoforoskolovos.cleanapp.presentation.screens.MainScreen;
import com.google.android.gms.maps.model.LatLng;

public class MainPresenter extends BasePresenter implements Presenter {

    /*-------------------- Variables --------------------*/
    protected MainScreen screen;


    /*-------------------- Basic  Methods --------------------*/
    public MainPresenter(MainScreen screen) {
        super();
        this.screen = screen;
    }

    public void initialize() {
    }

    /*-------------------- Other Methods --------------------*/
    public void onMapStopMoving(LatLng target) {
        new FoursquareNearbyVenuesUseCase(
                FoursquareRepository.getInstance(),
                target.latitude,
                target.longitude,
                1000,
                20
        ).execute();
    }

    public void onMapStartMoving() {
    }

    public void onLocationChanged(Location location) {
        screen.focusMapOnLocation(location);
    }


}