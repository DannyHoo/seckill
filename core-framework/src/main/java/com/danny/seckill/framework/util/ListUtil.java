package com.danny.seckill.framework.util;

import java.util.List;

/**
 * @author dannyhoo
 * @Title: ListUtil
 * @Description:
 * @Created on 2018-05-31 17:48:09
 */
public class ListUtil {
    /**
     * 判断是否为空
     *
     * @param list
     * @return
     */
    public static boolean isEmpty(List list) {
        if (list == null) {
            return true;
        }
        return list.isEmpty();
    }

    /**
     * 判断列表不为空
     *
     * @param list
     * @return
     */
    public static boolean isNotEmpty(List list) {
        return !isEmpty(list);
    }

    public static  <T> T getFirst(List list) {
        if (isNotEmpty(list)) {
            return (T) list.get(0);
        } else {
            return null;
        }
    }
}
