package com.iweb.contoller;

import com.iweb.Util.PrintUtil;
import com.iweb.entity.User;
import com.iweb.service.Service;
import com.iweb.view.View;

/**
 * @author Liu Xiong
 * @date 16/11/2023 下午11:21
 */
public class Controller {
    public static void mainController(String key) {
        switch (key) {
            case "1":
                User inputUser = View.loginView();
                boolean login = Service.login(inputUser);
                if (login) {
                    // 跳转到下一个视图
                    View.userInfoView();
                } else {
                    PrintUtil.log("登录用户名密码有误！请重新输入！");
                }
                break;
            case "2":
                User registerUser = View.registerView();
                if (Service.register(registerUser)) {
                    PrintUtil.log("注册成功！");
                } else {
                    PrintUtil.log("注册失败");
                    if (Service.isFull()) {
                        PrintUtil.log("当前注册已经达到上限,请联系管理员！");
                    } else {
                        PrintUtil.log("用户已存在！");
                    }
                }
                break;
            default:
                PrintUtil.log("输入有误！");
                break;
        }
    }
}
