package CollectionDemo;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * 集合的输出（迭代）
 * 1. 最常用（以前） iterator
 * 2. enumeration
 * 3. ListIterator
 * 4. 最方便（现在） foreach
----------------------------------------------------
 * JDK1.8 新特性
 * 1.Consumer<T>接口       消费者接口
 * 2.Function<T,R>接口     表示接受一个参数并产生结果的函数
 * 3.Supplier<T>接口       代表结果供应商
 * 4.Predicate<T>接口      断言接口
 */
public class IteratorDemo {
    /**
     *  JDK1.8后新迭代方法：lambda表达式
     */
    private static void foreach(){
        List<String> list = new ArrayList<>();
        list.add("tom");
        list.add("jack");
        list.add("job");
        list.add("lily");
        // lambda表达式
        list.forEach((String s)->{System.out.println(s);});
        // 方式二：
        // list.forEach(System.out::println);
    }

    // 迭代方法enumeration
    private static void enumeration(){
        Vector<String> vs = new Vector<>();
        vs.add("tom");
        vs.add("jam");
        vs.add("jack");
        vs.add("ben");

        Enumeration<String> es = vs.elements();
        while (es.hasMoreElements()){
            System.out.println(es.nextElement());
        }
    }
    // foreach(1.5后才有)
    private static void foreach(Collection<String> s){
        for(String str:s){
            System.out.println(str);
        }
    }
    // iterator（1.5之前统一的处理迭代集合方式）
    private static void iterator(Collection<String> s){
        Iterator<String> iter = s.iterator();
        while(iter.hasNext()){
            System.out.println(iter.next());
        }
    }
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        String s1 = "聪仔";
        String s2 = "濠仔";
        list.add(s1);
        list.add(s2);
        foreach(list);
        iterator(list);
        enumeration();
        foreach();
    }
}
