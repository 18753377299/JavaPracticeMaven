package com.common.utils;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;

import java.util.List;

@Api(value="对对象的copy")
public class BeanCopyUtils {

    @ApiOperation(value="不能对基本类型封装类进行复制")
    public static <T> void copyPropertyList(List<T> sourceList ,List<T> targetList){
            for(T source : sourceList){
                Class<?> clazz = source.getClass();
                try {
                    T target =  (T)clazz.newInstance();
                    BeanUtils.copyProperties(source,target);
                    targetList.add(target);
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
    }



}
