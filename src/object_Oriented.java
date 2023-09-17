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
        /* static关键字学习*/
        /*--------------------------------------------------------------*/
        // 1.声明为static的变量实质上就是全局变量----> 存放在静态方法区
        //   只申请一块内存区域 供大伙一起用！
        // 2.通常，在类中定义一个方法为static,那就是说，无需本类的对象即可调用此方法
        // 3.普通类无法使用static 内部类才可以使用static
        // 4.建议不要对象的方式调用 而是直接用方法（类名）的方式进行调用
        // 5.静态方法不能访问非静态的数据


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


