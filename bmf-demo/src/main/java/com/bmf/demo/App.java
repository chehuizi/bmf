package com.bmf.demo;

import com.bmf.base.annotations.BusinessApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * 启动类
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.bmf.demo"})
@BusinessApplication(domainCode = 101, domainAlias = "wms")
public class App {

    public static void main(String args[]) {
        SpringApplication.run(App.class, args);
    }
}
