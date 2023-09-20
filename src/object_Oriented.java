import java.util.Arrays;
public class object_Oriented {
    /** 面向对象学习大纲
     * 一、面向对象上
     *  1.面向对象基本概念      7.对象的一对一关系
     *  2.类与对象定义格式      8.static关键字
     *  3.对象与内存分析        9.main方法分析
     *  4.封装性、构造方法      10.代码块
     *  5.this关键字          11.单例设计模式
     *  6.值传递和地址传递      12.对象数组与管理
     *  ------------------------------------------
     *  二、面向对象下
     *  1. 继承的基本概念      11.instanceof关键字
     *  2.继承的限制          12.抽象类应用-模板方式模式
     *  3.子类的实例化过程     13.接口应用-策略模式
     *  4.方法的重写          14.Object类
     *  5.super关键字        15.简单工厂模式
     *  6.继承的应用实例       16.静态代理模式
     *  7.final关键字        17.适配器模式
     *  8.抽象类             18.内部类
     *  9.接口               19.数据结构之链表
     *  10.多态性            20.基本数据类型包装类
     *  21.包与访问修饰符
    */
    public static void main(String[] args) {

        /*--------------------------------------------------------------*/
        /* 面向对象(上)学习代码*/
        /*--------------------------------------------------------------*/
        // 对象的定义： 类名称 对象名称 = new 类名称（）
        Horse h = new Horse();     // 声明一个类的变量
        h.name = "次兔马";
        h.age = 350;
        h.run();
        h.eat();
        // 匿名对象:用完一次后就会被释放
        new Horse().eat();
        /*--------------------------------------------------------------*/
        /* 构造方法学习代码*/
        /*--------------------------------------------------------------*/
        Dog dog1 = new Dog();                       // 调用构造方法1
        Dog dog2 = new Dog("wangwang",5); // 调用构造方法2
        /*--------------------------------------------------------------*/
        /*this关键字学习*/
        /*--------------------------------------------------------------*/
        // 1.调用类中的属性
        // 2.调用类中的方法或构造方法（在方法中调用其他方法 this可以省略）
        // 3.表示当前对象（在方法调用过程中，谁调用的方法谁就是当前对象，this.name）
        /*--------------------------------------------------------------*/
        /*对象的一对一关系学习*/
        /*--------------------------------------------------------------*/
            Hero hero = new Hero("刘备",300);
            Weapon weapon = new Weapon("双股剑",3);

            // 把两个对象关联起来
            hero.setWeapon(weapon);
            weapon.setHero(hero);

            // 通过英雄来获取他的信息
            String hero_name = hero.getName();
            int hero_age = hero.getAge();
            Weapon hero_weapon = hero.getWeapon();
            System.out.print("在下"+hero_name+", 今年"+hero_age+"岁，我的武器是：");
            System.out.println(hero_weapon.getName()+"，排名："+hero_weapon.getGrade());
        /*--------------------------------------------------------------*/
        /* static关键字学习 */
        /*--------------------------------------------------------------*/
        // 1.声明为static的变量实质上就是全局变量----> 存放在静态方法区
        //   只申请一块内存区域 供大伙一起用！
        // 2.通常，在类中定义一个方法为static,那就是说，无需本类的对象即可调用此方法
        // 3.普通类无法使用static 内部类才可以使用static
        // 4.建议不要对象的方式调用 而是直接用方法（类名）的方式进行调用
        // 5.静态方法不能访问非静态的数据
        /*--------------------------------------------------------------*/
        /* 代码块的学习 */
        /*--------------------------------------------------------------*/
        // 1.普通代码块：  在方法里面写的代码块
        // 2.构造快：     在类中定义的代码块，在创建对象被调用时，优先于构造方法执行
        // 3.静态代码块：  在类中使用static声明的代码块称为静态代码块，只会执行一次，优于构造块
        //  项目开发中，通常会使用静态代码块来初始化只调用一次的数据
        // 小结：重点会使用 静态代码块、普通代码块、同步代码块、构造代码块
        /*--------------------------------------------------------------*/
        /* 单例设计模式学习 */
        /*--------------------------------------------------------------*/
        // 保证一个类仅有一个实例，并提供一个访问它的全局访问点
        // 1.构造方法的私有化
        // 2.声明一个本类对象
        // 3.给外部提供一个静态方法获取对象实例
        // 两种实现方式: 饿汉式、懒汉式
        // 饿汉式单例设计模式：在类被加载后，对象被创建，到程序结束后释放
        // 懒汉式单例设计模式：在第一次调用get方法时，对象被创建，到程序结束后释放
        // 为什么要使用单例设计模式？
            // 1.在设计一些工具类的时候使用（通常工具类只有功能方法 没有属性）
            // 2.工具类可能会被频繁调用
            // 目的是为了节省重复创建对象所带来的内存消耗，从而提高效率
        // 使用构造方法私有化 + 静态方法 来实现工具类（例如JDK 内 Math）
        // 单例的内存消耗比上述方式小 在项目开发比较好

        singleton1 s = singleton1.getInstance();
        s.print();
        /*--------------------------------------------------------------*/
        /* 对象数组与管理学习 */
        /*--------------------------------------------------------------*/
        ChickenManager cm = new ChickenManager(5);
        cm.add(new Chicken(1,"聪仔",3));
        cm.add(new Chicken(2,"濠仔",4));
        cm.add(new Chicken(3,"恒仔",5));
        cm.add(new Chicken(4,"杰仔",6));
        cm.add(new Chicken(5,"平仔",7));
        cm.add(new Chicken(6,"鑫仔",8));

        // 查找一个的
        System.out.println("---------findALL---------");
        cm.printALL();
        System.out.println("---------find---------");
        Chicken c = cm.find(5);
        c.print();
        System.out.println("-------update----------");
        cm.update(new Chicken(1,"聪聪子",20));
        cm.printALL();
        /*--------------------------------------------------------------*/


        /*--------------------------------------------------------------*/
        /* 面向对象（下）学习代码*/
        /*--------------------------------------------------------------*/
        /* 继承学习代码 */
        /*--------------------------------------------------------------*/
        HomeCat homeCat = new HomeCat();
        homeCat.print();
        /*--------------------------------------------------------------*/
        /* 继承的限制学习 */
        /*--------------------------------------------------------------*/
        // 1.JAVA只允许单继承 但允许多重继承（不能当兄弟，但是可以当爷爷）
        // 2.继承只允许继承非私有的
        // 3.构造方法不允许被继承
        /*--------------------------------------------------------------*/



    }
}

/** 面向对象（上）学习
 * 面向过程:以步骤为单位：一步一步完成某个具体事情
 * 面向对象：以对象为单位： 分为属性 和 方法俩大类
 * 对象的定义： 类名称 对象名称 = new 类名称（）
 * 对象之间的赋值，只有相同类型的才能赋值
 * 匿名对象:用完一次后就会被释放
 */
class Horse{
    // 定义属性
    String name;
    String Color;
    int age;
    // 定义方法
    public void run(){
        System.out.println("我是"+name+",我"+age+"岁了，我还日行千里");
    }
    public void eat(){
        System.out.println("我吃仙草");
    }
}

/** 封装性学习
 * 通常在一个类中 属性都是私有化的 并利用对外提供get和set方法
 * 如果属性没有分装 可以在本类之外可以直接访问属性
 * 想要在类的外部访问私有属性 必须提供公有方法来间接使用
 * 访问权限 private 私有的属性或方法 只能在本类中使用！
 * 在类中定义的为成员变量（堆内存中） 在方法中定义的为局部变量（栈内春中）
 * 局部变量和成员变量名称可以相同 但是方法会采用就近原则
 */
class seal_inside{
    // 属性的封装
    private String name;
    private int age;

    // 公有方法定义
        // 对外提供一个为name属性设置值的公共方法
    public void setName(String name){
        this.name = name;
    }

        // 对外提供一个取name属性设置值的公共方法
    public String getName(){
        return name;
    }

        // 对外提供一个为Age属性设置值的公共方法
    public void setAge(int age){
        this.age = age;
    }

        // 对外提供一个取Age属性设置值的公共方法
    public int getAge(){
        return age;
    }
}

/** 构造方法学习
 *  在类中定义 方法名称与类名称相同 无返回值类型声明
 *  构造方法可以有很多个
 *  构造方法用于初始化数据（属性）
 *  每个类都有一个默认的构造方法
 *  在构造方法中调用其他构造方法 必须使用thos关键字 同时必须再第一句使用
 *  private Dog（） 没有属性的类就私有化构造方法
 */
class Dog{
    private String name;
    private int age;
    public Dog(){
        System.out.println("构造方法执行了！");
    }
    public Dog(String name,int age){
        this.name = name;
        this.age = age;
        System.out.println("带两个参数的构造方法执行了！");
    }
}

/**
 * 对象的一对一关系学习
 * 英雄类 对应 兵器类
 * 双向一对一 和 单相一对一
 */
// 英雄类
 class Hero{
     private String name;
     private int age;
     // 添加兵器对应属性：
    private Weapon weapon;
    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }
    public Weapon getWeapon() {
        return weapon;
    }
    public Hero(){}
    public Hero(String name,int age){
        this.name = name;
        this.age = age;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getName(){
        return name;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public int getAge() {
        return age;
    }
}
// 兵器类
class Weapon{
     private String name;
     private int grade;

     // 设置英雄类属性
    private Hero hero;
    public void setHero(Hero hero) {
        this.hero = hero;
    }
    public Weapon(){}
    public Weapon(String name,int grade){
         this.name = name;
         this.grade = grade;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getName(){
         return name;
    }
    public void setGrade(int grade) {
        this.grade = grade;
    }
    public int getGrade() {
        return grade;
    }
}

/** 单例设计模式学习
 * 保证一个类仅有一个实例，并提供一个访问它的全局访问点
 * 1.构造方法的私有化
 * 2.声明一个本类对象
 * 3.给外部提供一个静态方法获取对象实例
 * 两种实现方式: 饿汉式、懒汉式
 */
// 饿汉式:占用内存的时间长，提高效率
class singleton1{
     private singleton1(){}
    private static singleton1 s = new singleton1();
     public static singleton1 getInstance(){
         return s;
     }
     public void print(){
         System.out.println("测试方法");
     }

}
// 懒汉式：占用内存的时间短，效率低（懒加载 ，延迟加载）
// 在多线程访问时会出现安全问题
class singleton2{
    private singleton2(){};
    private static singleton2 s;
    public  static singleton2 getInstance(){
        if(s == null){
            s = new singleton2();
        }
        return s;
    }
    public void print(){
        System.out.println("测试方法2");
    }
}

/**
 *  对象数组与管理学习
 *  对象数组就是数组里的每个元素都是对象
 *  示例：使用对象数组实现多个Chicken的管理
 *  包括增删改查小鸡
 *  动态数组：
 *  1.数组是一种线性数据结构
 *  2.数组不适合做删除插入等操作，适合添加、查找、遍历
 */
// 小鸡类（ 数据对象 value object（VO）【以后可能会经常写的 描述对象的一些基本信息】）
class Chicken{
    private int id;
    private String name;
    private int age;
    public Chicken(){}  // 一般情况下最好保留默认的构造方法
    public Chicken(int id,String name,int age){ // 构造方法
        this.id = id;
        this.name = name;
        this.age = age;
    }
    public void setId(int id){
        this.id = id;
    }
    public int getId(){
        return id;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
    public void setAge(int age){
        this.age = age;
    }
    public int getAge(){
        return age;
    }
    public void print(){
        System.out.println("id="+id+",name="+name+",age"+age);
    }
}
// 小鸡管理类
class ChickenManager{
    private Chicken[] cs = null;
    private  int count = 0;     // 记录当前数组的元素个数（下标）
    public ChickenManager(int size){
        if(size>0) cs = new Chicken[size];
        else cs = new Chicken[5];
    }
    public int length(){
        return cs.length;
    }
    // 添加方法
    public void add(Chicken c){
        if(count>=cs.length){   // 表示数组已满 需要扩充
            // 算法1：扩充原来数组大小的一半左右 cs.length*3/2+1
            // 算法2：扩充原来数组大小的一倍 cs.length*2
            int newLen = cs.length*2;
            cs = Arrays.copyOf(cs,newLen);
        }
            cs[count++] = c;
    }
    // 删除方法
    public void delete(int id){
        for(int i=0;i<count;i++){
            if(cs[i].getId() == id){    // 找到需要删除的下标
                for(int j=i;j<count-1;j++){ // 后续元素移位
                    cs[j] = cs[j+1];
                }
                cs[count-1] = null;
                count--;    // 下标减一
                break;
            }
        }
    }
    // 更新方法
    public void update(Chicken c){
        // 修改小鸡的名字，年龄等
        Chicken temp = find(c.getId());
        if(temp != null){
            temp.setName(c.getName());
            temp.setAge(c.getAge());
        }
    }
    // 查找方法
    public Chicken find(int id){
        for(int i=0;i<count;i++){
            if(cs[i].getId() == id){
                return cs[i];
            }
        }
        return null;
    }
    // 输出方法
    public void printALL(){
        for(int i=0;i<count;i++){
            cs[i].print();
        }
    }
}

/** 继承基本概念学习：
 *  继承是从已有的类创建新类的过程
 *  1.被继承的类成为父类（超类），继承父类的方法叫做子类（派生类）
 *  2.继承可以实现代码重用
 *  3.继承是面向对象三大特征之一
 *  4.继承指一个对象直接使用另一个对象的属性和方法
 *  5.*继承一个父类 只能够继承非私有的属性和方法
 *  示例图：      动物
 *            /   |   \
 *         猫    狗    鸡  （猫、狗、鸡本身并没有什么关系）
 *                   /  \
 *                 家鸡   野鸡
 * 语法：[访问权限] class 子类名 extends 父类名{
 *     类体定义:
 * }
 *  protected（受保护的访问权限符，用于修饰属性和方法，使用其修饰的属性和方法可以被继承）
 */

// 父类
class Cat{
    protected String name;
    protected String sex;
    public void eat(){
        System.out.println("吃饭");
    }
}
// 子类
class HomeCat extends Cat{
    public void print(){
        System.out.println("我是一只家猫");
    }
}


