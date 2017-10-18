package com.example.christoforoskolovos.cleanapp.data.entities.responses.Foursquare;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by christoforoskolovos on 10/10/2017.
 */

public class FoursquareVenuesSearchResponse  {

    @SerializedName("meta")
    @Expose
    private FoursquareMeta meta;

    @SerializedName("response")
    @Expose
    private FoursquareVenuesResponse response;


    public FoursquareMeta getMeta() {
        return meta;
    }

    public void setMeta(FoursquareMeta meta) {
        this.meta = meta;
    }

    public FoursquareVenuesResponse getResponse() {
        return response;
    }

    public void setResponse(FoursquareVenuesResponse response) {
        this.response = response;
    }

}
