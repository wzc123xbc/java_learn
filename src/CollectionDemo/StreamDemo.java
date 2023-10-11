package CollectionDemo;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Stream接口：
 * Stream接口提供了强大的集合处理功能，相比较于iterator迭代器一个一个处理元素，要好用多了
 * 不是存储数据结构，数据源可以是一个集合，为了函数式编程1创造
 * 惰式执行，数据只能被消费一次

 * 两种类型的操作方法：
 * 1.中间操作（生成一个Stream）
 * 2.结束操作（执行计算操作）
 */
public class StreamDemo {
    public static void main(String[] args) {
        // foreach方法 ----> 结束操作
        Stream<String> stream = Stream.of("good","good","study","day","day","up");
        //stream.forEach((str)->System.out.println(str));

        // filer方法（过滤）---->中间操作
        // 中间操作惰执行 要写多一个结束操作
        // 筛选了长度大于3的字符串
        //stream.filter((s)->s.length()>3).forEach(System.out::println);

        // distinct方法（去重）
        //stream.distinct().forEach(s->System.out.println(s));

        //map方法
            // 返回全大写
        //stream.map(s->s.toUpperCase()).forEach(s->System.out.println(s));

        // reduce方法（）
            // 返回Study
        Optional<String> opt = stream.reduce((s1, s2)->s1.length()>=s2.length()?s1:s2);
        System.out.println(opt.get());

        // collect(根据流生成不同的集合)
            //
        List<String> list = stream.collect(Collectors.toList());
        list.forEach(s->System.out.println(s));

        // lambda表达式中的::到底是什么？
        // 1.引用静态方法
        // 2.引用对象的方法：
        // 3.引用构造方法

    }
}
