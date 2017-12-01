package com.example.cpu10225.rxjava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import io.reactivex.observables.GroupedObservable;

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
        // Observable.interval(1, TimeUnit.SECONDS).subscribe(System.out::println);

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
        // Observable.error(new RuntimeException()).subscribe(System.out::println);

        // Repeat
        AtomicInteger c = new AtomicInteger();
        Observable.just(1)
                .repeatWhen(o -> o.takeWhile((v -> c.getAndIncrement() == 0)))
                .subscribe(System.out::println, Throwable::printStackTrace, () -> System.out.println("Done"));

        // Start
        Observable.fromCallable(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "Hello";
            }
        });

        // Timer
        Observable.timer(1, TimeUnit.SECONDS).subscribe(System.out::println);

        // Buffer
        Observable.range(0, 10)
                .buffer(3, 4)
                .subscribe(System.out::println);

        // FlatMap
        Observable.just(integers)
                .flatMap(ints -> Observable.fromArray(ints))
                .subscribe(System.out::println);

        // GroupBy
        Observable.range(0, 10)
                .groupBy(n -> n % 2 == 0)
                .subscribe((group) -> {((GroupedObservable)group).subscribe((x) -> System.out.println(((GroupedObservable)group).getKey() + ": " + x));});

        // Map
        Observable.fromArray(integers)
                .map(i -> "STT: " + i)
                .subscribe(System.out::println);

        // Scan ???
        Observable.range(1, 10)
                .scan((integer, integer2) -> integer2 + integer)
                .subscribe(System.out::println);

        // Window ???
        Observable.range(0, 5)
                .window(3, 1)
                .subscribe(System.out::println);
    }
}