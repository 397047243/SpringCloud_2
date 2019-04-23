package cn.xrz;

import cn.xrz.stream.RedMsgInterface;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;

/**
 * @author XRZ
 * @date 2019-04-23
 * @Description :
 */
@SpringBootApplication
@EnableBinding(RedMsgInterface.class) //绑定通道
public class AppConsumer {

    public static void main(String[] args) {

        SpringApplication.run(AppConsumer.class,args);

        /**
         * 消费者队列 底层自动创建一个队列 绑定指定通道
         */
    }
}
