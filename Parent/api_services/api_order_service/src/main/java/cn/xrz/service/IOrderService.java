package cn.xrz.service;

import cn.xrz.base.ResponseBase;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author XRZ
 * @date 2019-04-19
 * @Description :
 */
public interface IOrderService {

    @GetMapping("/orderToMember")
    public Object orderToMember(@RequestParam("name") String name);

    @GetMapping("/orderToMemberStudentInfo")
    public ResponseBase orderToMemberStudentInfo();

    @GetMapping("/orderInfo")
    public ResponseBase orderInfo();
}
