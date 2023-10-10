package CollectionDemo;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

/** 集合框架接口之Collection
 *  Collection接口：用于存储单个对象的集合
 *      List接口：
 * 1. 有序的collection、可以重复
 * 2. 允许多个null元素
 * 3. 具体的实现类有：ArrayList Vector LinkedList
 * 在实际开发中，如何选择list的具体实现呢？
 *    1.安全性问题
 *    2.是否平凡插入、删除操作（linkedList）
 *    3.是否存储后遍历
 --------------------------------------------------
 *      Set接口
 * 1. 不保证顺序（无序）
 * 2. 不允许重复的元素
 * 3. 具体的实现类有：HashSet、TreeSet、LinkedHashSet
 * 如果要排序，选择treeSet
 * 不要排序，也不用保证顺序，选择hashSet
 * 不要排序，要保证顺序，选择LinkedHashSet
 */
public class SetDemo {
    /**
     * LinkedHashSet
     * 哈希表加链表的实现
     * 维护着一个运行于所有条目的双重链接列表，此链接列表定义了迭代顺序，即按照将元素插入到set中的顺序进行迭代
     */
    private static void linkedHashSet(){
        LinkedHashSet<String> set = new LinkedHashSet<>();
        set.add("杰仔");
        set.add("聪仔");
        set.add("平仔");
        set.add("濠仔");
        set.add("马仔");
        for (String s:set){
            System.out.println(s);
        }
    }

    /**
     * TreeSet
     *   有序的Set，基于TreeMap二叉树数据结构（你要传入比较器告诉他怎么排！）。对象需要比较大小，通过对象比较器实现
     *   对象比较器还可以用于去除重复元素。
     */
    private static void treeSet(){
        TreeSet<String> tree = new TreeSet<>();
        tree.add("杰仔");
        tree.add("聪仔");
        tree.add("平仔");
        tree.add("濠仔");
        tree.add("马仔");
        for (String s:tree){
            System.out.println(s);
        }
        System.out.println(tree.size());
    }

    /**
     * HashSet
     * 1.实现原理：基于哈希表（HashMap）实现
     * 2，不允许重复，可以有一个null元素
     * 3.顺序不保证恒久不变
     * 4.添加元素时，把元素作为HashMap的Key存储，HashMap的value使用一个固定的object的对象
     * 5.遇到重复的，替换
     * 6.判断两个对象是否相等，先判断两个对象的hashCode是否相同（如果两个对象的hashCode相同，不一定是同一个对象，如果不同，那一定不是同一个对象），如果相同，还要进行equals判断，equals相同为同一对象
     * 7.自定义对象要认为当属性值相同时即为一个对象，则需要重写对象所在类的hashCode和equals方法
     */
    private static void hashSet(){
        Set<String> set = new HashSet<>();
        set.add("杰仔");
        set.add("聪仔");
        set.add("平仔");
        set.add("濠仔");
        set.add("马仔");
        //set.add("聪仔");  // 重复的HashMap如何处理？

        String[] names = set.toArray(new String[]{});
        for(String s:names){
            System.out.println(s);
        }
    }
    public static void main(String[] args) {
        System.out.println("------hashSet------");
        hashSet();
        System.out.println("------TreeSet------");
        treeSet();
    }
}
