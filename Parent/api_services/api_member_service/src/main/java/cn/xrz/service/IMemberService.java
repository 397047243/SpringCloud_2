package cn.xrz.service;

import cn.xrz.entity.Student;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author XRZ
 * @date 2019-04-19
 * @Description :
 */
public interface IMemberService {

    @RequestMapping("/getMember")
    public Student getMember(@RequestParam("name") String name);
}
