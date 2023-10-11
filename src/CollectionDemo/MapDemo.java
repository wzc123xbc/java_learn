package CollectionDemo;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * Map接口
 * 1. 是键值对存储一组对象
 * 2. key要不能重复（唯一），value可以重复
 * 3. 具体的实现类：
 *      HashMap、TreeMap、Hashtable、LinkedHashMap

   JDK1.8Map新特性
 * 1. getOrDefault--->拿key值，拿不到就返回事前设定的默认返回值
 * 2. putIfAbsent
 * 3. remove
 * ..........
 */
public class MapDemo {
    /**
     * TreeMap
     * 1.基于二叉树的红黑树来实现
     */
    private static void treeMap(){
        Map<String,String> map = new Hashtable<>();
        map.put("one","Lily");
        map.put("tow","cong");
        map.put("three","chen");
        map.put("four","zhang");
        map.forEach((key,value)->System.out.println(key+"->"+value));
    }


    /**
     *  LinkedHashMap
     *      是HashMap的子类，由于HashMap不能保证顺序恒久不变，此类使用一个双重链表来维护顺序
     */
    private static void linkedHashMap(){
        Map<String,String> table = new Hashtable<>();
        table.put("one","Lily");
        table.put("tow","cong");
        table.put("three","chen");
        table.put("four","zhang");
        table.forEach((key,value)->System.out.println(key+"->"+value));
    }


    /**
     * Hashtable
     * 1.默认数组大小为11，默认加载因子为0.75
     * 2.基于哈希表实现（数组+链表）
     * 3.扩充方式： 原数组大小<<1(*2)+1
     * 4.线程安全的，用在多线程访问时
     */
    private static void hashtable(){
        Map<String,String> table = new Hashtable<>();
        table.put("one","Lily");
        table.put("tow","cong");
        table.put("three","chen");
        table.put("four","zhang");
        table.forEach((key,value)->System.out.println(key+"->"+value));
    }



    /**
     * hashMap
     * HashMap原理介绍
     * HashMap原理在面试中的上镜率达到90%
     * 1.基于哈希表（数组+链表+二叉树（红黑树））
     * 2.默认加载因子为0.75，默认初始容量为16（利用率是0.75，超过了就扩充空间！）--->减少冲突概率
     * 3.把对象存储到哈希表中的方法：put方法
     * 4.二叉树是用来调整链表长度的 ，将链表变成TreeNode
     *   把key对象通过hash（）方法技术按hash值，然后用这个hash值对数组长度取余数（默认16），来决定该KEY对象在数组
     存储中的位置。当这个位置有多个对象时，以链表结构存储。在JDK1.8后，当链表长度大于8时，将链表转换成为红黑树结构存储
     *   这样的目的是为了提高取值效率，无需遍历，直接通过KEY值确定其位置

     * 5.HashMap扩充原理：
     * 当数组容量超过了0.75，需要进行扩充
     * 扩充算法是当前数组容量<<1(相当于乘以2)，扩大完之后，所有的值需要重新计算key值（重新计算存储位置）---->扩充次数过多，严重影响性能
     * 在开发中应该尽量避免HashMap的扩充，可以人为扩大默认数组容量

     * 6.线程不安全，适合在单线程中使用
     */
    private static void hashMap(){
        Map<Integer,String> map = new HashMap<>();
        map.put(1,"tom");
        map.put(2,"jack");
        map.put(3,"vince");
        map.put(4,"cong");
        System.out.println("size = "+map.size());
        // 从MAP中取值:通过key取value
        map.get(1);
        System.out.println("-----------------");

        // MAP的遍历一： Entry
        Set<Entry<Integer,String>> entrySet = map.entrySet();
        for (Entry e:entrySet){
            System.out.println(e.getKey()+"->"+e.getValue());
        }
        System.out.println("-----------------");

        // MAP的遍历二：借助key找value
        Set<Integer> keys = map.keySet();
        for (Integer i:keys){
            String value = map.get(i);
            System.out.println(i+"->"+value);
        }
        System.out.println("-----------------");

        // MAP的遍历三：foreach
        map.forEach((key,value)->System.out.println(key+"->"+value));


    }
    public static void main(String[] args) {
        hashMap();
    }
}
