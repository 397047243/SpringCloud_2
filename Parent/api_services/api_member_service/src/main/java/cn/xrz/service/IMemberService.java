package cn.xrz.service;

import cn.xrz.base.ResponseBase;
import cn.xrz.entity.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author XRZ
 * @date 2019-04-19
 * @Description :
 */
public interface IMemberService {

    @GetMapping("/getMember")
    public Student getMember(@RequestParam("name") String name);

    @GetMapping("/getStudentInfo")
    public ResponseBase getStudentInfo();
}
