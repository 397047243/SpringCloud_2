package cn.xrz.appliction;

import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;

/**
 * @author XRZ
 * @date 2019-04-23
 * @Description :
 */
@Component
public class Consumer {

    @StreamListener("my_stream_channel")  //监听通道名
    public void redMsg(String msg){
        System.out.println("消费者接受my_stream_channel通道消息为："+msg);
    }

}
