package com.iweb;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) throws ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        Boolean[] booleans = new Boolean[5];
        System.out.println(booleans[0]);
    }
}
