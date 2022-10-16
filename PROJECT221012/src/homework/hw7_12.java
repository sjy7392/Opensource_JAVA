package homework;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Vector;

class Word2 { // 영어 단어와 한글 단어를 쌍으로 가진 하나의 단어 표현
    private String english; // 영어 단어
    private String korean; // 영어 단어에 해당하는 한글 단어
    public Word2(String english, String korean) {
        this.english = english;
        this.korean = korean;
    }
    public String getEnglish() { return english; }
    public String getKorean() { return korean; }

}
public class hw7_12 {
    Scanner sc = new Scanner(System.in);
    private String name; // 퀴즈 프로그램의 이름
    private Vector<Word2> v;

    public hw7_12(String name) {
        this.name = name;
        v = new Vector<Word2>();
        v.add(new Word2("diary", "일기"));
        v.add(new Word2("addiction", "중독"));
        v.add(new Word2("software", "소프트웨어"));
        v.add(new Word2("hardware", "하드웨어"));
        v.add(new Word2("collection", "모음집"));
        v.add(new Word2("friendship", "우정"));
        v.add(new Word2("family", "가족"));
        v.add(new Word2("love", "사랑"));
        v.add(new Word2("phone", "핸드폰"));
        v.add(new Word2("honey", "꿀"));
    }

    private int makeExample(int ex[], int answerIndex) {
        int n[] = {-1, -1, -1, -1}; // -1로 초기화
        int index;
        for(int i=0; i<n.length; i++) {
            do {
                index = (int)(Math.random()*v.size());
            } while(index == answerIndex || exists(n, index)); // 다시 시도
            n[i] = index;
        }

        for(int i=0; i<n.length; i++) ex[i] = n[i];
        return (int)(Math.random()*n.length);
    }

    private boolean exists(int n[], int index) {
        for(int i=0; i<n.length; i++) {
            if(n[i] == index)
                return true;
        }
        return false;
    }

    public void quiz() {
        System.out.println("\"" + name + "\"" + "의 단어 테스트를 시작합니다. -1을 입력하면 종료합니다.");
        System.out.println("현재 " + v.size() + "개의 단어가 들어 있습니다.");
        while(true) {
            int answerIndex = (int)(Math.random()*v.size()); // 정답
            String eng = v.get(answerIndex).getEnglish(); // 문제

            // 4개의 보기를 만들 벡터의 index 배열
            int example[] = new int [4];

            int answerLoc = makeExample(example, answerIndex); // 정답번호
            example[answerLoc] = answerIndex; // 정답 인덱스

            System.out.println(eng + "?");
            for(int i=0; i<example.length; i++)
                System.out.print("(" + (i+1) + ")" + v.get(example[i]).getKorean() + " ");

            System.out.print(":>");
            try {
                int in = sc.nextInt(); //정답 입력
                if(in == -1) {
                    break; // 프로그램 종료
                }

                in--;
                if(in == answerLoc)
                    System.out.println("Excellent !!");
                else
                    System.out.println("No. !!");
            }
            catch(InputMismatchException e) {
                sc.next();
                System.out.println("숫자를 입력하세요 !!");
            }
        }
    }
    private boolean contains(String eng) {
        for(int i=0; i<v.size(); i++) {
            if(v.get(i).getEnglish().equals(eng)) {
                return true;
            }
        }
        return false;
    }

    public void insert() {
        System.out.print("현재 " + v.size() + "개 단어가 입력되어 있습니다.");
        System.out.println("-1을 입력하면 테스트를 종료합니다.");
        while(true) {
            System.out.print("영어 한글 입력>>");
            String english = sc.next();
            if(english.equals("그만")) break;
            String capital = sc.next();

            if(contains(english)) {
                System.out.println(english + "는 이미 있습니다!");
                continue;
            }

            v.add(new Word2(english, capital));
        }
    }
    public void run() {
        System.out.println("****영어 단어 테스트 프로그램 \"명품영어\" 입니다. ****");
        while(true) {
            System.out.print("단어테스트:1, 단어 삽입:2, 종료:3>>");
            int select = sc.nextInt();
            switch(select) {
                case 1:
                    quiz(); break;
                case 2:
                    insert(); break;
                case 3:
                    sc.close();
                    System.out.println("게임을 종료합니다.");
                    return;
            }
        }
    }
    public static void main(String[] args) {
        hw7_12 quiz = new hw7_12("명품영어");
        quiz.run();
    }
}