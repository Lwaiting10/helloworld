package com.iweb.test3;

/**
 * @author Liu Xiong
 * @date 25/11/2023 上午11:02
 */
public class UserServiceImpl2 implements UserService{
    @Override
    public void login() {
        System.out.println("扫掌登录");
    }

    @Override
    public void register() {
        System.out.println("扫屁股注册");
    }
}
