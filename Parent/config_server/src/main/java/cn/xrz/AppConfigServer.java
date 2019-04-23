package cn.xrz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author XRZ
 * @date 2019-04-21
 * @Description :
 */
@SpringBootApplication
@EnableEurekaClient
@EnableConfigServer //开启configServer服务器端
public class AppConfigServer {

    public static void main(String[] args) {
        SpringApplication.run(AppConfigServer.class,args);
    }

    /**
     * 在Git环境上创建配置文件命名规范
     *
     *  服务名称-环境名称.properties
     *
     *
     */
}
