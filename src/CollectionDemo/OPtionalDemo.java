package CollectionDemo;

import java.util.Optional;

/**
 * Optional类
 *  是java8引入的很有趣的特性，主要解决的问题是空指针异常
 */
public class OPtionalDemo {
    public static void main(String[] args) {
        // 创建Optional对象的方式
        Optional<String> optional = Optional.of("bin");
        // Optional<String> optional2 = Optional.ofNullable("bin");
        // Optional<String>optional3 = Optional.empty();
        // 有值返回true，否则返会false
        System.out.println(optional.isPresent());
        // 取值，否则抛出NoSuchElementException
        System.out.println(optional.get());
        // 如果实例有值则调用consumer，否则不做处理
        optional.ifPresent((value)->System.out.println(value));
        // 生成默认值
        System.out.println(optional.orElseGet(()->"defalut"));
        // 如果有值返回，否则抛出supplier接口创建异常
        try{
            optional.orElseThrow(Exception::new);
        }catch (Exception e){
            e.printStackTrace();
        }
        // map：有值，则其执行调用mapping函数得到返回值。如果返回值不为null，则创建包含mapping返回值的Optional作为map方法返回值，否则返回空Optional
        Optional<String> optional4 = optional.map((value)->value.toUpperCase());
        System.out.println(optional4.orElse("no found"));
        // flatmap:返回只能是Optional
        optional4 = optional.flatMap((value)->Optional.of(value.toUpperCase()));
        System.out.println(optional4.orElse("no found"));
    }
}
