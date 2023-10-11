package CollectionDemo;

/**
 *  对象的一对多关系！
 *  开发中，尽量避免多对多，而是用两个1对多，利用中间对象表示！
 */
public class OneToManyDemo {
    public static void main(String[] args) {
        Teacher t1 =  new Teacher("张老师",18,"女");
        Student s1 = new Student("聪仔",10);
        Student s2 = new Student("濠仔",10);
        Student s3 = new Student("杰仔",10);
        Student s4 = new Student("平仔",10);
        Student s5 = new Student("小刘",10);
        Student s6 = new Student("鑫仔",10);
        // 关联关系
        t1.getStudents().add(s1);
        t1.getStudents().add(s2);
        t1.getStudents().add(s3);
        t1.getStudents().add(s4);
        t1.getStudents().add(s5);
        t1.getStudents().add(s6);

        s1.setTeacher(t1);
        s2.setTeacher(t1);
        s3.setTeacher(t1);
        s4.setTeacher(t1);
        s5.setTeacher(t1);
        s6.setTeacher(t1);

        print(t1);

    }
    private static void print(Teacher t1){
        System.out.println(t1.getName());
        for (Student s:t1.getStudents()){
            System.out.println(s);
        }
    }
}
