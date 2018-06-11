package com.danny.seckill.framework.util;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author huyuyang@lxfintech.com
 * @Title: BeanConvertUtil
 * @Copyright: Copyright (c) 2016
 * @Description:
 * @Company: lxjr.com
 * @Created on 2018-06-11 14:56:28
 */
public class BeanConvertUtil extends org.apache.commons.beanutils.BeanUtils {

    public static <T> T convert(Object source, Class<T> targetClass) {
        return convert(source, targetClass, null);
    }

    public static <T> T convert(Object source, T target) {
        return convert(source, target, null);
    }

    public static <T> T convertIgnoreNullProperty(Object source, Class<T> targetClass) {
        return convert(source, targetClass, getNullPropertyNames(source));
    }

    public static <T> T convertIgnoreNullProperty(Object source, T target) {
        return convert(source, target, getNullPropertyNames(source));
    }

    public static <T> List<T> convert(List<?> sourceList, Class<T> targetClass) {
        return convert(sourceList, targetClass, false);
    }

    public static <T> List<T> convertIgnoreNullProperty(List<?> sourceList, Class<T> targetClass) {
        return convert(sourceList, targetClass, true);
    }

    private static <T> T convert(Object source, T target, String... ignoreProperties) {
        if (source == null || target == null) {
            return null;
        }
        try {
            BeanUtils.copyProperties(source, target, ignoreProperties);
            return target;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static <T> T convert(Object source, Class<T> targetClass, String... ignoreProperties) {
        if (source == null) {
            return null;
        }
        try {
            T target = targetClass.newInstance();
            BeanUtils.copyProperties(source, target, ignoreProperties);
            return target;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static <T> List<T> convert(List<?> sourceList, Class<T> targetClass, boolean isIgnoreProperties) {
        if (sourceList == null || sourceList.size() == 0) {
            return new ArrayList<T>(0);
        }
        List<T> list = new ArrayList<T>(sourceList.size());
        for (Object obj : sourceList) {
            String[] ignoreProperties = (String[]) null;
            if (isIgnoreProperties) {
                ignoreProperties = getNullPropertyNames(obj);
            }
            list.add(convert(obj, targetClass, ignoreProperties));
        }
        return list;
    }

    private static String[] getNullPropertyNames(Object source) {
        final BeanWrapper src = new BeanWrapperImpl(source);
        PropertyDescriptor[] pds = src.getPropertyDescriptors();

        Set<String> emptyNames = new HashSet<String>();
        for (PropertyDescriptor pd : pds) {
            Object srcValue = src.getPropertyValue(pd.getName());
            if (srcValue == null) {
                emptyNames.add(pd.getName());
            }
        }
        String[] result = new String[emptyNames.size()];
        return emptyNames.toArray(result);
    }

    public static String[] getFieldsName(Object object) {
        Field[] fields = object.getClass().getDeclaredFields();
        if (fields.length < 1) {
            return new String[0];
        }
        String[] fieldsName = new String[fields.length];
        for (int i = 0; i < fields.length; i++) {
            fieldsName[i] = fields[i].getName();
        }
        return fieldsName;
    }
}
