package cn.xrz.service.impl;

import cn.xrz.base.BaseApiService;
import cn.xrz.base.ResponseBase;
import cn.xrz.entity.Student;
import cn.xrz.service.IMemberService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author XRZ
 * @date 2019-04-19
 * @Description :
 */
@RestController
public class MemberServiceImpl extends BaseApiService implements IMemberService {

    @Override
    @RequestMapping("/getMember")
    public Student getMember(@RequestParam("name") String name) {
        Student student = new Student();
        student.setName(name);
        student.setAge(21);
        return student;
    }

    @Override
    @RequestMapping("/getStudentInfo")
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
