package com.example.christoforoskolovos.cleanapp;


import java.util.HashSet;

import io.reactivex.Observable;

/**
 * Created by christoforos on 19/04/2018.
 */

public class GlobalObservables<T> {

    private static GlobalObservables instance;
    private HashSet<Observable<T>> observables;

    public GlobalObservables() {
        this.observables = new HashSet<>();
    }

    public static GlobalObservables getInstance() {
        if (instance == null) {
            instance = new GlobalObservables();
        }
        return instance;
    }

    public <K> Observable<K> getObservable(K type) {
        Observable<K> result = null;
        for (Observable<T> observable : observables) {
            result = (Observable<K>)observable ;
        }
        return result;

        //if it is not in list it must be added
    }

    public void setObservable(Observable<T> observable) {
        this.observables.add(observable);
    }
}
