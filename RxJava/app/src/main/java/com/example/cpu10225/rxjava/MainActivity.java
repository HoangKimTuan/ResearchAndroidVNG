package com.example.cpu10225.rxjava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;

public class MainActivity extends AppCompatActivity {
    String movie;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Just and From
        Integer[] integers = {1,2,3};
        Observable.just(integers)
                .subscribe(System.out::println);
        Observable.fromArray(integers)
                .subscribe(System.out::println);

        // Defer
        movie = new String("Captain America: Civil War");
        Observable<String> movieObservable = Observable.defer(() -> Observable.just(movie));
        movie = new String("Batman v Superman: Dawn of Justice");
        movieObservable.subscribe(System.out::println);

        // Interval
        Observable.interval(1, TimeUnit.SECONDS).subscribe(System.out::println);

        // Create
        Observable.create( subscriber-> {
            subscriber.onNext(1);
            subscriber.onNext(2);
            subscriber.onNext(3);
            subscriber.onComplete();
        }).subscribe(System.out::println);


        // Range
        Observable.range(0, 10)
                .buffer(2, 3)
                .subscribe(System.out::println);

        // Empty
        Observable.empty().subscribe(System.out::println);

        // Never
        Observable.never().subscribe(System.out::println);

        // Throw
        Observable.error(new RuntimeException()).subscribe(System.out::println);

        // Repeat
        Observable.just(integers).repeatWhen(new Function<Observable<Object>, ObservableSource<?>>() {
            @Override
            public ObservableSource<?> apply(Observable<Object> objectObservable) throws Exception {
                return null;
            }
        });
    }
}