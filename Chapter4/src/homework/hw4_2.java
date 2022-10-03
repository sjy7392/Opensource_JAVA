package homework;
import java.util.Scanner;

class Grade {
    int math;
    int science;
    int english;
    int average;

    public Grade(int m, int s, int e) {
        math = m;
        science = s;
        english = e;
    }

    public int getAverage() {
        average = (math + science + english) / 3;
        return average;
    }
}

public class hw4_2{

    public static void main(String [] args){
        Scanner sc=new Scanner(System.in);

        System.out.print("수학, 과학, 영어 순으로 3개의 점수 입력>>");
        int math=sc.nextInt();
        int science=sc.nextInt();
        int english=sc.nextInt();
        Grade me=new Grade(math, science, english);
        System.out.println("평균은" + me.getAverage());

        sc.close();
    }

}
