package Chapter6.homework;
import java.util.Scanner;

public class hw6_9 {
    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);
        while(true) {
            System.out.print("철수[가위(1), 바위(2), 보(3), 끝내기(4)]>>");
            int number = sc.nextInt();
            int com = (int)(Math.random()*4+1);
            if(number == 4)
                break;
            if(number == 1) {
                if(com==1) {
                    System.out.println("철수(가위) : 컴퓨터(가위)");
                    System.out.println("무승부입니다.");
                    continue;
                }
                else if(com==2) {
                    System.out.println("철수(가위) : 컴퓨터(바위)");
                    System.out.println("컴퓨터가 이겼습니다.");
                    continue;
                }
                else {
                    System.out.println("철수(가위) : 컴퓨터(보)");
                    System.out.println("철수가 이겼습니다.");
                    continue;
                }
            }
            if(number == 2) {
                if(com==1) {
                    System.out.println("철수(바위) : 컴퓨터(가위)");
                    System.out.println("철수가 이겼습니다.");
                    continue;
                }
                else if(com==2) {
                    System.out.println("철수(바위) : 컴퓨터(바위)");
                    System.out.println("무승부입니다.");
                    continue;
                }
                else {
                    System.out.println("철수(바위) : 컴퓨터(보)");
                    System.out.println("컴퓨터가 이겼습니다.");
                    continue;
                }
            }
            if(number == 3) {
                if(com==1) {
                    System.out.println("철수(보) : 컴퓨터(가위)");
                    System.out.println("컴퓨터가 이겼습니다.");
                    continue;
                }
                else if(com==2) {
                    System.out.println("철수(보) : 컴퓨터(바위)");
                    System.out.println("철수가 이겼습니다.");
                    continue;
                }
                else {
                    System.out.println("철수(보) : 컴퓨터(보)");
                    System.out.println("무승부입니다.");
                    continue;
                }
            }
        }
    }
}
