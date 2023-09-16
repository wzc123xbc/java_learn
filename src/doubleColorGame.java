/**
 * 模拟双色球综合案例
 * 准备工作：相关变量的定义：
 * 1.用户选择是机选还是手选
 * 2.接受用户选号（1蓝，6红）
 * 3.生成系统号码（1蓝，6红）
 * 4.比较系统号码和用户号码，记录个数
 * 5.验证是否中奖
 * 6.系统号码排序
 * 7.公布结果
 */

import java.util.Random;
import java.util.Scanner;
import java.util.Arrays;

public class doubleColorGame {
    public static void main(String[] args) {

        // 1.定义相关变量
        int[] userRedBall = new int[6]; // 用户选择的红球号码
        int[] sysRedBall = new int[6];  // 系统生成的红球号码
        int userBlueBall = 0;    // 用户生成的蓝球号码
        int sysBlueBall = 0;     // 系统生成的蓝球号码
        int redCount = 0;       // 记录用户选择正确的红球数目
        int blueCount = 0;       // 记录用户选择正确的蓝球数目
        int[] redBall = new int[33];    // 存储1-33的红球号码
        Random r = new Random();        // 随机生成数的工具


        // 2.需要随机生成6个从[1~33]之间不重复的数 (算法)
        for(int i=0;i<redBall.length;i++){
            redBall[i] = i+1;
        }

        //3.游戏开始，系统提示
        System.out.println("双色球游戏开始，good luck！");
        System.out.println("请问您是选择机选还是手选（1.机选， 2.手选）：");

        Scanner input = new Scanner(System.in);
        boolean flag = true;
        while(flag){
            int isAuto = input.nextInt();
            switch(isAuto){
                case 1:
                    // 机选：
                    computerSelection(redBall,userRedBall);  //机选红球
                    userBlueBall = r.nextInt(16)+1;    //机选蓝球
                    flag = false;
                    break;
                case 2:
                    // 手选：
                    System.out.println("请选择6个红球号码（1-33）");
                    for(int i=0;i<userRedBall.length;i++){
                        userRedBall[i] = input.nextInt();
                    }
                    System.out.println("请选择一个蓝球号码（1-16)");
                    userBlueBall = input.nextInt();
                    flag = false;
                    break;
                default:
                    System.out.println("请问您是选择机选还是手选（1.机选， 2.手选）：");
            }
        }

        //4.系统随机生成号码算法
            // 红球
        computerSelection(redBall,sysRedBall);
            // 蓝球
        sysBlueBall = r.nextInt(16)+1;

        //5.统计结果
            // 统计红球：
        for(int i=0;i<userRedBall.length;i++){
            for(int j=0;j<sysRedBall.length-redCount;j++){
                if(userRedBall[i] == sysRedBall[j]){
                    int temp = sysRedBall[j];
                    sysRedBall[j]=sysRedBall[sysRedBall.length-1-redCount];
                    sysRedBall[sysRedBall.length-1-redCount] = temp;
                    redCount++;
                }
            }
        }
            // 统计蓝球：
        if(userBlueBall==sysBlueBall)blueCount=1;

        //6.验证是否中奖
        if(blueCount==0 && redCount<=3){
            System.out.println("很遗憾，没中奖！");
        } else if(blueCount==1 && redCount<3){
            System.out.println("中了六等奖，5块钱！");
        }else if((blueCount==1 && redCount==3) || (blueCount==0 && redCount==4)){
            System.out.println("中了五等奖，10块钱！");
        }else if((blueCount==1 && redCount==4) || (blueCount==0 && redCount==5)){
            System.out.println("中了四等奖，200块钱！");
        }else if(blueCount==1 && redCount==5){
            System.out.println("中了三等奖，3000块钱！");
        }else if(blueCount==0 && redCount==6){
            System.out.println("中了二等奖，150万块钱！");
        }else if(blueCount==1 && redCount==6){
            System.out.println("中了一等奖，500万块钱！");
        }else{
            System.out.println("系统有误，中奖无效！");
        }

        //7.公布本期中奖号码
        System.out.println("本期中奖红球号码为： ");
        sort(sysRedBall);
        System.out.println(Arrays.toString(sysRedBall));
        System.out.println("本期中奖蓝球号码为 "+sysBlueBall);

        //8.公布用户号码
        System.out.println("选择的红球号码为： ");
        sort(userRedBall);
        System.out.println(Arrays.toString(userRedBall));
        System.out.println("选择的蓝球号码为 "+userBlueBall);

        System.out.println("买双色球造福你我他！谢谢参与");
    }

    // 辅助函数1：排序用户号码和系统号码 （冒泡排序）
        public static void sort(int[] bail){
            for(int i=0;i<bail.length;i++){
                for(int j=0;j<bail.length-1-i;j++){
                    if(bail[j]>bail[j+1]){
                        bail[j] = bail[j] + bail[j+1];
                        bail[j+1] = bail[j]-bail[j+1];
                        bail[j]=bail[j]-bail[j+1];
                    }
                }
            }
        }

    // 辅助函数2：用于在指定数列中，随机生成多个不重复的数的算法
    public static void computerSelection(int[] redBall,int[] userRedBall){
        Random r = new Random();    // 随机生成数
        int index = -1;
        for(int i=0;i< userRedBall.length;i++){
            index = r.nextInt(redBall.length-i);            // 随机生成
            userRedBall[i] = redBall[index];
            int temp = redBall[index];
            redBall[index] = redBall[redBall.length-1-i];
            redBall[redBall.length-1-i] = temp;
        }
    }
}
