package com.iweb.test5;

import java.lang.annotation.*;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.*;

/**
 * @author Liu Xiong
 * @date 25/11/2023 下午2:03
 */
// 可以被使用的地方
@Target({METHOD, TYPE})
// 生命周期
@Retention(RUNTIME)
// 可以被继承
@Inherited
// 可以保证自动生成java doc文档
@Documented
// @Repeatable() 1.8新增的元注解 表示同一个位置 当前自定义注解可以出现多次
public @interface JDBCConfig {
    String url();

    String username();

    String password();
}
