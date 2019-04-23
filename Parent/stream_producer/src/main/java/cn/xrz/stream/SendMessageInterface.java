package cn.xrz.stream;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.SubscribableChannel;

/**
 * @author XRZ
 * @date 2019-04-23
 * @Description : 发送消息通道
 */
public interface SendMessageInterface {


    @Output("my_stream_channel") //发送消息通道名
    SubscribableChannel sendMsg();
}
