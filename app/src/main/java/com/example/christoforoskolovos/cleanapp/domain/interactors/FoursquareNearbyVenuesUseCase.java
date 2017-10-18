package com.example.christoforoskolovos.cleanapp.domain.interactors;

import com.example.christoforoskolovos.cleanapp.domain.models.responses.FoursquareResults;
import com.example.christoforoskolovos.cleanapp.domain.repository.FoursquareDataSource;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by christoforoskolovos on 10/10/2017.
 */

public class FoursquareNearbyVenuesUseCase implements UseCase<FoursquareResults> {

    private FoursquareDataSource dataSource;
    private double lat;
    private double lng;
    private int radius;
    private int limit;

    public FoursquareNearbyVenuesUseCase(FoursquareDataSource dataSource, double lat, double lng, int radius, int limit) {
        this.dataSource = dataSource;
        this.lat = lat;
        this.lng = lng;
        this.radius = radius;
        this.limit = limit;
    }

    @Override
    public void execute(Observer<FoursquareResults> observer) {
        dataSource.getNearbyVenues(lat, lng, radius, limit)
                .subscribeOn(Schedulers.io()) //todo optain it with another way through iterfaces
                .observeOn(AndroidSchedulers.mainThread()) //todo optain it with another way through iterfaces
                .subscribe(observer);

    }
}
