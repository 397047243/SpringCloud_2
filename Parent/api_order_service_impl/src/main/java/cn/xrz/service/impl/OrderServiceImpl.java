package cn.xrz.service.impl;

import cn.xrz.base.ResponseBase;
import cn.xrz.entity.Student;
import cn.xrz.feign.MemberFeign;
import cn.xrz.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author XRZ
 * @date 2019-04-19
 * @Description :
 */
@RestController
public class OrderServiceImpl implements IOrderService {

    @Autowired
    private MemberFeign memberFeign;

    @Override
    @RequestMapping("/orderToMember")
    public Object orderToMember(@RequestParam("name") String name) {
        return memberFeign.getMember(name);
    }

    @Override
    @RequestMapping("/orderToMemberStudentInfo")
    public ResponseBase orderToMemberStudentInfo() {
        return memberFeign.getStudentInfo();
    }
}
