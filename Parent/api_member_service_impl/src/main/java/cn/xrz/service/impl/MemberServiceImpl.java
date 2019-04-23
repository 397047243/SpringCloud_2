package cn.xrz.service.impl;

import cn.xrz.base.BaseApiService;
import cn.xrz.base.ResponseBase;
import cn.xrz.entity.Student;
import cn.xrz.service.IMemberService;
import io.swagger.annotations.Api;
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
@Api("Mumber服务接口")
public class MemberServiceImpl extends BaseApiService implements IMemberService {

    @Value("${server.port}")
    private String port;

    @GetMapping("/")
    public String index(){
        return "this is memberServeic! Port:"+port;
    }

    @Override
    @GetMapping("/getMember")
    public Student getMember(@RequestParam("name") String name) {
        Student student = new Student();
        student.setName(name);
        student.setAge(21);
        return student;
    }

    @Override
    @GetMapping("/getStudentInfo")
    public ResponseBase getStudentInfo() {
        System.out.println("===================>member服务：start");
        try {
            Thread.sleep(1500); //member接口产生1.5秒延迟
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return setResultSuccess("order服务接口调用member服务接口成功。。。");
    }
}
