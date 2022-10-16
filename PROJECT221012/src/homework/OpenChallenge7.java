package homework;

import java.util.*;
import java.util.Scanner;

class Word {
    private String eng; //영어 단어
    private String kor; //한글 단어
    public Word(String eng, String kor) {
        this.eng = eng;
        this.kor = kor;
    }
    public String getEng() {
        return eng;
    }
    public String getKor() {
        return kor;
    }
}

class Ex {
    int ex[] = {-1, -1, -1, -1}; // 4개의 보기 배열을 -1로 초기화 해 둠.

    public Ex(int num, int size) {
        int answerNum = (int)(Math.random()*4); // 1~4중 정답의 번호
        ex[answerNum] = num; // 정답의 인덱스 번호
        for(int i=0; i<4; i++) {
            int n = (int)(Math.random()*size);
            if(ex[i]==-1) {
                ex[i] = n;
            }
            else continue;

            for(int j=0; j<4; j++) {
                if(i!=j && ex[j]==ex[i]) {
                    ex[i] = -1;
                    i--;
                }
                else continue;
            }
        }
    }
}

public class OpenChallenge7 {
    Scanner sc = new Scanner(System.in);
    Vector<Word> v = new Vector<Word>();
    private String name;

    public OpenChallenge7(String name) { // 단어 테스트 이름과 단어 삽입.
        this.name = name;
        v.add(new Word("diary", "일기"));
        v.add(new Word("addiction", "중독"));
        v.add(new Word("software", "소프트웨어"));
        v.add(new Word("hardware", "하드웨어"));
        v.add(new Word("collection", "모음집"));
        v.add(new Word("friendship", "우정"));
        v.add(new Word("family", "가족"));
        v.add(new Word("love", "사랑"));
        v.add(new Word("phone", "핸드폰"));
        v.add(new Word("honey", "꿀"));
    }

    public void Run() {
        System.out.println("\"" + name + "\"" + "의 단어 태스트를 시작합니다. -1을 입력하면 종료합니다.");
        System.out.println("현재 " + v.size() + "의 단어가 들어있습니다.");
        Quiz();
    }

    public void Quiz() {
        while(true) {
            int num = (int)(Math.random()*v.size()); // 랜덤으로 뽑은 정답의 인덱스 번호
            String e = v.get(num).getEng(); // 랜덤으로 뽑은 영단어
            System.out.println(e + "?");

            Ex example = new Ex(num, v.size());
            for(int i=0; i<4; i++) {
                System.out.print("(" + (i+1) + ")" + v.get(example.ex[i]).getKor() + " :");
            }
            int sel = sc.nextInt(); // 사용자가 고른 번호
            if(sel == -1) { // -1 입력 시 종료
                System.out.println("\"" + name + "\"" + "을 종료합니다");
                return;
            }
            else if(example.ex[(sel-1)] == num)
                System.out.println("Excellent !!");
            else
                System.out.println("No. !!");
        }
    }

    public static void main(String[] args) {
        OpenChallenge7 wq = new OpenChallenge7("명품영어");
        wq.Run();
    }
}
