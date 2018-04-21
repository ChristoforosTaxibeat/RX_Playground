package com.example.christoforoskolovos.cleanapp;


import android.util.Log;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observable;
import io.reactivex.Observer;


/**
 * Created by christoforos on 19/04/2018.
 */

public class GlobalObservables<T> {

    private static GlobalObservables instance;
    private HashMap<Class<T>, Observable<T>> typeObservables;

    public GlobalObservables() {
        this.typeObservables = new HashMap<>();
    }

    public static GlobalObservables getInstance() {
        if (instance == null) {
            instance = new GlobalObservables();
        }
        return instance;
    }

    public Observable<T> getObservable(Class<T> type) {
        Observable<T> result = null;

        for (Map.Entry<Class<T>, Observable<T>> entry : typeObservables.entrySet()) {
            Class<T> key = entry.getKey();
            Observable<T> value = entry.getValue();
            if (key.getName().equals(type.getName())) {
                result = value;
            }
        }

        if (result == null) {
            result = new Observable<T>() {
                @Override
                protected void subscribeActual(Observer<? super T> observer) {

                }
            };
        }
        return result;
    }

    public void setObservable(Class<T> type, Observable<T> observable) {
        this.typeObservables.put(type, observable);
    }
}
