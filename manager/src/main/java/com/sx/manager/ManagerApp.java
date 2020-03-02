package com.sx.manager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

/**
 * @author : Anui
 * @date : 2020/2/26
 * @time : 14:29
 * @Description :管理端启动类
 */
@SpringBootApplication
@EntityScan(basePackages = {"com.sx.entity"})
public class ManagerApp {
    public static void main(String[] args) {
        SpringApplication.run(ManagerApp.class);
    }
}
