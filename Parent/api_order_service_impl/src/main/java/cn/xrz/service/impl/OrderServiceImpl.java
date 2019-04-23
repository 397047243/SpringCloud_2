package cn.xrz.service.impl;

import cn.xrz.base.BaseApiService;
import cn.xrz.base.ResponseBase;
import cn.xrz.entity.Student;
import cn.xrz.feign.MemberFeign;
import cn.xrz.service.IOrderService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author XRZ
 * @date 2019-04-19
 * @Description :
 */
@RestController
@Api("Order服务接口")
public class OrderServiceImpl extends BaseApiService implements IOrderService {

    @Autowired
    private MemberFeign memberFeign;


    @Value("${server.port}")
    private String port;

    @GetMapping("/")
    public String index(){
        return "this is orderServeic! Port:"+port;
    }


    @GetMapping("/test")
    public ResponseBase test(){
        return super.setResultSuccess(memberFeign.getMember("test"));
    }

    @Override
    @GetMapping("/orderToMember")
    public Object orderToMember(@RequestParam("name") String name) {
        return memberFeign.getMember(name);
    }

    /**
     * 没有解决服务雪崩效应的
     * @return
     */
    @Override
    @GetMapping("/orderToMemberStudentInfo")
    public ResponseBase orderToMemberStudentInfo() {
        return memberFeign.getStudentInfo();
    }

    /**
     * 解决服务雪崩效应的 (Hystrix有两种方式配置保护服务，接口、注解)
     *
     *      @HystrixCommand 默认开启线程池隔离方式，服务降级，服务熔断（默认阈值10）
     *          fallbackMethod：指定服务降级时执行的方法
     *
     *      注意：Hystrix 默认客户端调用该接口时，如果超过1秒，则会执行服务降级方法
     *
     */
    @HystrixCommand(fallbackMethod = "orderToMemberStudentInfoHystrixFallback")
    @GetMapping("/orderToMemberStudentInfoHystrix")
    public ResponseBase orderToMemberStudentInfoHystrix() {
        //验证Hystrix默认开启线程池隔离   hystrix-OrderServiceImpl-1
        System.out.println("===============================>线程池名称："+Thread.currentThread().getName());
        return memberFeign.getStudentInfo();
    }

    @Override
    @GetMapping("/orderInfo")
    public ResponseBase orderInfo() {
        //验证Hystrix默认开启线程池隔离   http-nio-8002-exec-1
        System.out.println("===============================>线程池名称："+Thread.currentThread().getName());
        return setResultSuccess("order服务调用成功！");
    }


    public ResponseBase orderToMemberStudentInfoHystrixFallback(){
        return setResultSuccess("服务降级：服务繁忙，请稍后再试！");

    }
}
