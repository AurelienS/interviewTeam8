package com.heuss.benomari.team8maquette;


import android.os.Bundle;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;


import io.reactivex.Observable;

import io.reactivex.disposables.Disposable;

import io.reactivex.observers.DisposableObserver;


public class MainActivity extends AppCompatActivity {


    private ProgressBar progressBar;
    private Button button_strength;
    private Disposable disposable;
    private TextView tags;
    private int strength_points = 1;
    private int tags_points = 5000;
    private TextView strength_level;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressBar = findViewById(R.id.strength_progressbar);
        button_strength = findViewById(R.id.strength_button);
        strength_level = findViewById(R.id.strength_level);

        tags = findViewById(R.id.tags_point);

        configureToolbar();
        configureButton();
        configureLevelUp();


    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        this.disposeWhenDestroy();

    }

    private void configureLevelUp() {
        strength_level.setText(Integer.toString(strength_points));
    }

    private void configureToolbar() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar ab = getSupportActionBar();
        if (ab != null) {
            ab.setTitle("Skills 1");
        }
    }

    private Observable<Integer> getObservable() {
        if (progressBar.getProgress() == 50) {
            return Observable.just(100);

        }
        if (progressBar.getProgress() == 100) {
            return Observable.just(50);
        } else {
            return Observable.just(50);
        }


    }


    private DisposableObserver<Integer> getSubscriber() {

        return new DisposableObserver<Integer>() {
            @Override
            public void onNext(Integer item) {
                progressBar.setProgress(item);

            }

            @Override
            public void onError(Throwable e) {
                Log.e("TAG", "On Error" + Log.getStackTraceString(e));

            }

            @Override
            public void onComplete() {

                Log.e("TAG", "On Complete !!");

            }

        };

    }

    private void streamUpdateProgress() {
        this.disposable = this.getObservable()
                .subscribeWith(getSubscriber());
    }


    private void disposeWhenDestroy() {
        if (this.disposable != null && !this.disposable.isDisposed()) this.disposable.dispose();

    }


    private void configureButton() {
        button_strength.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                usePoint();
                if (progressBar.getProgress() == 100) {
                    levelUp();
                }
                streamUpdateProgress();
                tags.setText(Integer.toString(tags_points));
                if (Integer.toString(tags_points).equals(Integer.toString(0))) {
                    button_strength.setVisibility(View.INVISIBLE);
                    strength_level.setText(Integer.toString(strength_points));


                }


            }
        });
    }

    private void usePoint() {
        tags_points = tags_points - 1000;

    }

    private void levelUp() {
        strength_points++;
        strength_level.setText(Integer.toString(strength_points));


    }


}






