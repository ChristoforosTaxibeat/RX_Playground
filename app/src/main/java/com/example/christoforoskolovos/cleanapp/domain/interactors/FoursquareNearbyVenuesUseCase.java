package com.example.christoforoskolovos.cleanapp.domain.interactors;

import com.example.christoforoskolovos.cleanapp.domain.repository.FoursquareDataSource;

/**
 * Created by christoforoskolovos on 10/10/2017.
 */

public class FoursquareNearbyVenuesUseCase implements UseCase {

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
    public void execute() {
        dataSource.getNearbyVenues(lat, lng, radius, limit);
        //// TODO: 10/10/2017 must return data to presenter
    }
}
