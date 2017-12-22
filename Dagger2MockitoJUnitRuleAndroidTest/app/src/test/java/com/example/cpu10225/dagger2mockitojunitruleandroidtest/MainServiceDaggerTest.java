package com.example.cpu10225.dagger2mockitojunitruleandroidtest;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InOrder;
import org.mockito.Mockito;

import javax.inject.Inject;

import static org.mockito.Mockito.when;

/**
 * Created by cpu10225 on 22/12/2017.
 */

public class MainServiceDaggerTest {

    @Inject
    RestService restService;

    @Inject
    MyPrinter myPrinter;

    @Inject
    MainService mainService;

    @Before
    public void setUp() {
        TestComponent component = DaggerTestComponent.builder()
                .myModule(new TestModule()).build();
        component.inject(this);
    }

    @Test
    public void testDoSomething() {
        when(restService.getSomething()).thenReturn("abc");

        mainService.doSomething();

        InOrder inOrder = Mockito.inOrder(myPrinter);
        inOrder.verify(myPrinter).print("ABC");
    }
}