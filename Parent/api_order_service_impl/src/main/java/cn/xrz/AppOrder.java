package cn.xrz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author XRZ
 * @date 2019-04-19
 * @Description :
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class AppOrder {

    public static void main(String[] args) {
        SpringApplication.run(AppOrder.class,args);
    }
}
