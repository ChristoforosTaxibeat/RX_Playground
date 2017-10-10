package com.example.christoforoskolovos.cleanapp.data.entities.responses.Foursquare;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by christoforoskolovos on 10/10/2017.
 */

public class FoursquareIcon {
    @SerializedName("prefix")
    @Expose
    private String prefix;

    @SerializedName("suffix")
    @Expose
    private String suffix;


    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }
}
