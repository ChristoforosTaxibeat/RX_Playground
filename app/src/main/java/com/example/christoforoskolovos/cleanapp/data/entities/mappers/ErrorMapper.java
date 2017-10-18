package com.example.christoforoskolovos.cleanapp.data.entities.mappers;

import com.example.christoforoskolovos.cleanapp.domain.models.responses.errors.Error;

import java.io.IOException;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;
import retrofit2.HttpException;

/**
 * Created by christoforoskolovos on 18/10/2017.
 */

public class ErrorMapper<T> implements Function<Throwable, ObservableSource<T>> {
    private final int ERROR_REDIRECT = 303;
    private final int BAD_REQUEST = 400;
    private final int ERROR_UNAUTHORIZED = 401;
    private final int ERROR_NOT_FOUND = 404;
    private final int ERROR_INTERNAL = 500;
    private final int ERROR_BAD_GATEWAY = 502;
    private final int ERROR_UNAVAILABLE_SERVICE = 503;

    @Override
    public ObservableSource<T> apply(@NonNull Throwable throwable) throws Exception {
        Error error = new Error();

        if (throwable instanceof HttpException) {
            // We had non-2XX http error
            int code = ((HttpException) throwable).code();
            if (code == ERROR_REDIRECT) {
                error.setName("ERROR_REDIRECT");
                error.setMessage("Redirect.");
            } else if (code == BAD_REQUEST) {
                error.setName("BAD_REQUEST");
                error.setMessage("Bad request.");
            } else if (code == ERROR_UNAUTHORIZED) {
                error.setName("ERROR_UNAUTHORIZED");
                error.setMessage("Unauthorized.");
            } else if (code == ERROR_NOT_FOUND) {
                error.setName("ERROR_NOT_FOUND");
                error.setMessage("Not found.");
            } else if (code == ERROR_INTERNAL) {
                error.setName("ERROR_INTERNAL");
                error.setMessage("Internal error.");
            } else if (code == ERROR_BAD_GATEWAY) {
                error.setName("ERROR_BAD_GATEWAY");
                error.setMessage("Bad gateway.");
            } else if (code == ERROR_UNAVAILABLE_SERVICE) {
                error.setName("ERROR_UNAVAILABLE_SERVICE");
                error.setMessage("Unavailable service.");
            } else {
                error.setName("UNKNOWN_ERROR");
                error.setMessage("Unknown error.");
            }
        }
        if (throwable instanceof IOException) {
            // A network or conversion error happened
            error.setName("NETWORK_OR_CONNECTION_ERROR");
            error.setMessage("Network or conversion error.");
        } else {
            //Unknown error
            error.setName("UNKNOWN_ERROR");
            error.setMessage("Unknown error.");
        }

        return Observable.error(new Error());
    }
}
