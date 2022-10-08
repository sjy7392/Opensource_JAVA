package Chapter6.homework;
import java.util.Scanner;

public class hw6_11 {
    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print(">>");
        String str = sc.nextLine();
        StringBuffer sb = new StringBuffer(str);

        while(true) {
            System.out.print("명령: ");
            String change = sc.nextLine();
            if(change.equals("그만")) {
                System.out.println("종료합니다.");
                break;
            }
            String [] voca = change.split("!");
            if(voca.length != 2)
                System.out.println("잘못된 명령입니다!");
            if(voca[0].length() == 0 || voca[1].length() == 0) {
                System.out.println("잘못된 명령입니다!");
                continue;
            }

            int index = sb.indexOf(voca[0]);
            if(index == -1) {
                System.out.println("찾을 수 없습니다!");
                continue;
            }
            sb.replace(index, index+voca[0].length(), voca[1]);
            System.out.println(sb.toString());
        }
    }
}
