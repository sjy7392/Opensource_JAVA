package homework;
import java.util.Scanner;
import java.util.InputMismatchException;

//참가자의 이름 필드와 사용자로부터 단어를 입력받는 getWordFromUser()
//끝말잇기 성공여부와 게임을 계속하는지를 판별하는 checkSuccess()
class Player{
    String name;
    String word;

    void getWordFromUser(){
        Scanner sc=new Scanner(System.in);
        System.out.print(name+">>");
        word=sc.next();
    }

    boolean checkSuccess(String word){
        int lastIndex=word.length()-1;
        char lastChar = word.charAt(lastIndex);
        char firstChar=word.charAt(0);

        if(lastChar==firstChar)
            return true;
        else
            return false;
    }

}

public class WordGameApp {
    public static void run(){
        Scanner sc=new Scanner(System.in);
        System.out.print("게임에 참가하는 인원은 몇명입니까 >>");
        int personNum=sc.nextInt();

        Player[] player = new Player[personNum]; //?

        for(int i=0; i<personNum; i++){
            System.out.print("참가자의 이름을 입력하세요>>");
            String name=sc.next();
            player[i]=new Player(); //?
            player[i].name=name;
        }
        
        System.out.println("시작하는 단어는 아버지입니다.");

        String Word="아버지";
        int i=0;

        while(true){
            player[i].getWordFromUser();

            if(!(player[i].checkSuccess(Word))){
                System.out.println(player[i].name+"이(가) 졌습니다.");
                break;
            }
            Word=player[i].word;

            i++;
            if(i==personNum)
                i=0;
        }
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("끝말잇기 게임을 시작합니다...");

        while(true) {
            try {
                run(); // 게임 진행

                while(true) { // 게임을 계속하는 지 판별
                    System.out.print("게임을 다시 하시겠습니까(네/아니오)>>");
                    String restart = sc.next();

                    if(restart.equals("네")) {
                        System.out.println("끝말잇기 게임을 시작합니다...");
                        break; // 안쪽 while문을 빠져나가 바깥쪽 while문 진행
                    }
                    else if(restart.equals("아니오")) {
                        System.out.println("끝말잇기 게임을 종료합니다...");
                        System.exit(0); // 시스템 종료
                    }
                    else {
                        System.out.println("잘못된 입력입니다.");
                        continue; // 안쪽 while문 진행
                    }
                }

            }
            catch(InputMismatchException e) { // 참가 인원 입력값이 숫자가 아닐 경우
                System.out.println("잘못된 입력입니다.");
                sc.nextLine(); // 입력값 clear
                continue; // 바깥쪽 while문 진행
            }
        }
    }
}