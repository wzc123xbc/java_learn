package Decorator模式;

/** 具体1的装饰者类（糖）
 *
 */
public class EggDecorator extends Decorator{
    public EggDecorator(Drink drink){
        super(drink);
    }
    public float cost(){
        return super.cost()+1.5f;
    }
    public String description(){
        return super.description()+"+鸡蛋";
    }
}
