package cn.xrz;

import cn.xrz.stream.SendMessageInterface;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.stream.annotation.EnableBinding;

/**
 * @author XRZ
 * @date 2019-04-23
 * @Description :
 */
@SpringBootApplication
@EnableEurekaClient
@EnableBinding(SendMessageInterface.class) //绑定通道
public class AppProducer {

    public static void main(String[] args) {
        SpringApplication.run(AppProducer.class,args);
    }
}
