package com.iweb.test1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.lang.reflect.Constructor;

/**
 * @author Liu Xiong
 * @date 25/11/2023 上午9:16
 */
public class Test {
    // 设计一个方法
    // 根据配置文件中所记录的信息 创建一个Person接口的子类对象
    // 并且使用这个对象调用eat方法 在代码不改变的情况下 修改配置文件
    // 达到调用不同eat方法的目的
    public static Person getInstance() {
        File personConfig = new File("d1125_java15\\src\\main\\java\\com\\iweb\\test1\\person.config");
        try (FileReader fr = new FileReader(personConfig);
             BufferedReader br = new BufferedReader(fr);
        ) {
            String line;
            if ((line = br.readLine()) != null) {
                Class c = Class.forName(line.substring(line.indexOf('=') + 1));
                Constructor cc = c.getConstructor();
                Person p = (Person) cc.newInstance();
                return p;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) throws Exception {
        Person p = getInstance();
        p.eat();
    }
}
