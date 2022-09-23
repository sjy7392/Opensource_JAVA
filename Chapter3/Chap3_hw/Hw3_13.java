
public class Hw3_13 {
	
     public static void main(String[] args) {
         int x , y, n=0;
         for(int i = 1; i < 100; i++) {
             x = i % 10; y = i / 10;
             if ((x==3)||(x==6)||(x==9)) n++;
             if ((y==3)||(y==6)||(y== 9)) n++;
             if (n==2) System.out.println(i+" 박수 짝짝");
             else if(n==1) System.out.println(i+" 박수 짝");
         }
     }
 }