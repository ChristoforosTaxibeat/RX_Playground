package com.example.christoforoskolovos.cleanapp.data.entities.responses.Foursquare;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by christoforoskolovos on 10/10/2017.
 */

public class FoursquareMeta {
    @SerializedName("code")
    @Expose
    private Integer code;

    @SerializedName("requestId")
    @Expose
    private String requestId;


    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }
}
