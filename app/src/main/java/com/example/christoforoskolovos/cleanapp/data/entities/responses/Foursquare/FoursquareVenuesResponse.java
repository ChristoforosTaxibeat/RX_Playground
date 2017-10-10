package com.example.christoforoskolovos.cleanapp.data.entities.responses.Foursquare;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by christoforoskolovos on 10/10/2017.
 */

public class FoursquareVenuesResponse {
    @SerializedName("venues")
    @Expose
    private List<FoursquareVenue> venues = null;

    @SerializedName("confident")
    @Expose
    private Boolean confident;


    public List<FoursquareVenue> getVenues() {
        return venues;
    }

    public void setVenues(List<FoursquareVenue> venues) {
        this.venues = venues;
    }

    public Boolean getConfident() {
        return confident;
    }

    public void setConfident(Boolean confident) {
        this.confident = confident;
    }
}
