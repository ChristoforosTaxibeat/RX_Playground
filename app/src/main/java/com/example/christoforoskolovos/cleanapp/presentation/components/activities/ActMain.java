package com.example.christoforoskolovos.cleanapp.presentation.components.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.christoforoskolovos.cleanapp.R;
import com.example.christoforoskolovos.cleanapp.presentation.presenters.MainPresenter;
import com.example.christoforoskolovos.cleanapp.presentation.presenters.Presenter;
import com.example.christoforoskolovos.cleanapp.presentation.screens.MainScreen;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.Single;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;

public class ActMain extends BaseActivity implements MainScreen, View.OnClickListener {

    /*-------------------- Variables --------------------*/
    private MainPresenter presenter;

    Button btn;


    int counter;


    /*-------------------- Basic Methods --------------------*/
    public static Intent getCallingIntent(Context context) {
        Intent intent = new Intent(context, ActMain.class);
        return intent;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        initPresenter();
        test();
    }

    private void initViews() {
        btn = (Button) findViewById(R.id.btn);
        btn.setOnClickListener(this);
    }

    private void initPresenter() {
        presenter = new MainPresenter(this);
        presenter.initialize();
    }


    /*-------------------- Base Activity Methods --------------------*/
    @Override
    protected Presenter getCurrentPresenter() {
        return presenter;
    }

    @Override
    public Context getAppContext() {

        return getApplicationContext();
    }

    @Override
    public Context getScreenContext() {
        return null;
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showError() {

    }


    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn) {
            counter++;
        }
    }

		
	/*-------------------- Screen Methods --------------------*/
    //todo...


    /*-------------------- Activity Methods --------------------*/
    private void test() {

        DisposableObserver<String> observer = new DisposableObserver<String>() {

            @Override
            public void onNext(@NonNull String s) {
                Log.i("Chris", s + " 0");
            }

            @Override
            public void onError(@NonNull Throwable e) {
            }

            @Override
            public void onComplete() {
            }
        };

        DisposableObserver<String> observer1 = new DisposableObserver<String>() {

            @Override
            public void onNext(@NonNull String s) {
                Log.i("Chris", s + " 1");
            }

            @Override
            public void onError(@NonNull Throwable e) {
            }

            @Override
            public void onComplete() {
            }
        };

        DisposableObserver<String> observer2 = new DisposableObserver<String>() {

            @Override
            public void onNext(@NonNull String s) {
                Log.i("Chris", s + " 2");
            }

            @Override
            public void onError(@NonNull Throwable e) {
            }

            @Override
            public void onComplete() {
            }
        };

        DisposableObserver<String> observer3 = new DisposableObserver<String>() {

            @Override
            public void onNext(@NonNull String s) {
                Log.i("Chris", s + " 3");
            }

            @Override
            public void onError(@NonNull Throwable e) {
            }

            @Override
            public void onComplete() {
            }
        };


        Observable<String> observable = Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<String> e) throws Exception {
                try {
                    e.onNext("success");
                } catch (Exception exception) {
                    e.onError(exception);
                }
            }
        });


        Observable<String> cachedObservable = observable.cache();

        cachedObservable.subscribeWith(observer);
        cachedObservable.subscribeWith(observer1);
        cachedObservable.subscribeWith(observer2);
        cachedObservable.subscribeWith(observer3);

    }
}