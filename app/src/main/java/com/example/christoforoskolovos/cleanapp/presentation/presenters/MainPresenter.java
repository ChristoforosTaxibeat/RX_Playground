package com.example.christoforoskolovos.cleanapp.presentation.presenters;

import android.location.Location;
import android.util.Log;
import android.widget.Toast;

import com.example.christoforoskolovos.cleanapp.data.repository.FoursquareRepository;
import com.example.christoforoskolovos.cleanapp.domain.interactors.FoursquareNearbyVenuesUseCase;
import com.example.christoforoskolovos.cleanapp.domain.models.responses.FoursquareResults;
import com.example.christoforoskolovos.cleanapp.presentation.screens.MainScreen;
import com.google.android.gms.maps.model.LatLng;

import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

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

        Observer<FoursquareResults> FoursquareVenuesSearchResponseObserver = new Observer<FoursquareResults>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {
                Log.i("Chris", "onSubscribe");
            }

            @Override
            public void onNext(@NonNull FoursquareResults foursquareVenuesSearchResponse) {
                Log.i("Chris", "onNext");
            }

            @Override
            public void onError(@NonNull Throwable e) {
                Log.i("Chris", "onError");

                if (e instanceof Error) { //todo not working correctly
                    Error error = (Error) e;
                    Toast.makeText(screen.getScreenContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onComplete() {
                Log.i("Chris", "onComplete");
            }
        };

        new FoursquareNearbyVenuesUseCase(
                FoursquareRepository.getInstance(),
                target.latitude,
                target.longitude,
                1000,
                20
        ).execute(FoursquareVenuesSearchResponseObserver);

        Log.i("Chris", "onMapStopMoving");
    }

    public void onMapStartMoving() {

        Log.i("Chris", "onMapStartMoving");
    }

    public void onLocationChanged(Location location) {
        screen.focusMapOnLocation(location);

        Log.i("Chris", "onLocationChanged");
    }


}