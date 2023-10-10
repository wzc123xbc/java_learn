package Decorator模式;

/** 装饰者的基类
 *
 */
public class Decorator implements Drink{
    private Drink drink;    // 要装饰的对象
    public Decorator(Drink drink){
        this.drink = drink;
    }
    public float cost(){
        return drink.cost();
    }
    public String description(){
        return drink.description();
    }
}
