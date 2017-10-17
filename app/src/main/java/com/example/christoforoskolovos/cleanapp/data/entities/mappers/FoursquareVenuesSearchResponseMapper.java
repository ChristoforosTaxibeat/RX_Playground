package com.example.christoforoskolovos.cleanapp.data.entities.mappers;

import com.example.christoforoskolovos.cleanapp.domain.models.responses.FoursquareResults;
import com.example.christoforoskolovos.cleanapp.domain.models.responses.Venue;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;

/**
 * Created by christoforoskolovos on 17/10/2017.
 */

public class FoursquareVenuesSearchResponseMapper implements Function<com.example.christoforoskolovos.cleanapp.data.entities.responses.Foursquare.FoursquareVenuesSearchResponse, FoursquareResults> {
    @Override
    public FoursquareResults apply(@NonNull com.example.christoforoskolovos.cleanapp.data.entities.responses.Foursquare.FoursquareVenuesSearchResponse foursquareVenuesSearchResponse) throws Exception {
        FoursquareResults result = new FoursquareResults();

        List<Venue> venues = new ArrayList<>();

        if (foursquareVenuesSearchResponse.getResponse() != null) {

            for (int i = 0; i < foursquareVenuesSearchResponse.getResponse().getVenues().size(); i++) {
                Venue venue = new Venue();
                venue.setId(foursquareVenuesSearchResponse.getResponse().getVenues().get(i).getId());
                venue.setName(foursquareVenuesSearchResponse.getResponse().getVenues().get(i).getName());
                venues.add(venue);
            }

        }

        result.setVenues(venues);

        return result;
    }
}
