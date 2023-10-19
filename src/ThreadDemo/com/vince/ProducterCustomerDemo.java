package ThreadDemo.com.vince;

/**
 * 消费者生产者问题
 */
public class ProducterCustomerDemo {
    public static void main(String[] args) {
        Food food = new Food();
        Producter p = new Producter(food);
        Customer c = new Customer(food);
        Thread t1 = new Thread(p);
        Thread t2 = new Thread(c);
    }
}
/**
 * 消费者
 */
class Customer implements Runnable{
    private Food food;
    public Customer(Food food){
        this.food = food;
    }
    public void run(){
        for(int i=0;i<20;i++){
            food.get();
        }
    }
}

/**
 * 生产者
 */
class Producter implements Runnable{
    private Food food;

    public Producter(Food food) {
        this.food = food;
    }

    public void run(){
        for(int i=0;i<20;i++){
            if(i%2==0){
                food.set("虾球","爆辣");
            }else{
                food.set("佛跳墙","大补");
            }
        }
    }
}

/**
 * 食物对象：
 *
 */
class Food{
    private String name;
    private String desc;
    private boolean flag = true;    // true表示可以生产，flase表示可以消费


    /**
     * 生产产品
     * @param name
     * @param desc
     */
    public synchronized void set(String name,String desc){
        this.setName(name);
        try{
            Thread.sleep(500);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        this.setDesc(desc);
    }

    /**
     * 消费产品
     */
    public synchronized void get(){
        try{
            Thread.sleep(500);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println(this.getName()+"->"+this.getDesc());
    }
    public Food() {
        this.name = name;
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "Food{" +
                "name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }
}