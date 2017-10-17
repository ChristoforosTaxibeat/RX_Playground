package com.example.christoforoskolovos.cleanapp.domain.interactors;

import io.reactivex.Observer;

/**
 * Created by christoforoskolovos on 10/10/2017.
 */

public interface UseCase<T>{
    void execute(Observer<T> observer);
}
