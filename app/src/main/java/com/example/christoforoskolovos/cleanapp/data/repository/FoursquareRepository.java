package com.example.christoforoskolovos.cleanapp.data.repository;

import com.example.christoforoskolovos.cleanapp.data.clients.FoursquareClient;
import com.example.christoforoskolovos.cleanapp.data.clients.RestClient;
import com.example.christoforoskolovos.cleanapp.data.entities.responses.Foursquare.FoursquareVenuesSearchResponse;
import com.example.christoforoskolovos.cleanapp.domain.repository.FoursquareDataSource;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by christoforoskolovos on 10/10/2017.
 */

public class FoursquareRepository implements FoursquareDataSource {

    //--------------- Sigleton Implementation ---------------
    private static FoursquareRepository INSTANCE;

    public static FoursquareRepository getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new FoursquareRepository();
        }

        return INSTANCE;
    }

    //--------------- Variables ---------------
    final String BASE_URL = "https://api.foursquare.com/v2/";
    final String CLIENT_ID = "MMLMKZKIDZJXJTBNRLUMP4EUPQKOEJQEXOPVVKU111SBJQQM";
    final String CLIENT_SECRET = "5XD1J5PBYSSIMSUSKTOOD4SCRJG2RSOGBET2KD5HI5KKU2TA";
    final String VERSION = "20150301";
    private FoursquareClient client;
    private Call<FoursquareVenuesSearchResponse> request;


    //--------------- Constructor ---------------
    private FoursquareRepository() {
        client = RestClient.setupForUrl(BASE_URL)
                .create(FoursquareClient.class);
    }


    //--------------- Methods ---------------
    @Override
    public void getNearbyVenues(double lat, double lng, int radius, int limit) {
        Map<String, String> parameters = new HashMap<>();
        parameters.put("ll", lat + "," + lng);
        parameters.put("radius", Integer.toString(radius));
        parameters.put("limit", Integer.toString(limit));
        parameters.put("intent", "checkin");
        parameters.put("client_secret", CLIENT_SECRET);
        parameters.put("client_id", CLIENT_ID);
        parameters.put("v", VERSION);

        if (request != null)
            request.cancel();

        request = client.getVenues(parameters);

        request.enqueue(new Callback<FoursquareVenuesSearchResponse>() {
            @Override
            public void onResponse(Call<FoursquareVenuesSearchResponse> call, Response<FoursquareVenuesSearchResponse> response) {
                // TODO: 10/10/2017 use mapper and return data to UseCase
            }

            @Override
            public void onFailure(Call<FoursquareVenuesSearchResponse> call, Throwable t) {
                // TODO: 10/10/2017 use mapper and return data to UseCase
            }
        });

    }

}
