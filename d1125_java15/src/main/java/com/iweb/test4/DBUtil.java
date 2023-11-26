package com.iweb.test4;

import java.io.FileInputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

/**
 * @author Liu Xiong
 * @date 25/11/2023 上午11:18
 */
public class DBUtil {
    private static DataSource dataSource;

    static {
        try {
            // 读取配置文件
            Properties properties = new Properties();
            properties.load(new FileInputStream("d1125_java15\\src\\main\\java\\com\\iweb\\test4\\db.properties"));
            // 利用反射完成DataSource类的实例化
            Class dClass = DataSource.class;
            Constructor<DataSource> c1 = dClass.getConstructor();
            dataSource = c1.newInstance();
            // 加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            // 获取DataSource的set方法
            Method m = dClass.getMethod("setConn", Connection.class);
            // 读取配置文件的信息 获取连接对象
            Connection c = DriverManager.getConnection(
                    (String) properties.get("url"), (String) properties.get("username"), (String) properties.get("password"));
            // 完成对象绑定
            m.invoke(dataSource, c);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static DataSource getDataSource() {
        return dataSource;
    }
}
