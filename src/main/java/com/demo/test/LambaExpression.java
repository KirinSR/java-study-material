package com.demo.test;

import org.springframework.http.converter.json.GsonBuilderUtils;

// Only has one method iside the interface to be implemented
@FunctionalInterface
interface A {
    void show(int n);
}

@FunctionalInterface
interface B {
    int add(int a, int b);
}

public class LambaExpression {

    public static void main (String[] a) {
// Primitive impl for A interface impl
//        A obj = new A() {
//            public void show(){
//                System.out.println("in show");
//            }
//        };

// Lambda impl of the above code
        A obj = (n) -> System.out.println("in show " + n);
        obj.show(5);
    }
// Primitive impl of interface of returning type
    B obj1 = new B() {
        public int add(int a, int b) {
            return a + b;
        }
    };

// Lambda impl of functional interface
    B obj2 = (a, b) -> a + b;

    int result1 = obj1.add(10, 8);

    int result2 = obj2.add(10, 8);
}
