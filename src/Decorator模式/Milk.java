package Decorator模式;

/** 具体的被装饰者类（牛奶）
 *
 */
public class Milk implements Drink{
    public float cost(){
        return 10f;
    }

    public String description(){
        return "纯牛奶";
    }
}
