package cn.xrz.fallback;

import cn.xrz.base.BaseApiService;
import cn.xrz.base.ResponseBase;
import cn.xrz.entity.Student;
import cn.xrz.feign.MemberFeign;
import org.springframework.stereotype.Component;

/**
 * @author XRZ
 * @date 2019-04-21
 * @Description : 服务降级容错类
 */
@Component
public class IMemberServiceFallback extends BaseApiService implements MemberFeign {


    @Override
    public Student getMember(String name) {
        return null;
    }

    @Override
    public ResponseBase getStudentInfo() {
        return setResultSuccess("降级类=====》服务降级：服务繁忙，请稍后再试！");
    }
}
