package com.iweb.homework;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author Liu Xiong
 * @date 14/11/2023 下午10:04
 */
public class Test1 {
    public static Scanner sc = new Scanner(System.in);
    private static Map<String, String> user = new HashMap<>();

    static {
        user.put("user1", "111111");
        user.put("user2", "222222");
        user.put("user3", "333333");
        user.put("user4", "444444");
        user.put("user5", "555555");
    }

    public static boolean login(String name, String password) {
        for (Map.Entry<String, String> entry : user.entrySet()) {
            if (entry.getKey().equals(name)) {
                return entry.getValue().equals(password);
            }
        }
        return false;
    }

    public static boolean register(String name, String password) {
        for (Map.Entry<String, String> entry : user.entrySet()) {
            if (entry.getKey().equals(name)) {
                System.out.println("该用户名已存在！");
                return false;
            }
        }
        user.put(name, password);
        return true;
    }

    public static void print() {
        for (Map.Entry<String, String> entry : user.entrySet()) {
            System.out.println("name:" + entry.getKey() + "\tpassword:" + entry.getValue());
        }
    }

    public static void loginView() {
        System.out.println("用户名:");
        String name = sc.nextLine();
        System.out.println("密码:");
        String password = sc.nextLine();
        if (login(name, password)) {
            System.out.println("登录成功！");
        } else {
            System.out.println("登录失败！");
        }
    }

    public static void registerView() {
        System.out.println("用户名:");
        String name = sc.nextLine();
        System.out.println("密码:");
        String password = sc.nextLine();
        if (register(name, password)) {
            System.out.println("注册成功！");
        } else {
            System.out.println("注册失败！");
        }
    }

    public static void main(String[] args) {
        while (true) {
            System.out.println("登录界面");
            System.out.println("=====================");
            System.out.println("1.登录");
            System.out.println("2.注册");
            String choose = sc.nextLine();
            switch (choose) {
                case "1":
                    loginView();
                    break;
                case "2":
                    registerView();
                    break;
                case "3":
                    print();
                    break;
                default:
                    System.out.println("输入有误！");
            }
        }
    }
}
