package Chapter6.homework;
import java.util.Scanner;

public class OpenChallenge6 {
    static String readString()
    {
        StringBuffer sb = new StringBuffer();
        Scanner scanner = new Scanner(System.in);
        while(true)
        {
            String line = scanner.nextLine();
            if(line.equals(";"))
                break;
            sb.append(line);
        }
        return sb.toString();
    }


    public static void main(String[] args) {

        int cnt[]= new int[26];

        String res = readString().toLowerCase();

        for(int i=0;i<res.length();i++)
        {
            if(res.charAt(i)>='a'&&res.charAt(i)<='z')
                cnt[(int)(res.charAt(i)-'a')]++;
        }

        for(int i=0;i<26;i++)
        {
            System.out.print((char)(i+'a'));
            for(int j=0;j<cnt[i];j++)
                System.out.print("-");
            System.out.println();
        }

    }

}
