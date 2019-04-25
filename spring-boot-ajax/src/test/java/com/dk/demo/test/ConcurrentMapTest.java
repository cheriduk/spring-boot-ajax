package com.dk.demo.test;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * @author Cheri
 * @title: ConcurrentMapTest
 * @projectName spring-boot-ajax
 * @description: TODO
 * @date 2019/4/2021:25
 */
public class ConcurrentMapTest {

    final static ConcurrentMap<Integer,String> cmap =
            new ConcurrentHashMap<Integer,String>(3);

    public static void main(String[] args) {

        cmap.put(1,"w1");
        cmap.put(2,"w2");
        cmap.put(3,"w3");
        cmap.put(4,"w4");
        cmap.put(5,"w5");
        cmap.put(6,"w6");
        cmap.put(7,"w7");


        System.out.println(cmap.size());

    }
}
