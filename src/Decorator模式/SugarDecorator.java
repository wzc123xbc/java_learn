package Decorator模式;

/** 具体1的装饰者类（糖）
 *
 */
public class SugarDecorator extends Decorator{
    public SugarDecorator(Drink drink){
        super(drink);
    }
    public float cost(){
        return super.cost()+1.0f;
    }
    public String description(){
        return super.description()+"+糖";
    }
}
