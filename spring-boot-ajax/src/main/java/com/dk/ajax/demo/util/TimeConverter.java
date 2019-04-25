package com.dk.ajax.demo.util;

/**
 * @author Cheri
 * @title: TimeConverter
 * @projectName spring-boot-ajax
 * @description: TODO
 * @date 2019/4/220:36
 */
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class TimeConverter implements Converter<String, Date> {
    @Override
    public Date convert(String str) {
        return new Date(Long.valueOf(str));
    }
}