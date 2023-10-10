package Decorator模式;

/** 装饰者模式
 *  装饰者模式是结构性设计模式之一，其在不必改变类文件及不使用继承的情况下，动态地扩展一个对象的功能。它通过创建一个包装对象（即装饰）来包裹真实的对象。
 *  装饰者模式中有如下角色：
 * 1.Component：可以是接口或者是抽象类，被装饰的最原始的对象。
 * 2.ConcreteComponent：组件具体实现类。Component的具体实现，被装饰的具体对象【即包含原有功能的对象】。
 * 3.Decorator：抽象装饰者，新增装饰类，用来扩展原有Component类的功能，对于Component来说无须知道Decorator的存在，所以在它的属性中必然有一个private变量指向Component抽象组件。
 * 4.ConcreteDecorator：装饰者的具体实现类。

 * 优点：
 * 1.通过组合而非继承的方式，动态地扩展一个对象的功能，在运行时可以选择不同的装饰器从而实现不同的功能。
 * 2.有效的避免了使用继承的方式扩展对象功能而带来的灵活性差、子类无限制扩张的问题。
 * 3.具体组件类与具体装饰类可以独立变化，用户可以根据需要新增具体组件类跟装饰类，在使用时在对其进行组合，原有代码无须改变，符合"开闭原则"。

 *缺点：
 * 1.因为所有对象均继承于Component，所以如果Component内部结构发生改变，则不可避免地影响到所有子类（装饰者于被装饰者）。如果基类改变，则势必影响对象的内部。
 * 2.装饰模式比继承更容易出错，拍错也比较困难。对于多次装饰的对象，调试时寻找错误可能需要逐级排查，较为繁琐。所以一般只在必要的时候使用装饰者模式。
 * 3.装饰层数不能过多，否则会影响效率。
 */
public class Main {
    public static void main(String[] args) {
        Drink drink = new Milk();
        SugarDecorator sugar = new SugarDecorator(drink);
        EggDecorator egg = new EggDecorator(sugar);
        BlackBeanDecorator blackBean = new BlackBeanDecorator(egg);
        System.out.println("你点的牛奶是："+blackBean.description());
        System.out.println("一共花了"+blackBean.cost()+"元");
    }
}
