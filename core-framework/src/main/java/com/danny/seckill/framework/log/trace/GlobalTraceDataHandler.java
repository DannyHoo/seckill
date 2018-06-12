package com.danny.seckill.framework.log.trace;

import com.danny.seckill.framework.util.StringUtil;
import org.springframework.core.NamedThreadLocal;

/**
 * @author huyuyang@lxfintech.com
 * @Title: GlobalTraceDataHandler
 * @Copyright: Copyright (c) 2016
 * @Description:
 * @Company: lxjr.com
 * @Created on 2018-06-12 09:40:56
 */
public class GlobalTraceDataHandler {
    public static ThreadLocal<GlobalTraceData> globalTraceDataLocal = new NamedThreadLocal<>("globalTraceData");

    public static GlobalTraceData getGlobalTraceData() {
        GlobalTraceData globalTraceData = globalTraceDataLocal.get();
        return globalTraceData;
    }

    public static void setGlobalTraceData(GlobalTraceData globalTraceData) {
        GlobalTraceData newGlobalTraceData = GlobalTraceData.newInstance();
        if (StringUtil.isEmpty(globalTraceData.getgRequestId())) {
            globalTraceData.setgRequestId(StringUtil.getUUID());
        }
        newGlobalTraceData.setgRequestId(globalTraceData.getgRequestId())
                .setgBusinessId(globalTraceData.getgBusinessId())
                .setgDeviceId(globalTraceData.getgDeviceId())
                .setgRequestSource(globalTraceData.getgRequestSource())
                .setgUserAgent(globalTraceData.getgUserAgent())
                .setgRequestUrl(globalTraceData.getgRequestUrl())
                .setgRequestIp(globalTraceData.getgRequestIp())
                .setgAppClientVersion(globalTraceData.getgAppClientVersion());
        globalTraceDataLocal.set(newGlobalTraceData);
    }
}
