import java.util.Arrays;
import java.util.function.IntFunction;

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
        System.out.println("/* 面向对象(上)学习代码*/");
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
        System.out.println("/* 构造方法学习代码*/");
        Dog dog1 = new Dog();                       // 调用构造方法1
        Dog dog2 = new Dog("wangwang", 5); // 调用构造方法2
        /*--------------------------------------------------------------*/
        /*this关键字学习*/
        /*--------------------------------------------------------------*/
        // 1.调用类中的属性
        // 2.调用类中的方法或构造方法（在方法中调用其他方法 this可以省略）
        // 3.表示当前对象（在方法调用过程中，谁调用的方法谁就是当前对象，this.name）
        /*--------------------------------------------------------------*/
        /*对象的一对一关系学习*/
        /*--------------------------------------------------------------*/
        System.out.println("/*对象的一对一关系学习*/");
        Hero hero = new Hero("刘备", 300);
        Weapon weapon = new Weapon("双股剑", 3);

        // 把两个对象关联起来
        hero.setWeapon(weapon);
        weapon.setHero(hero);

        // 通过英雄来获取他的信息
        String hero_name = hero.getName();
        int hero_age = hero.getAge();
        Weapon hero_weapon = hero.getWeapon();
        System.out.print("在下" + hero_name + ", 今年" + hero_age + "岁，我的武器是：");
        System.out.println(hero_weapon.getName() + "，排名：" + hero_weapon.getGrade());
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
        System.out.println("/* 单例设计模式学习 */");
        singleton1 s = singleton1.getInstance();
        s.print();
        /*--------------------------------------------------------------*/
        /* 对象数组与管理学习 */
        /*--------------------------------------------------------------*/
        System.out.println("/* 对象数组与管理学习 */");
        ChickenManager cm = new ChickenManager(5);
        cm.add(new Chicken(1, "聪仔", 3));
        cm.add(new Chicken(2, "濠仔", 4));
        cm.add(new Chicken(3, "恒仔", 5));
        cm.add(new Chicken(4, "杰仔", 6));
        cm.add(new Chicken(5, "平仔", 7));
        cm.add(new Chicken(6, "鑫仔", 8));

        // 查找一个的
        System.out.println("---------findALL---------");
        cm.printALL();
        System.out.println("---------find---------");
        Chicken c = cm.find(5);
        c.print();
        System.out.println("-------update----------");
        cm.update(new Chicken(1, "聪聪子", 20));
        cm.printALL();
        /*--------------------------------------------------------------*/

        /*--------------------------------------------------------------*/

        /*--------------------------------------------------------------*/
        /* 面向对象（下）学习代码*/
        /*--------------------------------------------------------------*/
        /* 继承学习代码 */
        /*--------------------------------------------------------------*/
        System.out.println("/* 继承学习代码 */");
        HomeCat homeCat = new HomeCat("大橘");
        homeCat.print();
        /*--------------------------------------------------------------*/
        /* 继承的限制学习 */
        /*--------------------------------------------------------------*/
        // 1.JAVA只允许单继承 但允许多重继承（不能当兄弟，但是可以当爷爷）
        // 2.继承只允许继承非私有的
        // 3.构造方法不允许被继承
        // 4.protected（受保护的访问权限符，用于修饰属性和方法，使用其修饰的属性和方法可以被继承）
        // 5.当父类中没有无参构造方法时，子类必须显示的调用父类的带参构造方法，使用关键字： super
        // 开发原则：高内聚 低耦合
        /*--------------------------------------------------------------*/
        /*方法的重写学习*/
        /*--------------------------------------------------------------*/
        // 所谓的重写方法 实际上就是对于某些具体的子类 其继承的方法做出修改
        // 随后在调用子类对象是，调用所继承的已修改的代码
        // 关于方法重写的一些特性
        //  1.发生在子父类之中，方法重写的两个方法返回值、方法名、参数列表必须完全一致
        //  2.子类抛出的异常不能超过父类相应方法抛出的异常（子类异常不大于父类）
        //  3.子类方法的访问级别不低于父类相应方法的访问级别
        //  4.父类方法中使用private、static、final任意修饰符修饰，则不能被子类重写
        // 为什么要有重写方法？
        // 若子类中继承过来的方法，不能满足子类特有的需求时，子类就需要重写父类中相关的方法，方法的重写也是程序扩展性的体现
        // 拓展 经典面试题
        // overloading 与 overriding 的区别
        // overloading：方法的重载，发生在同一个类中，方法名相同，参数列表不同，返回值无关
        // overriding：方法的重写，发生在子父类中，方法名相同，参数列表相同，返回值相同
        homeCat.eat();   // 重写了父类的方法！！！
        /*--------------------------------------------------------------*/
        /* super关键字学习 */
        /*--------------------------------------------------------------*/
        // super可以完成以下操作
        // 1.使用super关键字调用父类中的属性，可以从父类实例处获得信息
        // 2.可以委托父类对象帮助其完成某件事情
        // 3.super必须在子类构造方法的第一句（同this）
        /*--------------------------------------------------------------*/
        /* 继承进阶：化妆品管理练习 */
        /*--------------------------------------------------------------*/
        System.out.println("/* ------------------继承进阶：化妆品管理练习-------------------- */");
        System.out.println("---排序输出---");
        // CosmeticManager CM = new CosmeticManager();              // 父类调用printInfo
        // SortCosmeticManager CM = new SortCosmeticManager();      // sort子类方法调用printInfo
        ImportCosmeticManager CM = new ImportCosmeticManager();     // Import子类方法调用printInfo
        CM.add(new Cosmetic("香奈儿", "进口", 1000));
        CM.add(new Cosmetic("圣罗兰", "进口", 800));
        CM.add(new Cosmetic("大宝", "国产", 60));
        CM.add(new Cosmetic("万紫千红", "国产", 110));
        CM.printInfo();
        /*--------------------------------------------------------------*/
        /* final关键字的学习 */
        /*--------------------------------------------------------------*/
        // final可以完成以下操作
        // 1.修饰一个常量: 修饰属性或局部变量（最终变量）-->全大写，和define、const类似
        // 2.声明一个方法：该方法为最终方法，且只能被子类继承，但是不能被子类重写
        // 3.声明一个类： 该类转变为最终类，没有子类的类，final修饰的类无法被继承
        System.out.println("/* final关键字的学习 */");
        // public static final int NUM_MAX = 1000; 最上面定义-->全局
        /*--------------------------------------------------------------*/
        /* 抽象类的学习*/
        /*--------------------------------------------------------------*/
        // 很多具有相同特征和行为的对象可以抽象成一个类
        // 用abstract关键字声明的类为抽象类
        // 抽象类不可以被实例化 即初始化
        // 抽象类的七大规则：
        //        *  1.抽象类方法可以没有抽象方法，有抽象方法的类必须是抽象类
        //        *  2.非抽象类继承抽象类必须实现所有抽象方法
        //        *  3.抽象类可以继承抽象类，可以不实现父类抽象方法
        //        *  4.抽象类可以有方法实现和属性
        //        *  5.抽象类不能被实例化
        //        *  6.抽象类不能声明为final
        //        *  7.抽象类可以有构造方法
        System.out.println("/* 抽象类的学习*/");
        Man man = new Man();
        man.move();
        man.eat();
        Women women = new Women();
        women.move();
        women.eat();
        /*--------------------------------------------------------------*/
        /* 接口的学习 */
        /*--------------------------------------------------------------*/
        // 接口的定义：interface 接口名称{  全局常量; 抽象方法;  }
        // 接口里边一定写的是动作：吃\睡、跑等等
        // 接口使用的规则：
        //      （1）定义一个接口，使用intreface关键字
        //      （2）在一个接口中，只能定义常量、抽象方法，JDK1.8后可以定义默认的实现方法
        //      （3）接口可以继承多个接口：extends xxx,xxx
        //      （4）一个具体类实现接口使用implements关键字
        //      （5）一个类可以实现多个接口
        //      （6）抽象类实现接口可以不实现接口的方法
        //      （7）在接口中定义的方法没有声明，访问修饰符，默认为public
        //      （8）接口不能有构造方法
        //      （9）接口不能被实例化
        // 面向对象的原则：
        //      （1）对修改关闭，对扩展开放
        //      （2）面向接口编程
        System.out.println("/* 接口的学习 */");
        Girl mm = new Girl("WJZ");
        mm.sleep();
        mm.eat();
        mm.run();
        /*--------------------------------------------------------------*/
        /* 多态性学习代码 */
        /*--------------------------------------------------------------*/
        // 多态性是指对象在运行过程中的多种形态
        // 多态性的分类：
        //    （1）方法的重载与重写---> 多态性的表现
        //    （2）对象的多态性 -----> 多个子类就是父类中的多种形态
        // 多态性的功能：
        //   1.向上转型：将子类实例转为父类
        //      格式：父类 父类对象 = 子类实例; ->自动转换
        //      以基础的数据类型操作为例：int i = 'a';(因为char的容量比int小，所以可以自动完成)
        //   2.向下转型：将父类实例转为子类实例
        //      格式：子类 子类对象 = （子类）父类实例：强制转换
        //      以基础的数据类型操作为例：char c = （char）97;(因为整形大于字符，所以要强制完成)
        // 结论：
        //    * 面向 抽象/接口 编程
        //    * 抽象（粒度）面向抽象编程（面向接口编程）
        //    * 父类通常都定义为抽象类、接口
        //    * 在实际开发中尽量使用父类引用（更加利于拓展）
        //    * 记住 该方法的参数是一个抽象类或者接口，不能具体化 --> DUCK 而非 HomeDuck
        System.out.println("/* 多态性学习代码 */");
        HomeDuck hk = new HomeDuck("小鸭鸭");
        YeDuck yk = new YeDuck("大鸡鸡");
        // hk.eat();
        eat(hk);        // 与上语句等价
        // yk.eat();
        eat(yk);        // 与上语句等价
        /*--------------------------------------------------------------*/
        /* instanceof关键字学习 */
        /*--------------------------------------------------------------*/
        // 用于检查对象是否为指定类型，通常在把父类引用强制转换为子类引用时要使用，以避免发生类型转换异常
        //  例如：
        //      if(c instanceof HomeDuck){           // 判断一个对象是否是某个类型 如果是返回true 否则放回false
        //              HomeDuck dk = （HomeDuck）c;    // 大的类型转换成小的类型，强制转换
        //              dk.方法（）;
        //        }
        // 父类的设计法则
        // 1.父类通常情况下都设计为抽象类或接口，其中优先考虑接口，如接口不能满足才考虑抽象类
        // 2.一个具体的类尽可能不去继承另一个具体类，这样的好处是无需检查对象是否为父类的对象
        /*--------------------------------------------------------------*/
        /* 抽象类应用————模板方法模式（把公共部分抽象出来！）学习 */
        /*--------------------------------------------------------------*/
        // 概念：定义一个操作中的算法的骨架，而将一些可变部分的实现延迟到子类当中。
        //      模板方法模式使得子类可以不改变一个算法的结构即可重新定义该算法的某些特定的步骤
        System.out.println("/* 抽象类应用————模板方法模式（把公共部分抽象出来！）学习 */");
        UserManager um = new UserManager();
        um.action("admin","add");   // 验证通过的添加操作
        UserManager um_1 = new UserManager();
        um_1.action("wzc","add");   // 验证不通过的添加操作
        /*--------------------------------------------------------------*/
        /* 接口应用————策略模式学习 */
        /*--------------------------------------------------------------*/
        // 概念：定义了一系列的算法，将每一种算法封装起来并可以相聚轮换使用
        //      策略模式让算法独立于使用它的客户应用二独立变化
        // 理解；把可变的行为抽象出来，成为接口，定义一系列的算法。然后将组合而成的接口定义成 调用类的一个属性
        BaseService user = new UserService();
        user.setiSsave(new FileSave());
        user.add("待上传的数据");
        /*--------------------------------------------------------------*/
        /* Object类学习 */
        /*--------------------------------------------------------------*/
        // 每个类都使用Object作为超类。所有对象（包括数组）都实现这个类的方法--->所有类都是Object类的子类
        // *  一、public String toString（）方法
        // *      返回该对像的字符串表示
        // *      通常，toString方法会返回一个“以文本方式表示”此对象的字符串，结果应是一个简明且易于读懂的信息表达式，建议所有子类都重写该方法
        // *  二、public boolean equals()方法
        // *      指示其他某个对象于此对象是否“相等”
        // *      equals 比较的是地址 所以new两个无论内容是否相同，都返回false，除非人为重写equals方法
        System.out.println("/* Object类学习 */");
        Student stu = new Student(10,19,"wzc");
        System.out.println(s.toString());
        System.out.println(s);          // 等价上一句话
        Student stu2 = new Student(11,20,"wjz");

        // equals 比较的是地址 所以new两个无论内容是否相同，都返回false，除非人为重写equals方法
        boolean b = stu.equals(stu2);
        System.out.println(b);
        /*--------------------------------------------------------------*/
        /* 简单工厂模式学习----> 降低使用者与被使用者之间的依赖性 */
        /*--------------------------------------------------------------*/
        // 简单工厂模式是由一个工厂对象决定创建出哪一种产品类的实例，简单工厂模式是工厂模式家族中最简单实用的模式
        System.out.println("/* 简单工厂模式学习 */");
        // Product phone = new phone();   使用者与被使用者两者间耦合性高，产生依赖。当被使用者改变时，会影响使用者

        Product phone = ProductFactory.getProduct("phone"); // 使用工厂模式降低依赖性
        if(null!=phone) {
            phone.work();
        }
        /*--------------------------------------------------------------*/
        /* 静态代理模式学习 */
        /*--------------------------------------------------------------*/
        // 代理模式为其他对象提供了一种代理以控制对这个对象的访问
        // 说白了就是“真实对象”的代表，在访问对象时引入一定程度的间接性，因为这种间接性可以附加多种途径
        // 静态代理的三个概念：
        // 1.抽象角色：通过接口或抽象类声明真实角色实现的业务方法（就是例子中的Action接口）
        // 2.代理角色：实现抽象角色，是真实角色的代理，通过真实角色的业务逻辑方法来实现抽象方法，并可以附加自己的操作
        // 3.真实角色：实现抽象角色，定义真实角色要实现的业务逻辑 共代理角色的调用。
        System.out.println("/* 静态代理模式学习 */");

        Action userAction = new UserAction();
        // 代理
        ActionProxy proxy = new ActionProxy(userAction);
        proxy.doAction();
    }

    /**多态性：
     * 面向 抽象/接口 编程
     * 抽象（粒度）面向抽象编程（面向接口编程）
     * 父类通常都定义为抽象类、接口
     * 记住 该方法的参数是一个抽象类或者接口，不能具体化 --> DUCK 而非 HomeDuck
     */
    public static void eat(Duck c){
        System.out.println("鸭吃饭");
        c.eat();
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
 *  当父类中没有无参构造方法时，子类必须显示的调用父类的带参构造方法，使用关键字： super；
 *
 */
// 父类
class Cat{
    protected String name;
    protected String sex;
    public Cat(String name,String sex){
        this.name = name;
        this.sex = sex;
    }
    public void eat(){
        System.out.println("吃饭");
    }
}
// 子类
class HomeCat extends Cat{
    public HomeCat(String name){
        super(name,"公");
        System.out.println("我是Home cat的构造方法！");
    }
    public void print(){
        // 让父类对象帮助完成eat方法的调用
        super.eat();
        System.out.println(name+"我是一只家猫"+sex);
    }
    // 方法重写环节！
    public void eat(){
        System.out.println("我是大橘，我喜欢吃鸡肝");
    }
}

/**
 *  继承进阶：化妆品管理练习
 *  目标：实现一个化妆品商城中的化妆品管理
 *  1.定义一个化妆品类(Cosmetic) name、type、price
 *  2.定义一个化妆品管理类(CosmeticManager)
 *      (1) 实现进货功能
 *      (2) 可以输出所有化妆品的信息功能
 *  3.使用继承来实现一个可以按照单价排序输出的所有化妆品的功能
 *  4.使用继承实现一个只输出进口化妆品的功能
 */
// 可输出出进口产品方法
class ImportCosmeticManager extends CosmeticManager{
    public void printInfo(){

        // 比较两个字符串的大小是否相等，不能用==，使用 equals 方法
        for(int i=0;i<count;i++){
            if("进口".equals(cs[i].getType())){
                System.out.println(cs[i].getInfo());
            }
        }
    }
}
// sort方法
class SortCosmeticManager extends CosmeticManager{
    // 只需要重写输出方法即可
    public void printInfo(){
        Cosmetic[] temp = Arrays.copyOf(cs,count);
        // System.out.println(temp.length);
        // 排序
        Cosmetic c = null;
        for(int i=0;i<temp.length-1;i++){
            for(int j=0;j< temp.length-1-i;j++){
                if(temp[j].getPrice() > temp[j+1].getPrice()){
                    c = temp[j];
                    temp[j] = temp[j+1];
                    temp[j+1] = c;
                }
            }
        }
        for(Cosmetic x:temp){
            System.out.println(x.getInfo());
        }
    }
}
// 化妆品类
class Cosmetic{
    private String name;    //品牌
    private String type;    //类型（进口/国产）
    private int price;      // 单价
    public Cosmetic(String name,String type,int price){
        this.name = name;
        this.type = type;
        this.price = price;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
    public void setType(String type){
        this.type = type;
    }
    public String getType(){
        return type;
    }
    public void setPrice(int price){
        this.price = price;
    }
    public int getPrice(){
        return price;
    }
    public String getInfo(){
        return "name="+name+",type="+type+",price="+price;
    }
}
// 化妆品管理类
class CosmeticManager{
    protected int count = 0;
    protected Cosmetic[] cs = new Cosmetic[4];
    // 进货功能
    public void add(Cosmetic c){
        int size = cs.length;
        if(count >= size){
            int newLen = size*2;
            cs = Arrays.copyOf(cs,newLen);
        }
        cs[count++] = c;
    }
    // 输出所有商品
    public void printInfo(){
        for(int i=0;i<count;i++){
            System.out.println(cs[i].getInfo());
        }
    }
}

/** 常量类（final关键字学习）
 *  通常给常量都定义一个常量类，用来存放所有需要用到的常量
 */
// 定义常量类
 final class Constant{
    public static final int NUM_MAX = 10001;
    public static final int NUM_MIN = -110;
    public static final int NUM_COUNT = 20;
}

/**抽象类学习
 * 很多具有相同特征和行为的对象可以抽象成一个类
 * 用abstract声明的类称为抽象类
 * 抽象类的七大规则：
 *  1.抽象类方法可以没有抽象方法，有抽象方法的类必须是抽象类
 *  2.非抽象类继承抽象类必须实现所有抽象方法
 *  3.抽象类可以继承抽象类，可以不实现父类抽象方法
 *  4.抽象类可以有方法实现和属性
 *  5.抽象类不能被实例化
 *  6.抽象类不能声明为final
 *  7.抽象类可以有构造方法
 *
 */
// 定义一个抽象类
abstract class Animal{
    public abstract void move();
}
abstract class Person extends Animal{
    private String name;
    //...
    public abstract void eat();     // 抽象方法
}
// 具体类:继承抽象类的具体类必须实现所有抽象方法
class Man extends Person{
    public void move(){
        System.out.println("我是男人，我爱跑步");
    }
    public void eat(){
        System.out.println("我是男人，我爱吃肉");
    }
}
class Women extends Person{
    public void move(){
        System.out.println("我是女人，我爱跑步");
    }
    public void eat(){
        System.out.println("我是女人，我爱吃肉");
    }
}

/** 接口学习
 *  1.接口是一组行为的规范、定义，没有实现
 *  2.接口可以让程序
 *  3.接口使用的规则：
 *       （1）定义一个接口，使用intreface关键字
 *       （2）在一个接口中，只能定义常量、抽象方法，JDK1.8后可以定义默认的实现方法
 *       （3）接口可以继承多个接口：extends xxx,xxx
 *       （4）一个具体类实现接口使用implements关键字
 *       （5）一个类可以实现多个接口
 *       （6）抽象类实现接口可以不实现接口的方法
 *       （7）在接口中定义的方法没有声明，访问修饰符，默认为public
 *       （8）接口不能有构造方法
 *       （9）接口不能被实例化
 * 4.面向对象的原则：
 *       （1）对修改关闭，对扩展开放
 *       （2）面向接口编程
 */
interface IEat{
    // public abstract void eat();    //接口中只能定义抽象方法
    void eat();                      // 接口中定义的方法没有声明修饰符，默认为 public abstract;
    int NUM = 10;                   //定义常量
}
interface Run{
    void run();
}
//  接口可以多继承（注意：类只能单继承）
interface ISleep extends IEat,Run{
    void sleep();
}
// 具体类实现接口也必须实现接口的所有方法
class Girl implements ISleep{
    private String name;
    public Girl(String name){
        this.name = name;
    }
    public Girl(){}
    public void sleep(){
        System.out.println("女生爱碎觉！");
    }
    public void eat(){
        System.out.println("我是"+name+",我爱吃饭！");
    }
    public void run(){
        System.out.println("每天5公里！");
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }


}

/** 多态性学习
 *面向 抽象/接口 编程
 *抽象（粒度）面向抽象编程（面向接口编程）
 *父类通常都定义为抽象类、接口
 *记住 该方法的参数是一个抽象类或者接口，不能具体化 --> DUCK 而非 HomeDuck
 */
// 鸭类
abstract class Duck{
    private String name;
    public Duck(){}
    public Duck(String name){
        this.name = name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getName(){
        return name;
    }
    public abstract void eat();
}
// 家鸭类
class HomeDuck extends Duck{
    public HomeDuck(String name){
        super(name);
    }
    public void eat(){
        System.out.println(this.getName()+"，我爱吃蚯蚓");
    }
}
// 野鸭类
class YeDuck extends Duck{
    public YeDuck(String name){
        super(name);
    }
    public void eat(){
        System.out.println(this.getName()+"，我爱吃大米");
    }
}

/** 抽象类应用————模板方法模式（把公共部分抽象出来！）学习
 *  例子解释：
 *  execute参与了父类的使用，但是并没有在父类中定义 而是下放到了子类
 */
// 抽象类定义框架
abstract class BaseManager{
    public void action(String name,String method){
        if("admin".equals(name)){
            execute(method);
        }else{
            System.out.println("你没有操作权限，请联系管理员");
        }
    }
    public abstract void execute(String method);
}
// 具体类实现下放功能
class UserManager extends BaseManager{
    public void execute(String method){
        // 用户是否登录的验证
        // 验证成功后才可以执行以下操作
        if("add".equals(method)){
            System.out.println("执行了添加操作");
        }else if("del".equals(method)){
            System.out.println("执行了删除操作");
        }
    }
}

/** 接口应用————策略模式（面向接口编程）
 *定义了一系列的算法，将每一种算法封装起来并可以相聚轮换使用,策略模式让算法独立于使用它的客户应用二独立变化
 *把可变的行为抽象出来，成为接口，定义一系列的算法。然后将组合而成的接口定义成 调用类的一个属性
 */
// 接口:把可变的行为抽象出来，成为接口，定义一系列的算法。
interface ISave{
    public void save(String data);
}
// 策略1
class FileSave implements ISave{
    public void save(String data){
        System.out.println("正在把数据保存到文件中。。。"+data);
    }
}
// 策略2
class NetSave implements ISave{
    public void save(String data){
        System.out.println("正在把数据保存到网络中。。。"+data);
    }
}
// 写主类 用于调用封装成属性和方法的接口（内涵系列算法）
abstract class BaseService{
    private ISave iSsave;
    public void setiSsave(ISave iSsave){
        this.iSsave = iSsave;
    }
    public void add(String data){
        System.out.println("检查数据合法性。。。");
        iSsave.save(data);  // 接口调用
        System.out.println("数据保存完毕");
    }
}
// 拓展业务： 可能会有用户保存等等的需求 直接继承就好了
class UserService extends BaseService{
}

/** Object类
 *  一、public String toString（）方法
 *      返回该对像的字符串表示
 *      通常，toString方法会返回一个“以文本方式表示”此对象的字符串，结果应是一个简明且易于读懂的信息表达式，建议所有子类都重写该方法
 *  二、public boolean equals()方法
 *      指示其他某个对象于此对象是否“相等”
 *      equals 比较的是地址 所以new两个无论内容是否相同，都返回false，除非人为重写equals方法
 */
// 测试类:默认继承超类
class Student{
    private String name;
    private int age;
    private  int sid;
    public Student(){}
    public Student(int sid,int age,String name){
        this.sid = sid;
        this.age = age;
        this.name = name;
    }
    // 重写Object类的toString方法
    public String toString(){
        return "sid="+sid+",name="+name+",age="+age;
    }
    // 重写Object类的equals方法
    public boolean equals(Object obj){
        if(this==obj){      // 地址相同一定对
            return true;
        }
        if(obj instanceof Student){ // 类型相同接着判断
            Student s = (Student) obj;
            if(!this.name.equals(s.name)){
                return false;
            }
            if(this.sid!=s.sid){
                return false;
            }
            if(this.age != s.age)
                return false;
            return true;
        }
        return false;
    }
}

/** 简单工厂模式学习
 *  降低使用者与被使用者之间的依赖性
 */
interface Product{
    public void work();
}
// 手机类
class phone implements Product{
    public void work(){
        System.out.println("手机开始工作...");
    }
}
// 电脑类
class Computer implements Product{
    public void work(){
        System.out.println("电脑开始工作...");
    }
}
// 工厂类
class ProductFactory{
    public static Product getProduct(String name){
        if("phone".equals(name)) {
            return new phone();
        }else if("computer".equals(name)){
            return new Computer();
        }else{
            return null;
        }
    }
}

/** 静态代理模式学习
 *  代理模式为其他对象提供了一种代理以控制对这个对象的访问
 *  说白了就是“真实对象”的代表，在访问对象时引入一定程度的间接性，因为这种间接性可以附加多种途径
 *  结构：
 *              Action(业务接口)
 *            /              \
 *     userAction(代理)--->  proxy(业务实现的具体类)
 *  举个例子来理解：你要住房子 你和中介 你是被代理 中介是代理 你不用操心搬家问题 只用给钱入住
 *  缺点：
 *      缺点是代理对象必须提前写出，如果接口层发生了变化，代理对象的代码也要进行维护。如果能在运行时动态的写出代理对象，不但能减少一大批代理类代码
 *      也少了不断维护的烦恼，不过在运行时的效率必然会受到部分的影响。
 */
// 抽象角色：   （业务接口--执行一个动作）
interface Action{
    public void doAction();
}
// 代理对象：
class ActionProxy implements Action{
    private Action target;  // 被代理的对象
    public ActionProxy(Action target){
        this.target = target;
    }
    // 执行操作
    public void doAction(){
        long startTime = System.currentTimeMillis();
        target.doAction();  // 执行真正的业务
        long endTime = System.currentTimeMillis();
        System.out.println("共耗时："+(endTime-startTime));
    }

}
// 真实角色：（业务具体的实现类）
class UserAction implements Action{
    public void doAction(){
        System.out.println("用户开始工作...");
    }
}