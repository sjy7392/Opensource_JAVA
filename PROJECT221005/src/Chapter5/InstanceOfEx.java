package Chapter5;

class Person2 { }
class Student2 extends Person2 { }
class Researcher extends Person2 { }
class Professor extends Researcher { }

public class InstanceOfEx {  //instanceof: 물려받았냐 아니냐
    static void print(Person2 p) {
        if(p instanceof Person2)
            System.out.print("Person ");
        if(p instanceof Student2)
            System.out.print("Student ");
        if(p instanceof Researcher)
            System.out.print("Researcher ");
        if(p instanceof Professor)
            System.out.print("Professor ");
        System.out.println();
    }
    public static void main(String[] args) {
        System.out.print("new Student() ->\t"); print(new Student2());  //부모 생성자부터 출력
        System.out.print("new Researcher() ->\t"); print(new Researcher());
        System.out.print("new Professor() ->\t"); print(new Professor());
    }
}