package Decorator模式;

/** 被装饰对象的接口（基类）
 *
 */
public interface Drink {
    float cost();   //计算价钱
    String description();  // 描述
}
