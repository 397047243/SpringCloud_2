package cn.xrz.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author XRZ
 * @date 2019-04-21
 * @Description :
 */
@SpringBootApplication
@EnableEurekaClient
public class AppConfigClient {

    public static void main(String[] args) {
        SpringApplication.run(AppConfigClient.class,args);
    }
}
