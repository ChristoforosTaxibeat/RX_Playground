package com.example.christoforoskolovos.cleanapp.data.clients;

import com.example.christoforoskolovos.cleanapp.data.entities.responses.Foursquare.FoursquareVenuesSearchResponse;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;

/**
 * Created by christoforoskolovos on 10/10/2017.
 */

public interface FoursquareClient {
    @GET("venues/search")
    Call<FoursquareVenuesSearchResponse> getVenues(@QueryMap Map<String, String> parameters);
}
