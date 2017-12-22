package com.example.cpu10225.dagger2mockitojunitruleandroidtest;

import org.mockito.Mockito;

/**
 * Created by cpu10225 on 22/12/2017.
 */

public class TestModule extends MyModule {
    @Override public MyPrinter provideMyPrinter() {
        return Mockito.mock(MyPrinter.class);
    }

    @Override public RestService provideRestService() {
        return Mockito.mock(RestService.class);
    }
}