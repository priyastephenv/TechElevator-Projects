package com.techelevator.demo;

public class ThrowsDemo {

    public static void main(String[] args) {
        ThrowsDemo code = new ThrowsDemo();
        code.a();
        System.out.println("FINISHED calling a()...");
    }

    public void a() {
        System.out.println("calling a()...");
        try {
            b();
        } catch (Exception e) {
            System.out.println("!!!Caught Exception object!!!");
        }
        System.out.println("FINISHED calling b()...");
    }

    public void b() throws Exception {
        System.out.println("calling b()...");
        c();
        System.out.println("FINISHED calling c()...");
    }

    public void c() throws Exception {
        System.out.println("calling c()...");
        d();
        System.out.println("FINISHED calling d()...");
    }

    public void d() throws Exception {
        System.out.println("calling d()...");
        throw new Exception();
    }

}
