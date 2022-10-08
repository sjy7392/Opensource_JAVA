package Chapter5.homework;

import java.util.Scanner;

abstract class GameObject { // 추상 클래스
    protected int distance; // 한 번 이동 거리
    protected int x, y; // 현재 위치(화면 맵 상의 위치)
    public GameObject(int startX, int startY, int distance) { // 초기 위치와 이동 거리 설정
        this.x = startX;
        this.y = startY;
        this.distance = distance;
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public boolean collide(GameObject p) { // 이 객체가 객체 p와 충돌했으면 true 리턴
        if(this.x == p.getX() && this.y == p.getY())
            return true;
        else
            return false;
    }
    protected abstract void move(); // 이동한 후의 새로운 위치로 x, y 변경
    protected abstract char getShape(); // 객체의 모양을 나타내는 문자 리턴
}

class Bear extends GameObject { // Bear
    Scanner scan = new Scanner(System.in);

    public Bear(int startX, int startY, int distance) {
        super(startX, startY, distance);
    }
    @Override
    protected void move() { // Bear 이동
        System.out.print("왼쪽(a), 위(w), 아래(s), 오른쪽(d) >> ");
        String key = scan.next(); // 사용자에게 이동 방향 받아옴

        switch(key) { // 배열 범위를 벗어나지 않도록 함
            case "a": // 왼쪽(a)
                if(super.y > 0)
                    super.y -= super.distance;
                break;
            case "w": // 위(w)
                if(super.x > 0)
                    super.x -= super.distance;
                break;
            case "s": // 아래(s)
                if(super.x < 9)
                    super.x += super.distance;
                break;
            case "d": // 오른쪽(d)
                if(super.y < 19)
                    super.y += super.distance;
                break;
        }
    }
    @Override
    protected char getShape() { // Bear 모양
        return 'B';
    }
}

class Fish extends GameObject { // Fish
    public Fish(int startX, int startY, int distance) {
        super(startX, startY, distance);
    }
    @Override
    protected void move() { // Fish 이동
        int key = (int)(Math.random()*4); // 이동 방향 랜덤

        switch(key) { // 배열 범위를 벗어나지 않도록 함
            case 0: // 왼쪽
                if(super.y > 0)
                    super.y -= super.distance;
                break;
            case 1: // 위
                if(super.x > 0)
                    super.x -= super.distance;
                break;
            case 2: // 아래
                if(super.x < 9)
                    super.x += super.distance;
                break;
            case 3: // 오른쪽
                if(super.y < 19)
                    super.y += super.distance;
                break;
        }
    }
    @Override
    public char getShape() { // Fish 모양
        return '@';
    }
}

public class OpenChallenge5 {
    char[][] map = new char[10][20]; // 전체 map
    Bear bear; // Bear 객체 생성
    Fish fish; // Fish 객체 생성

    public static void main(String[] args) {
        OpenChallenge5 game = new OpenChallenge5();
        game.run(); // 게임 실행
    }

    public void run() { // 실행
        System.out.println("** Bear의 Fish 먹기 게임을 시작합니다 **");

        bear = new Bear(0, 0, 1); // Bear 초기값
        fish = new Fish((int)(Math.random()*10), (int)(Math.random()*20), 1); // Fish 초기값
        drawMap(); // map 그리기

        int[] moveFishArray = moveFish(); // Fish의 이동 여부 배열 받아옴
        int index = 0; // 배열 인덱스

        while(true) {
            bear.move(); // Bear 이동
            if(moveFishArray[index] == 1) // Fish 이동
                fish.move();

            index++;
            if(index == 5) { // 배열의 처음으로 돌아감
                moveFishArray = moveFish(); // 새로운 배열 받아옴
                index = 0;
            }

            drawMap(); // map 그리기

            if(bear.collide(fish)) { // Bear와 Fish가 충돌했을 경우 승리
                System.out.print("Bears Wins!!");
                break;
            }
        }
    }

    public void drawMap() { // map
        // map 전체 '-'로 초기화
        for(int i=0; i<10; i++)
            for(int k=0; k<20; k++)
                map[i][k] = '-';

        // Bear와 Fish의 위치 업데이트
        map[fish.getX()][fish.getY()] = fish.getShape(); // Fish의 위치를 받아와 배열에 모양 삽입
        map[bear.getX()][bear.getY()] = bear.getShape(); // Bear의 위치를 받아와 배열에 모양 삽입

        // map 그리기
        for(int i=0; i<10; i++) {
            for(int k=0; k<20; k++)
                System.out.print(map[i][k]);
            System.out.println();
        }
    }

    public int[] moveFish() { // Fish의 이동 여부(5번 중 2번만 랜덤 이동)
        int array[] = {0, 0, 0, 0, 0}; // 0으로 초기화(0: 이동하지 않음, 1: 이동)
        int cnt = 0; // 1의 개수

        while(true) {
            int index = (int)(Math.random()*4); // 0 ~ 4의 랜덤 인덱스

            if(array[index] == 0) { // 값이 0인 경우
                array[index] = 1; // 1 삽입
                cnt++; // 1 개수 증가
            }
            if(cnt == 2)
                break;
        }
        return array; // 배열 반환
    }
}