package com.danny.seckill.resources.aop;

import com.danny.seckill.framework.log.trace.GlobalTraceData;
import com.danny.seckill.framework.log.trace.GlobalTraceDataHandler;
import com.danny.seckill.framework.util.IPUtils;
import com.danny.seckill.framework.util.StringUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

/**
 * @author huyuyang@lxfintech.com
 * @Title: LogInterceptor
 * @Description: SpringMVC日志拦截器
 * MVC执行顺序：preHandler -> Controller -> postHandler -> model渲染-> afterCompletion
 * @Created on 2018-06-12 15:48:48
 */
public class LogInterceptor extends AbstractInterceptor {

    /**
     * 该方法将在请求处理之前进行调用，
     * 只有该方法返回true，才会继续执行后续的Interceptor和Controller，
     * 当返回值为true 时就会继续调用下一个Interceptor的preHandle 方法，
     * 如果已经是最后一个Interceptor的时候就会是调用当前请求的Controller方法；
     *
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        GlobalTraceData globalTraceData = GlobalTraceData.newInstance();
        String userAgent = this.getUserAgent(request);
        globalTraceData.setgRequestId(StringUtil.getUUID())
                .setgBusinessId("")// TODO: 18/6/12
                .setgDeviceId(this.getDeviceId(request))
                .setgRequestSource(this.getRequestSource(userAgent))
                .setgUserAgent(userAgent)
                .setgRequestUrl(this.getRequestUrl(request))
                .setgRequestIp(this.getRemoteIp(request))
                .setgAppClientVersion("v1.0.0");
        GlobalTraceDataHandler.setGlobalTraceData(globalTraceData);
        return true;
    }

    /**
     * 该方法也是需要当前对应的Interceptor的preHandle方法的返回值为true时才会执行，
     * 该方法将在整个请求结束之后，也就是在DispatcherServlet 渲染了对应的视图之后执行。
     * 用于进行资源清理。
     *
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    /**
     * 该方法将在请求处理之后，
     * DispatcherServlet进行视图返回渲染之前进行调用，
     * 可以在这个方法中对Controller 处理之后的ModelAndView 对象进行操作。
     *
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }


    protected String getUserAgent(HttpServletRequest request) {
        return request.getHeader("User-Agent");
    }

    protected String getDeviceId(HttpServletRequest request) {
        String deviceId = request.getHeader("deviceId");
        if (StringUtils.isBlank(deviceId)) {
            deviceId = UUID.randomUUID().toString();
        }

        return deviceId;
    }

    protected String getRequestUrl(HttpServletRequest request) {
        String url = request.getRequestURI();
        String queryString = request.getQueryString();
        if (StringUtils.isNotBlank(queryString)) {
            url = url + "?" + queryString;
        }
        return url;
    }

    protected String getRequestSource(String userAgent) {
        return userAgent;
    }

    protected String getRemoteIp(HttpServletRequest request) {
        return IPUtils.getRemoteIp(request);
    }
}
