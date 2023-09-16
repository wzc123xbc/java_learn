
public class object_Oriented {
    public static void main(String[] args) {

        /*--------------------------------------------------------------*/
        /* 面向对象学习代码*/
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
    }
}

/** 面向对象学习
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

