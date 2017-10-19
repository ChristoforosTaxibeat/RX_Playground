package com.example.christoforoskolovos.cleanapp.presentation.components.activities;

import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.christoforoskolovos.cleanapp.R;
import com.example.christoforoskolovos.cleanapp.presentation.presenters.MainPresenter;
import com.example.christoforoskolovos.cleanapp.presentation.presenters.Presenter;
import com.example.christoforoskolovos.cleanapp.presentation.screens.MainScreen;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

public class MainActivity extends BaseActivity implements MainScreen, View.OnClickListener, OnMapReadyCallback, LocationListener {

    /*-------------------- Variables --------------------*/
    private MainPresenter presenter;

    private GoogleMap map;


    /*-------------------- Basic Methods --------------------*/
    public static Intent getCallingIntent(Context context) {
        Intent intent = new Intent(context, MainActivity.class);
        return intent;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        initPresenter();
    }

    private void initViews() {
        //Set Map Fragment
        MapFragment mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    private void initPresenter() {
        presenter = new MainPresenter(this);
        presenter.initialize();
    }


    /*-------------------- Other Methods --------------------*/
    @Override
    protected Presenter getCurrentPresenter() {
        return presenter;
    }

    @Override
    public Context getAppContext() {
        return getApplicationContext();
    }

    @Override
    public Context getScreenContext() {
        return this;
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showError() {

    }

    @Override
    public void onClick(View v) {
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        map = googleMap;

        map.setOnCameraIdleListener(new GoogleMap.OnCameraIdleListener() {
            @Override
            public void onCameraIdle() {
                presenter.onMapStopMoving(map.getCameraPosition().target);
            }
        });

        map.setOnCameraMoveStartedListener(new GoogleMap.OnCameraMoveStartedListener() {
            @Override
            public void onCameraMoveStarted(int i) {
                presenter.onMapStartMoving();
            }
        });
    }

    @Override
    public void onLocationChanged(Location location) {
        presenter.onLocationChanged(location);
    }

    @Override
    public void focusMapOnLocation(Location location) {
        map.animateCamera(CameraUpdateFactory.newLatLngZoom(
                new LatLng(location.getLatitude(), location.getLongitude()), 16), 1000, null);
    }


    void test() {

        final List<String> strings = new ArrayList<String>();
        strings.add("1");
        strings.add("2");
        strings.add("3");
        strings.add("4");
        strings.add("5");


        //Create observable (full method)
        Observable<String> observable1 = Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> emitter) throws Exception {
                try {

                    for (String string : strings) {
                        emitter.onNext(string);
                    }

                    emitter.onComplete();
                } catch (Exception e) {
                    emitter.onError(e);
                }
            }
        });

        //Create observable (Convinience method)
        Observable<String> observable2 = Observable.fromIterable(strings);


        //Create observer (subscriber)
        Observer<String> observer1 = new Observer<String>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(@NonNull String s) {

            }

            @Override
            public void onError(@NonNull Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        };

        //Subscribe
        observable1.subscribe(observer1);

    }

}