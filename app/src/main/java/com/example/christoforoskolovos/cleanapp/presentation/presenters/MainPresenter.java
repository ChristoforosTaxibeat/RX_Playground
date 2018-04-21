package com.example.christoforoskolovos.cleanapp.presentation.presenters;

import android.location.Location;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.christoforoskolovos.cleanapp.GlobalObservables;
import com.example.christoforoskolovos.cleanapp.data.repository.FoursquareRepository;
import com.example.christoforoskolovos.cleanapp.domain.interactors.FoursquareNearbyVenuesUseCase;
import com.example.christoforoskolovos.cleanapp.domain.models.responses.FoursquareResults;
import com.example.christoforoskolovos.cleanapp.domain.models.responses.Venue;
import com.example.christoforoskolovos.cleanapp.domain.models.responses.errors.Error;
import com.example.christoforoskolovos.cleanapp.presentation.screens.MainScreen;
import com.google.android.gms.maps.model.LatLng;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

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


        //Get and subscribe to observable 1
        GlobalObservables.getInstance()
                .getObservable(FoursquareResults.class)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<FoursquareResults>() {
                               @Override
                               public void onSubscribe(@NonNull Disposable d) {
                                   Log.i("Chris", "onSubscribe - Observable 1");
                               }

                               @Override
                               public void onNext(@NonNull FoursquareResults foursquareResults) {
                                   Log.i("Chris", "onNext - Observable 1");

                                   String message = "No results";
                                   if (foursquareResults != null && foursquareResults.getVenues().size() > 0) {
                                       message = "";
                                       for (Venue venue : foursquareResults.getVenues()) {
                                           message += venue.getName() + "\n";
                                       }
                                   }

                                   Toast.makeText(screen.getScreenContext(), message, Toast.LENGTH_SHORT).show();
                               }

                               @Override
                               public void onError(@NonNull Throwable e) {
                                   Log.i("Chris", "onError - Observable 1");

                                   if (e instanceof Error) { //todo not working correctly
                                       Error error = (Error) e;
                                       Toast.makeText(screen.getScreenContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
                                   }
                               }

                               @Override
                               public void onComplete() {
                                   Log.i("Chris", "onComplete - Observable 1");
                               }
                           }
                );

        //Get and subscribe to observable 2
        GlobalObservables.getInstance()
                .getObservable(String.class)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {
                               @Override
                               public void onSubscribe(Disposable d) {
                                   Log.i("Chris", "onSubscribe - Observable 2");
                               }

                               @Override
                               public void onNext(String s) {
                                   Log.i("Chris", "onNext - Observable 2 - " + s);
                               }

                               @Override
                               public void onError(Throwable e) {
                                   Log.i("Chris", "onError - Observable 2");
                               }

                               @Override
                               public void onComplete() {
                                   Log.i("Chris", "onComplete - Observable 2");
                               }
                           }
                );


        //Create and Set observable 1 through UseCase
        new FoursquareNearbyVenuesUseCase(
                FoursquareRepository.getInstance(),
                target.latitude,
                target.longitude,
                1000,
                20
        ).execute(null);

        //Create and Set observable 2
        Observable<String> stringObservable = Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> e) throws Exception {
                e.onNext("This is the emmited string value!!!!");
            }
        });
        GlobalObservables.getInstance().setObservable(String.class, stringObservable);


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