package it.cosenonjaviste.daggermock.dependency;

import dagger.Component;

@Component(modules = MyModule2.class)
public interface MyComponent2 {
    MyService2 myService2();
}
