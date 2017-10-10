package com.example.christoforoskolovos.cleanapp.data.entities.responses.Foursquare;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by christoforoskolovos on 10/10/2017.
 */

public class FoursquareVenue {
    @SerializedName("id")
    @Expose
    private String id;

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("foursquareLocation")
    @Expose
    private FoursquareLocation foursquareLocation;

    @SerializedName("categories")
    @Expose
    private List<FoursquareCategory> categories = null;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public FoursquareLocation getFoursquareLocation() {
        return foursquareLocation;
    }

    public void setFoursquareLocation(FoursquareLocation foursquareLocation) {
        this.foursquareLocation = foursquareLocation;
    }

    public List<FoursquareCategory> getCategories() {
        return categories;
    }

    public void setCategories(List<FoursquareCategory> categories) {
        this.categories = categories;
    }
}
