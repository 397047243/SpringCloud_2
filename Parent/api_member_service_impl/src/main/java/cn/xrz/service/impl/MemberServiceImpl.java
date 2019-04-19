package cn.xrz.service.impl;

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
public class MemberServiceImpl implements IMemberService {

    @Override
    @RequestMapping("/getMember")
    public Student getMember(@RequestParam("name") String name) {
        Student student = new Student();
        student.setName(name);
        student.setAge(21);
        return student;
    }
}
