package Decorator模式;

/** 具体1的装饰者类（糖）
 *
 */
public class BlackBeanDecorator extends Decorator{
    public BlackBeanDecorator(Drink drink){
        super(drink);
    }
    public float cost(){
        return super.cost()+2.0f;
    }
    public String description(){
        return super.description()+"+黑豆";
    }
}
