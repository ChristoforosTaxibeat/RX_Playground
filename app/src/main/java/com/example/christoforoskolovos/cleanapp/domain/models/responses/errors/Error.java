package com.example.christoforoskolovos.cleanapp.domain.models.responses.errors;

/**
 * Created by christoforoskolovos on 18/10/2017.
 */

public class Error extends Throwable {
    private String name;
    private String message;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
