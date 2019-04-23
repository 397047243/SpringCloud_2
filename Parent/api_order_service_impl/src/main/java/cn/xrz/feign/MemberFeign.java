package cn.xrz.feign;

import cn.xrz.fallback.IMemberServiceFallback;
import cn.xrz.service.IMemberService;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author XRZ
 * @date 2019-04-19
 * @Description :
 */
@FeignClient(name = "app-xrz-member",fallback = IMemberServiceFallback.class)
public interface MemberFeign extends IMemberService {
}
