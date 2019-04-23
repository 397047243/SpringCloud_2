package cn.xrz;

import com.spring4all.swagger.EnableSwagger2Doc;
import org.aspectj.weaver.ast.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;

import java.util.ArrayList;
import java.util.List;

/**
 * @author XRZ
 * @date 2019-04-21
 * @Description :
 */
@SpringBootApplication
@EnableEurekaClient
@EnableZuulProxy //开启网关代理
@EnableSwagger2Doc
public class AppZuulServer {

    public static void main(String[] args) {
        SpringApplication.run(AppZuulServer.class,args);
    }

    /**
     * 使用config客户端实现 实时更新
     * @return
     */
    @RefreshScope
    @ConfigurationProperties("zuul")
    public ZuulProperties zuulProperties(){
        return new ZuulProperties();
    }

    /**
     * 通过网关集成所有服务的swagger : 配置文档来源
     */
    @Component
    @Primary
    class DocumentationConfig implements SwaggerResourcesProvider{

        @Override
        public List<SwaggerResource> get() {
            List<SwaggerResource> resources = new ArrayList<>();
            resources.add(swaggerResource("api-xrz-member","/api-member/v2/api-docs","3.0"));
            resources.add(swaggerResource("api-xrz-order","/api-order/v2/api-docs","3.0"));
            return resources;
        }

        /**
         *  Swagger来源
         * @param name     来源名字
         * @param location 来源地址
         * @param versio   版本
         * @return
         */
        private SwaggerResource swaggerResource(String name,String location,String versio){
            SwaggerResource swaggerResource = new SwaggerResource();
            swaggerResource.setName(name);
            swaggerResource.setLocation(location);
            swaggerResource.setSwaggerVersion(versio);
            return swaggerResource;
        }
    }
}
