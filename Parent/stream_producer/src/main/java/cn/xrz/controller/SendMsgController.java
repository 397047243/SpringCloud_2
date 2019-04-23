package cn.xrz.controller;

import cn.xrz.stream.SendMessageInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author XRZ
 * @date 2019-04-23
 * @Description :
 */
@RestController
public class SendMsgController {

    @Autowired
    private SendMessageInterface sendMessageInterface;

    /**
     * 往通道中投递消息
     * @return
     */
    @GetMapping("sendMsg")
    public String sendMsg(){
        String msg = UUID.randomUUID().toString();
        Message build = MessageBuilder.withPayload(msg.getBytes()).build();
        sendMessageInterface.sendMsg().send(build);
        return "生产者发送消息为:"+msg;
    }


}
