package com.danny.seckill.framework.log.logger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author dannyhoo
 * @Title: CommonLoggerFactory
 * @Copyright: Copyright (c) 2016
 * @Description:
 * @Company: lxjr.com
 * @Created on 2018-06-07 21:18:17
 */
public class CommonLoggerFactory {

    public static CommonLogger getLogger(String loggerName) {
        Logger logger = LoggerFactory.getLogger(loggerName);
        CommonLoggerImpl loggerImpl = new CommonLoggerImpl();
        loggerImpl.setLogger(logger);
        return loggerImpl;
    }

    public static CommonLogger getLogger(Class<?> clazz) {
        Logger logger = LoggerFactory.getLogger(clazz);
        CommonLoggerImpl loggerImpl = new CommonLoggerImpl();
        loggerImpl.setLogger(logger);
        return loggerImpl;
    }
}
