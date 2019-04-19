package cn.xrz.service;

import cn.xrz.base.ResponseBase;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author XRZ
 * @date 2019-04-19
 * @Description :
 */
public interface IOrderService {

    @RequestMapping("/orderToMember")
    public Object orderToMember(@RequestParam("name") String name);

    @RequestMapping("/orderToMemberStudentInfo")
    public ResponseBase orderToMemberStudentInfo();
}
