package cn.xrz;

import com.spring4all.swagger.EnableSwagger2Doc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author XRZ
 * @date 2019-04-19
 * @Description :
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@EnableHystrix //开启服务熔断
@EnableSwagger2Doc //生成swagger2doc
public class AppOrder {

    public static void main(String[] args) {
        SpringApplication.run(AppOrder.class,args);
    }
}
