package com.danny.seckill.framework.log.trace;

import com.danny.seckill.framework.log.logger.CommonLogger;
import com.danny.seckill.framework.log.logger.CommonLoggerFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.slf4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author huyuyang@lxfintech.com
 * @Title: LogTraceAspect
 * @Copyright: Copyright (c) 2016
 * @Description:
 * @Company: lxjr.com
 * @Created on 2018-06-09 18:08:10
 */
public class LogTraceAspect {

    private final CommonLogger commonLogger = CommonLoggerFactory.getLogger(this.getClass());

    private String requestPath = null; // 请求地址
    private String userName = ""; // 用户名
    private Map<?, ?> inputParamMap = null; // 传入参数
    private Map<String, Object> outputParamMap = null; // 存放输出结果
    private long startTimeMillis = 0; // 开始时间
    private long endTimeMillis = 0; // 结束时间
    private HttpServletRequest request = null;

    public Object logTrace(ProceedingJoinPoint joinPoint) throws Throwable {
        Object[] args = getAndResetArgs(joinPoint);
        long startTime=System.currentTimeMillis();
        Object response = joinPoint.proceed(args);
        long endTime=System.currentTimeMillis();
        //this.printRequestLog();
        return response;
    }

    private Object[] getAndResetArgs(ProceedingJoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        return args;
    }

}
