package com.example.cpu10225.dagger2mockitojunitruleandroidtest;

import org.junit.Rule;
import org.junit.Test;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import it.cosenonjaviste.daggermock.DaggerMockRule;

import static org.mockito.Mockito.when;

/**
 * Created by cpu10225 on 22/12/2017.
 */

public class MainServiceTest {

    @Rule
    public DaggerMockRule<MyComponent> mockitoRule =
            new DaggerMockRule<>(MyComponent.class, new MyModule())
                    .set(component -> mainService = component.mainService());

    @Mock RestService restService;

    @Mock MyPrinter myPrinter;

    MainService mainService;

    @Test
    public void testDoSomething() {
        when(restService.getSomething()).thenReturn("abc");

        mainService.doSomething();

        InOrder inOrder = Mockito.inOrder(myPrinter);
        inOrder.verify(myPrinter).print("ABC");
    }
//
//    @Rule
//    public MockitoRule mockitoRule = MockitoJUnit.rule();
//
//    @Mock
//    RestService restService;
//
//    @Mock
//    MyPrinter myPrinter;
//
//    @InjectMocks
//    MainService mainService;
//
//    @Test
//    public void testDoSomething() {
//        when(restService.getSomething()).thenReturn("abc");
//
//        mainService.doSomething();
//
//        InOrder inOrder = Mockito.inOrder(myPrinter);
//        inOrder.verify(myPrinter).print("ABC");
//    }
}