package CollectionDemo;

import java.util.Deque;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Stack;

/**
 * Queue接口： 队列
 *  使用linkedlist实现
 *  请求队列，消息队列，任务

 *  Deque接口： 双端队列
 *  Stack接口： 栈
 */
public class QueueDequeDemo {
    private static void stack(){
        Stack<String> s = new Stack<>();
        // 压栈
        s.push("小花");
        s.push("小鸡");
        s.push("小虎");

        System.out.println(s.peek());
        System.out.println(s.pop());
        System.out.println(s.peek());
        System.out.println(s.pop());
        System.out.println(s.peek());
        System.out.println(s.pop());
    }
    private static void deque(){
        Deque<String> deque = new LinkedList<>();
        deque.add("小花");
        deque.add("小黑");
        deque.add("小华");
        deque.add("小狗");
        deque.add("小🐖");
        System.out.println(deque.getFirst());
        System.out.println(deque.getLast());
    }


   private static void queue() {
       Queue<String> queue = new LinkedList<>();
       queue.add("小花");
       queue.add("小黑");
       queue.add("小华");
       queue.add("小狗");
       queue.add("小🐖");
       // peek取头不删除，poll取头且删除
       System.out.println(queue.size());
       System.out.println(queue.peek());
       System.out.println(queue.size());
       System.out.println(queue.poll());
       System.out.println(queue.size());
   }
    public static void main(String[] args) {
        queue();
        deque();
    }
}
