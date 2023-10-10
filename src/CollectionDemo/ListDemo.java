package CollectionDemo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

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

 * 选择依据：
 * 1.如果要排序，选择treeSet
 * 2.不要排序，也不用保证顺序，选择hashSet
 * 3.不要排序，要保证顺序，选择LinkedHashSet
 */
public class ListDemo {
    /**
     * LinkedList
     *    LinkedList的底层实现是链表，链表具有高效的插入、删除元素的特性
     * 1.实现原理：采用双向链表结构实现
     * 2.适合插入、删除操作，性能高
     */
    private static void linkedList(){
        LinkedList<String> list = new LinkedList<>();
        list.add("苍老师3");
        list.add("李老师3");
        list.add("韦老师3");
        int size = list.size();
        for(int i=0;i<size;i++){
            System.out.println(list.get(i));
        }
        System.out.println();
    }

    /**
     * Vector
     * 1.实现原理：采用动态对象数组实现，默认构造方法是创建一个大小为10的对象数组
     * 2.扩充算法：当增量为0时，扩充为原来大小的两倍，当增量大于0时，扩充为原来大小+增量
     * 3.不适合进行删除或插入操作
     * 4.为了防止数组动态扩充次数过多，建议创建Vector时，给定初始容量
     * 5.线程安全的，适合在多线程访问时使用，在单线程下效率较低

     * # 面试题：Vector与ArrayList的区别
     * 
     */
    private static void vector(){
        Vector<String> v = new Vector<>();
        v.add("苍老师2");
        v.add("李老师2");
        v.add("韦老师2");
        int size = v.size();
        for (int i=0;i<size;i++){
            System.out.println(v.get(i));
        }

    }
    /**
     * ArrayList（动态扩充数组）
     * 1.实现原理：采用对象动态数组实现，默认构造方法创建了一个空数组
     * 2.第一次添加元素，扩充容量为10，之后的扩充算法，原来数组大小+原来数组的一半
     * 3.不适合进行删除或插入操作
     * 4.为了防止数组动态扩充次数过多，建议创建ArrayLIst时，给定初始容量
     * 5.多线程不安全，适合在单线程访问时使用，效率较高
     * JDK1.2开始应用
     */
    private static void arrayList(){
        // 实际开发中，不建议存储多个不同类型的数据
        List<String> list = new ArrayList<>();
        list.add("苍老师");
        list.add("李老师");
        list.add("韦老师");
        int size = list.size();
        for(int i=0;i<size;i++){
            System.out.println(list.get(i));
        }
        // 查找
        System.out.println(list.contains("苍老师"));
        System.out.println(list.size());
        String[] array = list.toArray(new String[]{});
        for(String s:array){
            System.out.println(s);
        }
    }
    public static void main(String[] args) {
        System.out.println("------ArratList------");
        arrayList();
        System.out.println("------Vector------");
        vector();
    }
}
