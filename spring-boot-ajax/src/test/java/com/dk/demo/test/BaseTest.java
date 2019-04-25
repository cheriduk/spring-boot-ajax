package com.dk.demo.test;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author Cheri
 * @title: BaseTest
 * @projectName spring-boot-ajax
 * @description: TODO
 * @date 2019/4/2123:36
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = com.dk.ajax.demo.AjaxApplication.class)
public abstract class BaseTest {
}
