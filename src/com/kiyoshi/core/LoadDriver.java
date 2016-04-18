package com.kiyoshi.core;

public class LoadDriver {

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();  // The newInstance() call is a work around for some
        } catch (ClassNotFoundException a) {
            System.out.println("Error: unable to load driver class!");
            System.err.println(a);
            System.exit(1);
        } catch (IllegalAccessException b) {
            System.out.println("Error: access problem while loading!");
            System.err.println(b);
            System.exit(2);
        } catch (InstantiationException c) {
            System.out.println("Error: unable to instantiate driver!");
            System.err.println(c);
            System.exit(3);
        }
    }

}
