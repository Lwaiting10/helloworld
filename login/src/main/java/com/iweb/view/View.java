package com.iweb.view;

import com.iweb.Util.PrintUtil;
import com.iweb.contoller.Controller;
import com.iweb.entity.User;

import java.util.Scanner;

/**
 * @author Liu Xiong
 * @date 16/11/2023 下午11:21
 */
public class View {
    private static Scanner sc = new Scanner(System.in);

    public static void mainView() {
        while (true) {
            PrintUtil.log("欢迎来到用户登录系统");
            PrintUtil.log("================");
            PrintUtil.log("请输入您想要操作的业务！");
            PrintUtil.log("0. 退出");
            PrintUtil.log("1. 登录");
            PrintUtil.log("2. 注册");
            String inputKey = sc.nextLine();
            if ("0".equals(inputKey)) {
                break;
            }
            Controller.mainController(inputKey);
        }
    }

    public static User loginView() {
        PrintUtil.log("请输入您的用户名:");
        String inputUsername = sc.nextLine();
        PrintUtil.log("请输入您的密码:");
        String inputPassword = sc.nextLine();
        User inputUser = new User();
        inputUser.setName(inputUsername);
        inputUser.setPassword(inputPassword);
        return inputUser;
    }

    public static User registerView() {
        PrintUtil.log("请输入用户名:");
        String inputUsername = sc.nextLine();
        PrintUtil.log("请输入密码:");
        String inputPassword = sc.nextLine();
        User inputUser = new User();
        inputUser.setName(inputUsername);
        inputUser.setPassword(inputPassword);
        return inputUser;
    }

    public static void userInfoView() {
        while (true) {
            PrintUtil.log("请输入您要操作的功能序号：");
            PrintUtil.log("0 - 退出");
            PrintUtil.log("1 - 修改用户名");
            PrintUtil.log("2 - 修改密码");
            String inputKey = sc.nextLine();
            if ("0".equals(inputKey)) {
                break;
            }
        }
    }
}
