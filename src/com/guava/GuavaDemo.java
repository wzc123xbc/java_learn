package com.guava;

// import org.junit.Test;

import com.google.common.collect.Collections2;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

import java.text.SimpleDateFormat;
import java.util.List;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Set;

public class GuavaDemo {
    // @Test

    /**
     * 设置只读
     */
    public void testGuava1(){
        System.out.println("Test guava");
        // Arrays.asList("jack","tom","lily","bin");
        // guava的只读设置
        ImmutableList<String> iList = ImmutableList.of("jack","tom","lily","bin");
    }

    /**
     * 过滤器
     * 过滤开头为j的单词
     */
    public void testGuava2(){
        List<String> list = Lists.newArrayList("java","Tom","h5","javascript");
        Collection<String> result = Collections2.filter(list,(e)->e.startsWith("j"));
        result.forEach(System.out::println);
    }

    /**
     * 转换
     */
    public void testGuava3(){
        Set<Long> timeSet = Sets.newHashSet(20231011L,20231016L,20231214L);
        Collection<String> timeCollect = Collections2.transform(timeSet,(e)->new SimpleDateFormat("yyyy-MM-dd").format(e));
        timeCollect.forEach(System.out::println);

    }


}
