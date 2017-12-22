package com.example.cpu10225.dagger2mockitojunitruleandroidtest;

import javax.inject.Inject;

/**
 * Created by cpu10225 on 22/12/2017.
 */

public class MainService {
    private RestService restService;
    private MyPrinter printer;

    @Inject
    public MainService(RestService restService,
                               MyPrinter printer) {
        this.restService = restService;
        this.printer = printer;
    }

    public void doSomething() {
        String s = restService.getSomething();
        printer.print(s.toUpperCase());
    }
}

class RestService {
    public String getSomething() {
        return "Hello world";
    }
}

class MyPrinter {
    public void print(String s) {
        System.out.println(s);
    }
}