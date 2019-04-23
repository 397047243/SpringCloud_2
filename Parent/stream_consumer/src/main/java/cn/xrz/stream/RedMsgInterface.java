package cn.xrz.stream;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

/**
 * @author XRZ
 * @date 2019-04-23
 * @Description : 接受消息通道
 */
public interface RedMsgInterface {

    @Input("my_stream_channel") //通道名
    SubscribableChannel redMsg();
}
