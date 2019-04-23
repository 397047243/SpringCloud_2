package cn.xrz.controller;

import jdk.nashorn.internal.ir.annotations.Reference;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author XRZ
 * @date 2019-04-21
 * @Description :
 */
@RestController
@RefreshScope //在需要刷新的baen上添加该注解
public class testController {

    @Value("${configServerValue}") //在配置服务端中获取配置信息
    private String configServerValue;

    @GetMapping("/testprd")
    public String test(){
        return configServerValue;
    }

    /**
     * 手动刷新：（推荐）
     *
     *  可在 配置客户端 中添加Actuator（监控中心）依赖
     *      在bootstrap.yml文件中开放所有端点
     *      发送Post请求至 http://192.168.81.1:8020/actuator/refresh  实现手动刷新
     *
     *      GitHub中修改了配置文件后，通知 配置客户端 执行对应的刷新请求，达到刷新配置文件的目的
     */

}
