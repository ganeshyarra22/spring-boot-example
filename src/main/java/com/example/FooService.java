package com.example;

import org.springframework.stereotype.Service;

@Service
public class FooService
{
    public final SpringBootExampleApplication.Foo foo;

    public FooService(SpringBootExampleApplication.Foo foo) {
        this.foo = foo;
    }

   String getFooName(){
        return foo.name();
    }
}
