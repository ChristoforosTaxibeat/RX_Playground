package com.example.christoforoskolovos.cleanapp.domain.repository;

/**
 * Created by christoforoskolovos on 10/10/2017.
 */

public interface FoursquareDataSource {

    void getNearbyVenues(double lat, double lng, int radius, int limit);
}
