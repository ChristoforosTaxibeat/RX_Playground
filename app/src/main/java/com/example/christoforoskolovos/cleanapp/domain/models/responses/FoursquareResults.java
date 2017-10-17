package com.example.christoforoskolovos.cleanapp.domain.models.responses;

import java.util.List;

/**
 * Created by christoforoskolovos on 17/10/2017.
 */

public class FoursquareResults {
    private List<Venue> venues = null;

    public List<Venue> getVenues() {
        return venues;
    }

    public void setVenues(List<Venue> venues) {
        this.venues = venues;
    }
}
