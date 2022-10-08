package Chapter5.homework;
import java.util.Scanner;

abstract class Converter {
    protected double won;
    abstract public double convert(double dollar);

    public void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("원을 달러로 바꿉니다.");
        System.out.print("원을 입력하세요>> ");
        double in = scanner.nextDouble();
        double out = convert(in);
        System.out.println("변환 결과: " + out + "달러입니다");
        scanner.close();
    }
}

class Won2Dollar extends Converter {
    public Won2Dollar(double won) {
        this.won = won;
    }
    public double convert(double dollar) {
        return dollar/won;
    }
}

public class hw5_3 {
    public static void main(String args[]) {
        Won2Dollar toDollar = new Won2Dollar(1200);
        toDollar.run();
    }
}
