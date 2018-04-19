package com.example.christoforoskolovos.cleanapp.data.repository;

import com.example.christoforoskolovos.cleanapp.GlobalObservables;
import com.example.christoforoskolovos.cleanapp.data.clients.FoursquareClient;
import com.example.christoforoskolovos.cleanapp.data.clients.RestClient;
import com.example.christoforoskolovos.cleanapp.data.entities.mappers.ErrorMapper;
import com.example.christoforoskolovos.cleanapp.data.entities.mappers.FoursquareVenuesSearchResponseMapper;
import com.example.christoforoskolovos.cleanapp.domain.models.responses.FoursquareResults;
import com.example.christoforoskolovos.cleanapp.domain.repository.FoursquareDataSource;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observable;

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

        GlobalObservables.getInstance().setObservable(client.getVenues(parameters)
                .map(new FoursquareVenuesSearchResponseMapper())
                .onErrorResumeNext(new ErrorMapper<FoursquareResults>()));
    }

}
