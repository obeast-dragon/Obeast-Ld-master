package com.obeast.common.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author wxl
 * @version 1.0
 * @description: 分页数据类转换工具
 * @date 2022/7/27 11:17
 */
@Slf4j
public class ClassConvertUtils {

    public static <T> T sourceToTarget(Object source, Class<T> target){
        if (source == null) return null;

        T targetObject = null;
        try{
            targetObject = target.getDeclaredConstructor().newInstance();
            BeanUtils.copyProperties(source, targetObject);
        }catch (Exception e){
            log.error("Exception while converting source to target is error");

        }

        return targetObject;
    }
    public static <T> List<T> sourceToTarget(Collection<?> sourceList, Class<T> target) {
        if (sourceList == null) return null;

        List<T> targetList = new ArrayList<>(sourceList.size());
        try {
            for (Object source : sourceList){
                T targetObject = target.getDeclaredConstructor().newInstance();
                BeanUtils.copyProperties(source, targetObject);
                targetList.add(targetObject);
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.error("Exception while converting sourceList to target ara error");
        }
        return targetList;
    }

}
