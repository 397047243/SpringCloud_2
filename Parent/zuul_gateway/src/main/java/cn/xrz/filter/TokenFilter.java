package cn.xrz.filter;

import com.netflix.discovery.util.StringUtil;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @author XRZ
 * @date 2019-04-21
 * @Description : 网关过滤器
 */
//@Component
public class TokenFilter extends ZuulFilter {

    /**
     * 过滤器的类型 pre 表示在请求之前执行
     * @return
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * 过滤器执行顺序
     *      当一个请求在同一个阶段的时候存在多个过滤器的时候，多个过滤器执行顺序
     * @return
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * 表示过滤器是否生效
     * @return
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * 具体执行的业务代码
     * @return
     * @throws ZuulException
     */
    @Override
    public Object run() throws ZuulException {

        /**
         * 拦截所有服务接口，判断服务接口上是否有传递userToken参数
         */

        // 获取当前上下文
        RequestContext currentContext = RequestContext.getCurrentContext();
        // 获取Request
        HttpServletRequest request = currentContext.getRequest();
        //获取参数
        String userToken = request.getParameter("userToken");
        if(StringUtils.isEmpty(userToken)){ //如果为空
            currentContext.setSendZuulResponse(false); //拦截
            currentContext.setResponseBody("userToken is null");
            currentContext.setResponseStatusCode(401);
            System.err.println("====================>"+userToken);
        }
        //正常执行。 。。
        return null;
    }
}
