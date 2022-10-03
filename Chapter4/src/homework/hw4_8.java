package homework;
import java.util.Scanner;

class Phone{
    String name;
    String tel;

    Phone(String name, String tel){
        this.name=name;
        this.tel=tel;
    }
    public String getName(){
        return name;
    }
    public String getTel(){
        return tel;
    }
}

public class hw4_8 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int i;

        System.out.print("인원 수>>");
        int num=sc.nextInt();
        Phone phone[]=new Phone[num];

        for(i=0; i<phone.length; i++){
            System.out.print("이름과 전화번호(이름과 번호는 빈 칸 없이 입력)>>");
            String name=sc.next();
            String tel=sc.next();
            phone[i]=new Phone(name, tel);
        }
        System.out.println("저장되었습니다.");
        while(true){
            System.out.print("검색할 이름>>");
            String name=sc.next();

            if(name.equals("그만"))
                break;

            for(i=0; i<num; i++) {
                if (name.equals(phone[i].getName())) {
                    System.out.println(name + "의 번호는" + phone[i].getTel() + "입니다.");
                    break;
                }

                if (i == num-1) {
                    System.out.println(name + "이 없습니다.");
                    break;
                }
            }
        }
        sc.close();
    }
}
