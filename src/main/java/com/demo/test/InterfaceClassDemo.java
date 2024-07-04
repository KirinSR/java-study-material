package com.demo.test;

// Long making loosely coupled
//class Computer {
//    public void code(){
//
//    }
//}

// Alternative abstract class impl
//abstract class Computer {
//    public abstract void code();
//}


// abstract can be directly replaced with interface and instead of extends we need to use implements
interface Computer {
    void code();
}

class Laptop implements Computer {

    public void code() {
        System.out.println("coding ...");
    }
}

class Desktop implements Computer {
    @Override
    public void code() {
        System.out.println("coding ... faster");
    }
}

class Developer {
    public void devApp(Computer comp) {
        comp.code();
    }
}

public class InterfaceClassDemo {

    public static void main (String a[]) {
        Computer lap = new Laptop();
        Computer desk = new Desktop();

        Developer sam = new Developer();
        sam.devApp(desk);
    }
}
